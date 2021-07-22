package com.codegym.model.service.implement;

import com.codegym.model.entity.Question;
import com.codegym.model.repository.IQuestionRepository;
import com.codegym.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository iQuestionRepository;

    @Override
    public Page<Question> findAllByTittle(String tittle, Pageable pageable) {
        return iQuestionRepository.findAllByTittle(tittle, pageable);
    }

    @Override
    public void deleteQuestion(Long id) {
        iQuestionRepository.deleteQuestion(id);
    }

    @Override
    public void save(Question question) {
        iQuestionRepository.save(question);
    }

    @Override
    public List<Question> findAllQuestions() {
        return iQuestionRepository.findAllQuestions();
    }

    @Override
    public Question findById(Long id) {
        return iQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Question> findQuestions(String tittle, String name, Pageable pageable) {
        return iQuestionRepository.findQuestions(tittle, name, pageable);
    }

    @Override
    public Question findQuestionById(Long id) {
        return iQuestionRepository.findQuestionById(id);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return iQuestionRepository.findAll(pageable);
    }
}
