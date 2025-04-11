package com.example.videogamev3.PurchaseManagement.DataAccess;

import com.example.videogamev3.PurchaseManagement.DataAccess.Cart;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, String> {
    Cart findCartByCartId_Uuid(String cartId);
}
