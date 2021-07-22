package com.codegym.model.service;

import com.codegym.model.entity.QuestionType;

public interface IQuestionTypeService {
    Iterable<QuestionType> findAll();
}
