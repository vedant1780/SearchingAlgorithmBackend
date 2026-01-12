package com.example.search.controller;

import com.example.search.dto.SearchResult;
import com.example.search.model.Document;
import com.example.search.repository.DocumentRepository;
import com.example.search.service.IndexService;
import com.example.search.service.SearchService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class SearchController {

    private final SearchService searchService;
    private final IndexService indexService;
    private final DocumentRepository documentRepository;

    public SearchController(SearchService searchService,
                            IndexService indexService,
                            DocumentRepository documentRepository) {
        this.searchService = searchService;
        this.indexService = indexService;
        this.documentRepository = documentRepository;
    }

    @PostConstruct
    public void loadFromDatabase() {

        // Insert sample data only once
        if (documentRepository.count() == 0) {
            documentRepository.save(new Document(
                    "Spring Boot Search API",
                    "Backend search implementation with ranking"));

            documentRepository.save(new Document(
                    "TF IDF Ranking Algorithm",
                    "Search backend using tf idf ranking"));

            documentRepository.save(new Document(
                    "REST API with Spring Boot",
                    "Build backend APIs using Spring Boot"));
        }

        // Fetch from DB and index
        indexService.indexAll(documentRepository.findAll());
    }

    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String q) {
        return searchService.search(q);
    }
}
