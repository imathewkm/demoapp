package com.mathew.demoapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mathew.demoapp.response.ArticleResponse;
import com.mathew.demoapp.response.SearchArticleResponse;
import com.mathew.demoapp.retrofit.ApiRequest;
import com.mathew.demoapp.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getMovieArticles(String query, String key) {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getTopArticles( key)
                .enqueue(new Callback<ArticleResponse>() {


                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                       //    Log.d(TAG, "articles  result:: " + response.body().getPopularArticles().get(0).getmAbstract());

                         //   Log.d(TAG, "articles size:: " + response.body().getPopularArticles().get(0).getmMedia().get(0).getUrl());
                         //   Log.d(TAG, "articles title pos 0:: " + response.body().getPopularArticles().get(0).getUrl());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                    //    data.setValue(null);
                    }
                });
        return data;
    }





    public LiveData<SearchArticleResponse> getSearchArticles(String query, String key) {
        final MutableLiveData<SearchArticleResponse> data = new MutableLiveData<>();


        apiRequest.getSearchArticles(query,  key)
                .enqueue(new Callback<SearchArticleResponse>() {
                    
                    


                    @Override
                    public void onResponse(Call<SearchArticleResponse > call, Response<SearchArticleResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);


                        data.setValue(response.body());
                        if (response.body() != null) {
                      //      Log.d(TAG, "articles  ABST:: " + response.body().getPopularArticles().size());




                          // Log.d(TAG, "articles size:: " + response.body().getPopularArticles().get(0).getmMedia().get(0).getUrl());
                           // Log.d(TAG, "articles title pos 0:: " + response.body().getPopularArticles().get(0).getUrl());
                        }
                    }

                    @Override
                    public void onFailure(Call<SearchArticleResponse> call, Throwable t) {
                           //data.setValue(null);
                    }
                });
        return data;
    }

}
