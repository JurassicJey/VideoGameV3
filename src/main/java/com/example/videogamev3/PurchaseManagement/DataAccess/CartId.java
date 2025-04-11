package com.example.videogamev3.PurchaseManagement.DataAccess;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartId {
    @Column(name = "cartId")
    private String uuid;
}
