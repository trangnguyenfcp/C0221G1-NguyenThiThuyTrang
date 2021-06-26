package com.example.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

public class DAO {
    private String tittle;
    private String summary;
    private String content;
    private String[] blogCategories;

    public DAO(){}
    public DAO(String tittle, String summary, String content, String[] blogCategories) {
        this.tittle = tittle;
        this.summary = summary;
        this.content = content;
        this.blogCategories = blogCategories;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getBlogCategories() {
        return blogCategories;
    }

    public void setBlogCategories(String[] blogCategories) {
        this.blogCategories = blogCategories;
    }
}
