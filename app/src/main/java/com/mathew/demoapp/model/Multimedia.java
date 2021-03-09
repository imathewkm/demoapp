package com.mathew.demoapp.model;

import com.google.gson.annotations.SerializedName;

public class Multimedia {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("url")
    private String url;

    public String getMabstract() {
        return mabstract;
    }

    public void setMabstract(String mabstract) {
        this.mabstract = mabstract;
    }

    @SerializedName("abstract")
    private String mabstract;




}
