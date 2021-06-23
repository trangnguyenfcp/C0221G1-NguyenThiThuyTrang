package com.codegym.model.service.implement;

import com.codegym.model.entity.Comment;
import com.codegym.model.repository.ICommentRepository;
import com.codegym.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository iCommentRepository;
    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public Comment findOne(int id) {
        return iCommentRepository.findOne(id);
    }

    @Override
    public void save(Comment comment) {
iCommentRepository.save(comment);
    }

    @Override
    public Comment increaseLike(int id) {
        return iCommentRepository.increaseLike(id);
    }

    @Override
    public void create(Comment comment) {
iCommentRepository.create(comment);
    }
}
