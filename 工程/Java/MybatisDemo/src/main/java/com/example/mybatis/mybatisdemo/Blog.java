package com.example.mybatis.mybatisdemo;

import java.util.ArrayList;

public class Blog {
    int id;
    String name;

    Author author;
    Author subAuthor;

    ArrayList<Article> articles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getSubAuthor() {
        return subAuthor;
    }

    public void setSubAuthor(Author subAuthor) {
        System.out.println("牛逼啊");
        this.subAuthor = subAuthor;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
