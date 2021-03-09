package com.mathew.demoapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.mathew.demoapp.R;

import com.mathew.demoapp.adapter.SearchAdapter;
import com.mathew.demoapp.adapter.TopStoryAdapter;
import com.mathew.demoapp.model.Article;
import com.mathew.demoapp.response.Doc;
import com.mathew.demoapp.view_model.ArticleViewModel;
import com.mathew.demoapp.view_model.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private RecyclerView my_recycler_view;
    private ProgressBar progress_circular_movie_article;
    private LinearLayoutManager layoutManager;
    private TopStoryAdapter adapter;
    private ArrayList<Article> articleArrayList = new ArrayList<>();

    private ArrayList<Doc> searchArrayList = new ArrayList<Doc>();


    ArticleViewModel articleViewModel;
    SearchViewModel searchViewModel;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
       getTopArticles();
      //  getSearchArticles("");


    }

    private void initialization() {
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        searchView = (SearchView)findViewById(R.id.search);


        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);


        my_recycler_view.setHasFixedSize(true);

        // adapter
        adapter = new TopStoryAdapter(MainActivity.this, articleArrayList);
        my_recycler_view.setAdapter(adapter);

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){

                getSearchArticles(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){



                getSearchArticles(newText);

                return false;
            }
        });



    }

    private void getTopArticles() {
        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {

                progress_circular_movie_article.setVisibility(View.GONE);
                List<Article> articles = articleResponse.getPopularArticles();
                articleArrayList.clear();
                articleArrayList.addAll(articles);

                adapter.notifyDataSetChanged();
            }
        });
    }


       private void getSearchArticles(String query) {
          searchViewModel.getsearcharticleResponseLiveData(query) .observe(this, SearchArticleResponse -> {
            if (SearchArticleResponse!= null) {
                progress_circular_movie_article.setVisibility(View.GONE);
                List<Doc> articles =SearchArticleResponse.getResponse().getDocs();
                searchArrayList.clear();
                searchArrayList.addAll(articles);
              SearchAdapter adapter_search = new SearchAdapter(MainActivity.this, searchArrayList);
                my_recycler_view.setAdapter(adapter_search);
                adapter.notifyDataSetChanged();
            }
        });
    }





}
