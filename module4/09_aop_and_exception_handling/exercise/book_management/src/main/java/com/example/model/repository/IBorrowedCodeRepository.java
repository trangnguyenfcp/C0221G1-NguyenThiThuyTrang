package com.example.model.repository;

import com.example.model.entity.BorrowedCode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowedCodeRepository extends PagingAndSortingRepository<BorrowedCode, Long> {
}
