package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Long educationDegreeId;
    @Column(name = "education_degree_name")
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private List<Employee> employees;
    public EducationDegree(){

    }
    public EducationDegree(String educationDegreeName, List<Employee> employees) {
        this.educationDegreeName = educationDegreeName;
        this.employees = employees;
    }

    public Long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
