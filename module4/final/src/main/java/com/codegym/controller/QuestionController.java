package com.codegym.controller;

import com.codegym.dto.QuestionDto;
import com.codegym.model.entity.Question;
import com.codegym.model.entity.QuestionType;
import com.codegym.model.service.IQuestionService;
import com.codegym.model.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IQuestionTypeService questionTypeService;
    @ModelAttribute("questionTypes")
    public Iterable<QuestionType> questionTypes(){
        return questionTypeService.findAll();
    }
//    @GetMapping(value = { ""})
//    public ModelAndView listQuestions(@RequestParam("search") Optional<String> search,
//                                      @PageableDefault(value = 2) Pageable pageable){
//
//        String searchValue = "";
//        if (search.isPresent()){
//            searchValue = search.get();
//        }
//
//        ModelAndView modelAndView = new ModelAndView("question/list");
//        Page<Question> questions = questionService.findAllByTittle(searchValue,pageable);
//        modelAndView.addObject("searchValue", searchValue);
//        modelAndView.addObject("questions",questions);
//        return modelAndView;
//    }
    @GetMapping(value = { ""})
    public ModelAndView listQuestions(@RequestParam("searchTittle") Optional<String> searchTittle,
                                      @RequestParam("searchName") Optional<String> searchName,
                                      @PageableDefault(value = 2) Pageable pageable){

        String searchTittleValue = "";
        String searchNameValue = "";
        if (searchTittle.isPresent() && searchName.isPresent()){
            searchTittleValue = searchTittle.get();
            if (searchName.get() == "chọn"){
                searchNameValue = "";
            }else {
                searchNameValue = searchName.get();

            }

        }
        Page<Question> questions = questionService.findQuestions(searchTittleValue, searchNameValue, pageable);
        ModelAndView modelAndView = new ModelAndView("question/list2");

        modelAndView.addObject("searchTittleValue", searchTittleValue);
        modelAndView.addObject("searchNameValue", searchNameValue);
        modelAndView.addObject("questions",questions);
        return modelAndView;
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("question", new QuestionDto());
        return "question/create";
    }
    @PostMapping(value = "/create")
    public String saveQuestion(Model model, @Valid @ModelAttribute("question") QuestionDto questionDto, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()){
            model.addAttribute("question", questionDto);
            model.addAttribute("message", "Created failed");

            return "question/create";

        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        questionService.save(question);
        return "redirect:/question/";
    }
    @GetMapping("/delete")
    public String deleteQuestion(@RequestParam("id") Long id){
        try {
            this.questionService.deleteQuestion(id);
        }catch (Exception e){
            return "question/message";
        }
        return "redirect:/question/";
    }
    @GetMapping(value = "/view/{id}")
    public String showView(Model model, @PathVariable("id") Long id){
        if (questionService.findQuestionById(id) == null){
            return "question/message";
        }
        model.addAttribute("question", questionService.findQuestionById(id));
        return "question/view";
    }

}
