package com.example.videogamev3.PurchaseManagement.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
