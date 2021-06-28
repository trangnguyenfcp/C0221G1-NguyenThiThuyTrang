package com.example.controller;

import com.example.model.entity.Book;
import com.example.model.entity.BorrowedCode;
import com.example.model.service.IBookService;
import com.example.model.service.IBorrowedCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired

    private IBorrowedCodeService borrowedCodeService;
    @GetMapping( "/home")
    public String home(){
        return "index";
    }
    @GetMapping(value = "/borrow")
    public String showBooks(Model model, Pageable pageable){
        model.addAttribute("books", bookService.findAll(pageable));
        return "/list";
    }
    @GetMapping("/borrow-book/{id}")
    public String setBorrowBook(@PathVariable Long id, Model model) throws Exception {
        Book book = bookService.findById(id);
        if (book.getQuantity()>0){
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            Long borrowId = Math.round(Math.random()*100000);
            BorrowedCode borrowedCode =  new BorrowedCode(borrowId);
            borrowedCode.setBook(book);
            borrowedCodeService.save(borrowedCode);
            model.addAttribute("borrowedCode", borrowedCode);
            return "/show_borrowed_code";
        }else {
            throw new Exception();
        }
    }
    @GetMapping(value = "/return")
    public String showReturnBook(Model model){
        model.addAttribute("borrowedCode", new BorrowedCode());
        return "return";
    }
    @PostMapping(value = "return")
    public String setReturnBook(Model model, @ModelAttribute BorrowedCode borrowedCode) throws Exception {
        if (borrowedCodeService.findById(borrowedCode.getId()) == null){
           throw new Exception();
        }
        Book book = borrowedCodeService.findById(borrowedCode.getId()).getBook();
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        borrowedCodeService.delete(borrowedCode.getId());
        model.addAttribute("message", "return book completely");
            return "return";
    }
    @ExceptionHandler(Exception.class)
    public String handleBookException(){
        return "error";
    }

}
