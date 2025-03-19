package com.example.videogamev3.UserManagement.Presentation;

import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {
    private String userId;
    private String username;
    private String email;
    private double balance;
    private List<Order> orders;
}
