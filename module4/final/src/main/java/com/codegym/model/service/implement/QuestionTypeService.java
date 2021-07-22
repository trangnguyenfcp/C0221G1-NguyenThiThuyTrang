package com.codegym.model.service.implement;

import com.codegym.model.entity.QuestionType;
import com.codegym.model.repository.IQuestionTypeRepository;
import com.codegym.model.service.IQuestionService;
import com.codegym.model.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }
}
