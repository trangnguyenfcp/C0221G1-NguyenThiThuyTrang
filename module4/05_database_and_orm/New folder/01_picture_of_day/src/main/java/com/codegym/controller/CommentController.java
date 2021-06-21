package com.codegym.controller;

import com.codegym.model.entity.Comment;
import com.codegym.model.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;



@Controller
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    private ICommentRepository commentRepository;
    @GetMapping(value = "")
    public String showList(Model model) {
        List<Comment> comments = commentRepository.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "index";
    }

    @GetMapping(value = "{id}")
    public String increaseLikes(@PathVariable int id, Model model){
        Comment comment = commentRepository.increaseLike(id);
        commentRepository.save(comment);
        model.addAttribute("comments",commentRepository.findAll());
        return "index";
    }
    @PostMapping
    public String save(Comment comment){
        commentRepository.create(comment);
        return "redirect:/comments";
    }
}
