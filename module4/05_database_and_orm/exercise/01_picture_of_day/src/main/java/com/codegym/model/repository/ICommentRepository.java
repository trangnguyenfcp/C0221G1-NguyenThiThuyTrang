package com.codegym.model.repository;

import com.codegym.model.entity.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();

    Comment findOne(int id);

    void save(Comment comment);
    Comment increaseLike(int id);
    void create(Comment comment);
}
