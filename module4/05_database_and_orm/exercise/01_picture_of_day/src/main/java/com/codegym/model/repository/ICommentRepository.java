package com.codegym.model.repository;

import com.codegym.model.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICommentRepository {
    List<Comment> findAll();

    Comment findOne(int id);

    void save(Comment comment);
    Comment increaseLike(int id);
    void create(Comment comment);
}
