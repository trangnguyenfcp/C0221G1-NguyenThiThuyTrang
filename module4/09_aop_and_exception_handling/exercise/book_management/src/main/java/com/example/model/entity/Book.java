package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<BorrowedCode> borrowedCodes;
    public Book(){

    }
    public Book(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowedCode> getBorrowedCodes() {
        return borrowedCodes;
    }

    public void setBorrowedCodes(List<BorrowedCode> borrowedCodes) {
        this.borrowedCodes = borrowedCodes;
    }
}
