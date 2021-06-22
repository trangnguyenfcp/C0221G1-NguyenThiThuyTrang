package com.codegym.model.repository.implement;

import com.codegym.model.entity.Comment;
import com.codegym.model.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class CommentRepository implements ICommentRepository {
    @Override
    public List<Comment> findAll() {
        return BaseRepository.entityManager.createQuery("select s from Comment as s", Comment.class).getResultList();
    }

    @Override
    public Comment findOne(int id) {
        return BaseRepository.entityManager.find(Comment.class,id);
    }

    @Override
    public void save(Comment comment) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(comment);
        entityTransaction.commit();
    }

    @Override
    public Comment increaseLike(int id) {
        Comment comment = findOne(id);
        comment.setNumberOfLikes(comment.getNumberOfLikes()+1);
        return comment;
    }
    @Override
    public void create(Comment comment) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(comment);
        entityTransaction.commit();
    }
}
