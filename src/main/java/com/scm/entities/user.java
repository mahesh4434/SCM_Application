package com.scm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "user")
@Table(name = "users")
public class user {
    private String userId;
    private String name;
    private String email;
    private String password;

}
