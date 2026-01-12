package com.example.search.service;

import com.example.search.dto.SearchResult;
import com.example.search.model.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    private final IndexService indexService;

    public SearchService(IndexService indexService) {
        this.indexService = indexService;
    }

    public List<SearchResult> search(String query) {

        String[] terms = query.toLowerCase().split("\\W+");
        Map<Long, Double> scores = new HashMap<>();
        int totalDocs = indexService.getDocuments().size();

        for (String term : terms) {
            Map<Long, Integer> postings =
                    indexService.getInvertedIndex().get(term);

            if (postings == null) continue;

            double idf = Math.log((double) totalDocs / postings.size());

            for (Map.Entry<Long, Integer> entry : postings.entrySet()) {
                double tf = entry.getValue();
                scores.merge(entry.getKey(), tf * idf, Double::sum);
            }
        }

        List<SearchResult> results = new ArrayList<>();

        for (Map.Entry<Long, Double> entry : scores.entrySet()) {
            Document doc = indexService.getDocuments().get(entry.getKey());
            results.add(new SearchResult(
                    doc.getId(),
                    doc.getTitle(),
                    entry.getValue()
            ));
        }

        results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
        return results;
    }
}
