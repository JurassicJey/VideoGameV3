package com.example.videogamev3.PurchaseManagement.Presentation;

import com.example.videogamev3.PurchaseManagement.BusinessLogic.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("{uuid}")
    public void addOrder(OrderRequestModel orderRequestModel, @PathVariable String uuid) {
        orderService.addOrder(orderRequestModel, uuid);
    }

}
