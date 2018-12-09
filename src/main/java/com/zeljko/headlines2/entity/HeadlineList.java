package com.zeljko.headlines2.entity;

import java.util.ArrayList;
import java.util.List;

public class HeadlineList {

   private List<Headline> articles;

    public HeadlineList() {
        articles = new ArrayList<>();
    }

    public List<Headline> getArticles() {
        return articles;
    }

    public void setArticles(List<Headline> articles) {
        this.articles = articles;
    }
}