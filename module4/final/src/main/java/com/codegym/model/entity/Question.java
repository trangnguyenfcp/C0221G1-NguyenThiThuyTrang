package com.codegym.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;
    private String tittle;
    private String question;
    private String answer = "N/A";
    @Column(name = "date_create", columnDefinition = "DATE")
    private LocalDate dateCreate;
    private String status = "Chưa phản hồi";
    private int flag=1;
    @ManyToOne()
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id")
    private QuestionType questionType;
    public Question(){

    }
    public Question(String tittle, String question, String answer, LocalDate dateCreate, String status, int flag) {
        this.tittle = tittle;
        this.question = question;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.flag = flag;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
