package com.codegym.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String author;
    private String feedback;
    @Column(name = "number_of_likes",columnDefinition = "INT")
    private int numberOfLikes;
    @Column(name = "comment_time",columnDefinition = "DATE")
    private Date commentTime = new Date(System.currentTimeMillis());

    public Comment(){

    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Comment(int rating, String author, String feedback, int numberOfLikes, Date commentTime) {
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.numberOfLikes = numberOfLikes;
        this.commentTime = commentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }
}
