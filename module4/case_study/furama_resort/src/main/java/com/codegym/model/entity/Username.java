package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "username")
public class Username {
    @Id
    private String username;
    private String password;
    @OneToMany(mappedBy = "username")
    private List<Employee> employees;
    @OneToMany(mappedBy = "username")
    private List<UserRole> userRoles;
    public Username(){

    }
    public Username(String username, String password, List<Employee> employees, List<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.employees = employees;
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
