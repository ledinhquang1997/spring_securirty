package com.demo.security.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    private String username;
    private String encrytedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "accout_username"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles=new ArrayList<>();

    public Account() {
    }

    public Account(String username, String encrytedPassword) {
        this.username = username;
        this.encrytedPassword = encrytedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
