package com.codegym.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long userRoleId;
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    @ManyToOne()
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Username username;
    public UserRole(){

    }
    public UserRole(Role role, Username username) {
        this.role = role;
        this.username = username;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }
}
