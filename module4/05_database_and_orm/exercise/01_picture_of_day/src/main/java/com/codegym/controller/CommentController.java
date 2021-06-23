package com.codegym.controller;

import com.codegym.model.entity.Comment;
import com.codegym.model.repository.ICommentRepository;
import com.codegym.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping(value = "/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping(value = "")
    public String showList(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());
        return "index";
    }

    @GetMapping(value = "{id}")
    public String increaseLikes(@PathVariable int id, Model model){
        Comment comment = commentService.increaseLike(id);
        commentService.save(comment);
        model.addAttribute("comments",commentService.findAll());
        return "index";
    }
    @PostMapping
    public String save(@ModelAttribute("comment") Comment comment){
        commentService.create(comment);
        return "redirect:/comments";
    }
}
