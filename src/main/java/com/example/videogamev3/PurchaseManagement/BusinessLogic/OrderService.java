package com.example.videogamev3.PurchaseManagement.BusinessLogic;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import com.example.videogamev3.PurchaseManagement.DataAccess.OrderRepository;
import com.example.videogamev3.PurchaseManagement.DataMapper.OrderRequestMapper;
import com.example.videogamev3.PurchaseManagement.Presentation.OrderRequestModel;
import com.example.videogamev3.UserManagement.DataAccess.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
  private OrderRepository orderRepository;
  private final OrderGameClient orderGameClient;
  private final OrderRequestMapper orderRequestMapper;

  public OrderService(OrderRepository orderRepository, RestTemplate restTemplate, ObjectMapper objectMapper,
      OrderRequestMapper orderRequestMapper, OrderGameClient orderGameClient) {
    this.orderRepository = orderRepository;
    this.orderRequestMapper = orderRequestMapper;
    this.orderGameClient = orderGameClient;
  }

//  adds order to user
  public void addOrder(OrderRequestModel orderRequestModel, String uuid) {
    Order order = orderRequestMapper.orderRequestModelToOrder(orderRequestModel, uuid);
    User user = orderGameClient.getUserFromUserManagement(uuid);
    order.setUser(user);
    orderRepository.save(order);
  }

}
