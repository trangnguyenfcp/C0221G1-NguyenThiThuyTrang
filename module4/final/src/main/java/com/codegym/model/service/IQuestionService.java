package com.codegym.model.service;

import com.codegym.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IQuestionService {
    Page<Question> findAllByTittle(String tittle, Pageable pageable);
    void deleteQuestion(Long id);
    void save(Question question);
    List<Question> findAllQuestions();
    Page<Question> findAll(Pageable pageable);
    Question  findById(Long id);
    Page<Question> findQuestions(String tittle, String name, Pageable pageable);
    Question  findQuestionById(Long id);


}
