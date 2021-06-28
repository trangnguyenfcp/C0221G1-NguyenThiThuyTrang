package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "borrowed_code")
public class BorrowedCode {
    @Id
    @Column(name = "borrowed_code")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowedCode(){

    }
    public BorrowedCode(Long borrowedCode) {
        this.id = borrowedCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
