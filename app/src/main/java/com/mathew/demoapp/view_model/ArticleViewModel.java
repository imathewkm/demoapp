package com.mathew.demoapp.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mathew.demoapp.repository.ArticleRepository;
import com.mathew.demoapp.response.ArticleResponse;

import static com.mathew.demoapp.constants.AppConstant.API_KEY;
import static com.mathew.demoapp.constants.AppConstant.ARTICLE_QUERY;


public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;



    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(ARTICLE_QUERY, API_KEY);



    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }





}
