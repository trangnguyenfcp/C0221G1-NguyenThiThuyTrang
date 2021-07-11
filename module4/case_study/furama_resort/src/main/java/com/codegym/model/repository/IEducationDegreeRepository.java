package com.codegym.model.repository;

import com.codegym.model.entity.EducationDegree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends PagingAndSortingRepository<EducationDegree, Long> {
}
