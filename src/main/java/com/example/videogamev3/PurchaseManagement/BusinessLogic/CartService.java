package com.example.videogamev3.PurchaseManagement.BusinessLogic;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.PurchaseManagement.DataAccess.Cart;
import com.example.videogamev3.PurchaseManagement.DataAccess.CartRepository;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import com.example.videogamev3.PurchaseManagement.DataAccess.OrderRepository;
import com.example.videogamev3.PurchaseManagement.DataMapper.OrderRequestMapper;
import com.example.videogamev3.PurchaseManagement.Presentation.OrderRequestModel;
import com.example.videogamev3.UserManagement.DataAccess.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;
    private OrderRepository orderRepository;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private final OrderRequestMapper orderRequestMapper;
    private final String USER_MANAGEMENT_BASE_URL = "http://localhost:8080/api/v1/user";
    private final String GAME_MANAGEMENT_BASE_URL = "http://localhost:8080/api/v1/game";
    private final OrderGameClient orderGameClient;


    public void makePurchase(String cartId, String userId) {
        List<String> gameIds = cartRepository.findCartByCartId_Uuid(cartId).getGames();
        List<Game> games = orderGameClient.getGamesFromGameList(gameIds);
        User user = orderGameClient.getUserFromUserManagement(userId);
        double total = 0;
        for(Game game : games){
            total += game.getPrice();
        }

        OrderRequestModel orderRequestModel = new OrderRequestModel(total);
        Order order = orderRequestMapper.orderRequestModelToOrder(orderRequestModel, userId);
        order.setUser(user);


        orderGameClient.putUserBalance(userId, user.getBalance()-total);

    }


}