package com.mathew.demoapp.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mathew.demoapp.repository.ArticleRepository;
import com.mathew.demoapp.response.SearchArticleResponse;

import static com.mathew.demoapp.constants.AppConstant.API_KEY;

public class SearchViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;

    private LiveData<SearchArticleResponse> searcharticleResponseLiveData;

    private String key;

    public SearchViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();



    }


    public LiveData<SearchArticleResponse> getsearcharticleResponseLiveData(String q) {
        this.searcharticleResponseLiveData = articleRepository.getSearchArticles(q, API_KEY);
       // this.key=q;
        return searcharticleResponseLiveData;
    }


}
