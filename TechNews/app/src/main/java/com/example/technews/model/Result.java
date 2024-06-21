package com.example.technews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
   private int totalResults;
    @SerializedName("articles")
            @Expose
   private List<Article> articlesList=null;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getNewsArticleList() {
        return articlesList;
    }

    public void setArticlesList(List<Article> articlesList) {
        this.articlesList = articlesList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
