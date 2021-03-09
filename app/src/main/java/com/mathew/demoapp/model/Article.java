package com.mathew.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article {


    public String getmAbstract() {
        return mAbstract;
    }

    public void setmAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }


    public List<Multimedia> getmMedia() {
        return mMedia;
    }

    public void setmMedia(List<Multimedia> mMedia) {
        this.mMedia = mMedia;
    }

    @SerializedName("multimedia")
    public List<Multimedia> mMedia;


    @SerializedName("abstract")
    private String mAbstract;

    public String getPublishedby() {
        return publishedby;
    }

    public void setPublishedby(String publishedby) {
        this.publishedby = publishedby;
    }

    @SerializedName("byline")
    private String publishedby;

    private String title;

    public Article(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    private String urlToImage;
    private String publishedAt;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
