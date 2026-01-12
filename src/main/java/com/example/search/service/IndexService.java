package com.example.search.service;

import com.example.search.model.Document;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {

    private final Map<String, Map<Long, Integer>> invertedIndex = new HashMap<>();
    private final Map<Long, Document> documents = new HashMap<>();

    public void indexAll(List<Document> docs) {
        invertedIndex.clear();
        documents.clear();

        for (Document doc : docs) {
            documents.put(doc.getId(), doc);
            index(doc);
        }
    }

    private void index(Document doc) {
        String text = (doc.getTitle() + " " + doc.getContent()).toLowerCase();
        String[] tokens = text.split("\\W+");

        for (String token : tokens) {
            invertedIndex
                    .computeIfAbsent(token, k -> new HashMap<>())
                    .merge(doc.getId(), 1, Integer::sum);
        }
    }

    public Map<String, Map<Long, Integer>> getInvertedIndex() {
        return invertedIndex;
    }

    public Map<Long, Document> getDocuments() {
        return documents;
    }
}
