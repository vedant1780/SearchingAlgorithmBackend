package com.example.search.dto;

public class SearchResult {
    private Long id;
    private String title;
    private double score;

    public SearchResult(Long id, String title, double score) {
        this.id = id;
        this.title = title;
        this.score = score;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getScore() { return score; }
}
