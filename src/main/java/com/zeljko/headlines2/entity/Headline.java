package com.zeljko.headlines2.entity;

import com.zeljko.headlines2.util.Util;

import javax.persistence.*;

@Entity
public class Headline {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long headlineID;
    private String author;
    private String title;
    @Column(length = 1000)
    private String description;
    private String url;
    @Column(length = 1000)
    private String urlToImage;
    private String publishedAt;


    public Headline() {
    }

    public long getHeadlineID() {
        return headlineID;
    }

    public void setHeadlineID(long headlineID) {
        this.headlineID = headlineID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        this.publishedAt = Util.manipulateDateFormat(publishedAt);
    }


}