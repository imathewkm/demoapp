package com.mathew.demoapp.response;

import com.google.gson.annotations.SerializedName;
import com.mathew.demoapp.model.Article;

import java.util.List;

public class ArticleResponse {

    @SerializedName("results")
     private List<Article> popularArticles;




    /**
     * This method return the list of article entities
     * @return List of entities
     */
    public List<Article> getPopularArticles() {
        return popularArticles;
    }

    /**
     * This method sets the article entities
     * @param popularArticles - articleslist
     */
    @SuppressWarnings("unused")
    public void setPopularArticles(List<Article> popularArticles) {
        this.popularArticles = popularArticles;
    }


 

}


