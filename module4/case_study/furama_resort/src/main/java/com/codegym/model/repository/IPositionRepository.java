package com.codegym.model.repository;

import com.codegym.model.entity.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position, Long> {
}
