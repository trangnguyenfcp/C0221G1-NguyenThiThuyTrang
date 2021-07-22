package com.codegym.model.repository;

import com.codegym.model.entity.Question;
import com.codegym.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

public interface IQuestionTypeRepository extends PagingAndSortingRepository<QuestionType, Long> {


}
