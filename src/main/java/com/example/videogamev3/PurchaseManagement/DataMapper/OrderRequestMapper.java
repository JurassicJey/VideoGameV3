package com.example.videogamev3.PurchaseManagement.DataMapper;


import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.GameManagement.DataAccess.GameId;
import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import com.example.videogamev3.PurchaseManagement.DataAccess.OrderId;
import com.example.videogamev3.PurchaseManagement.Presentation.OrderRequestModel;
import com.example.videogamev3.UserManagement.DataAccess.UserId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, OrderId.class, LocalDateTime.class, UserId.class })
public interface OrderRequestMapper {
    @Mapping(target = "orderId", expression = "java(new OrderId(UUID.randomUUID().toString()))")
    @Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "totalPrice", expression = "java(orderRequestModel.getTotalPrice())")
    @Mapping(target = "user", ignore = true)
    Order orderRequestModelToOrder(OrderRequestModel orderRequestModel, String uuid);
}
