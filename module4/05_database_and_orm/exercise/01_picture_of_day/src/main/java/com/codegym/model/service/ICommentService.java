package com.codegym.model.service;

import com.codegym.model.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    Comment findOne(int id);

    void save(Comment comment);
    Comment increaseLike(int id);
    void create(Comment comment);
}
