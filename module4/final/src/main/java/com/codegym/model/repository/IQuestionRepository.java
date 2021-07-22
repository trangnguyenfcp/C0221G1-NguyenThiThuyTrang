package com.codegym.model.repository;

import com.codegym.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IQuestionRepository extends PagingAndSortingRepository<Question, Long> {
    @Query(value = "select c from Question c where c.tittle like %?1%  and c.flag = 1",nativeQuery = false)
    Page<Question> findAllByTittle(String tittle, Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "update question set flag = 0 where question_id = ?1",nativeQuery = true)
    void deleteQuestion(Long id);
    @Query(value = "select * from question where flag = 1",nativeQuery = true)
    List<Question> findAllQuestions();
    @Query(value = "select c from Question c where c.tittle like %?1% and c.questionType.questionTypeName like %?2% and c.flag = 1 order by c.status asc , c.dateCreate desc ",nativeQuery = false)
    Page<Question> findQuestions(String tittle, String name, Pageable pageable);
    @Query(value = "select c from Question c where c.questionId = ?1  and c.flag = 1",nativeQuery = false)
    Question  findQuestionById(Long id);
}
