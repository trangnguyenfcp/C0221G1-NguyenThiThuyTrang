package com.example.model.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

public class BlogCategory implements Serializable {
    @Column(name = "blog_id")
    Long blogId;
    @Column(name = "category_id")
    Long categoryId;
    @ManyToOne
    @MapsId("blog_id")
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name = "category_id")
    private Category category;

}
