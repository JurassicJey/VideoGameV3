package com.example.videogamev3.PurchaseManagement.Presentation;

import com.example.videogamev3.PurchaseManagement.BusinessLogic.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@AllArgsConstructor
public class OrderController {
    private CartService cartService;

    @GetMapping("{cart_id}/user/{user_id}")
    public void makeOrder(@PathVariable String cart_id, @PathVariable String user_id) {
        cartService.makePurchase(cart_id, user_id);
    }

    @PostMapping("{cart_id}/game/{game_id}")
    public void addGameToCart(@PathVariable String cart_id, @PathVariable String game_id) {
        cartService.addGame(cart_id, game_id);
    }
}
