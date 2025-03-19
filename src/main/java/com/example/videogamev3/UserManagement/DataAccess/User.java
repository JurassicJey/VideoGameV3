package com.example.videogamev3.UserManagement.DataAccess;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @EmbeddedId
    private UserId id;
    private String username;
    private String email;
    private String password;
    private double balance;
}
