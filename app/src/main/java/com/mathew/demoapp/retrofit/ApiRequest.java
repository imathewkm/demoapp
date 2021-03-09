package com.mathew.demoapp.retrofit;


import com.mathew.demoapp.response.ArticleResponse;
import com.mathew.demoapp.response.SearchArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiRequest {


   // private final String SEARCH_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json";
  //
    @GET("svc/topstories/v2/home.json")
    Call<ArticleResponse> getTopArticles(
            @Query("api-key") String apiKey
    );

   // @GET("svc/topstories/v2/arts.json")

    @GET("svc/search/v2/articlesearch.json")
    Call<SearchArticleResponse> getSearchArticles(
         @Query("q") String query,
            @Query("api-key") String apiKey
    );

}

  //  https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=VcBFXEuNRgqS8E1E9TkeTddTxUSsX5oR