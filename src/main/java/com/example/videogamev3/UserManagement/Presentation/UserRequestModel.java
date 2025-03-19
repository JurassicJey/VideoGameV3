package com.example.videogamev3.UserManagement.Presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestModel {
    private String username;
    private String email;
    private String password;
}
