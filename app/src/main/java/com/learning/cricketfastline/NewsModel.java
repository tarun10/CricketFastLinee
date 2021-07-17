package com.learning.cricketfastline;

public class NewsModel {

    public int image;
    public String title;
    public String news;

    public NewsModel(int image, String title, String news) {
        this.image = image;
        this.title = title;
        this.news = news;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
