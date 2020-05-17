package com.abc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.entities.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{

	List<OrderItem> getAllByOrderId(Long id);
}
