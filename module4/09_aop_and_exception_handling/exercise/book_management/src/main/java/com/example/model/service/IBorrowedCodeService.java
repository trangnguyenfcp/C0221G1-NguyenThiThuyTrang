package com.example.model.service;

import com.example.model.entity.BorrowedCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowedCodeService {
    Page<BorrowedCode> findAll(Pageable pageable);

    BorrowedCode findById(Long id);

    void save(BorrowedCode borrowedCode);

    void delete(Long id);
}
