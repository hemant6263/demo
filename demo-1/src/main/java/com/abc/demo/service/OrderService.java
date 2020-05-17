package com.abc.demo.service;

import java.util.List;

import com.abc.demo.domain.Order;
import com.abc.demo.domain.OrderRequest;
import com.abc.demo.exceptions.OrderNotFoundException;

public interface OrderService {

	List<Order> getAllOrders(String email);

	OrderRequest getOrderById(Long id) throws OrderNotFoundException;
	
	Order createOrder(OrderRequest orderRequest);
}