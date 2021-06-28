package com.example.model.service.implement;

import com.example.model.entity.BorrowedCode;
import com.example.model.repository.IBorrowedCodeRepository;
import com.example.model.service.IBookService;
import com.example.model.service.IBorrowedCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowedCodeService implements IBorrowedCodeService {
    @Autowired
    private IBorrowedCodeRepository iBorrowedCodeRepository;
    @Override
    public Page<BorrowedCode> findAll(Pageable pageable) {
        return iBorrowedCodeRepository.findAll(pageable);
    }

    @Override
    public BorrowedCode findById(Long id) {
        return iBorrowedCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowedCode borrowedCode) {
        iBorrowedCodeRepository.save(borrowedCode);
    }

    @Override
    public void delete(Long id) {
            iBorrowedCodeRepository.deleteById(id);
    }
}
