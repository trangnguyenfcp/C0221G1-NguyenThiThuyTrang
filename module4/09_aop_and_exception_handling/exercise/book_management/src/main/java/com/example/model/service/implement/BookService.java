package com.example.model.service.implement;

import com.example.model.entity.Book;
import com.example.model.repository.IBookRepository;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
            iBookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        iBookRepository.deleteById(id);
    }
}
