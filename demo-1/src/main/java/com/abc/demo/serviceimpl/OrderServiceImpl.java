package com.abc.demo.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.demo.domain.Item;
import com.abc.demo.domain.OrderRequest;
import com.abc.demo.entities.Order;
import com.abc.demo.entities.OrderItem;
import com.abc.demo.exceptions.OrderNotFoundException;
import com.abc.demo.repository.OrderItemRepo;
import com.abc.demo.repository.OrderRepository;
import com.abc.demo.service.OrderService;
import com.abc.pitstop.helper.OrderConvoter;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	OrderItemRepo orderIRepo;

	@Override
	public List<com.abc.demo.domain.Order> getAllOrders(String email) {
		List<Order> orders = orderRepo.findAllByEmail(email);
		List<com.abc.demo.domain.Order> orderList = orders.stream().map(OrderConvoter::toDto)
				.collect(Collectors.toList());
		return orderList;
	}

	@Override
	public OrderRequest getOrderById(Long id) throws OrderNotFoundException {
		Optional<Order> order = orderRepo.findById(id);
		Order mainOrder = order.orElseThrow(() -> new OrderNotFoundException("No order found"));
		com.abc.demo.domain.Order order2 = OrderConvoter.toDto(mainOrder);
		List<OrderItem> items = orderIRepo.getAllByOrderId(id);
		List<Item> item = items.stream().map(s -> {
			return Item.builder()
						.name(s.getName())
						.total(s.getTotal())
						.build();
		}).collect(Collectors.toList());
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setItems(item);
		orderRequest.setTotal(mainOrder.getTotal());
		return orderRequest;
	}

	@Override
	public com.abc.demo.domain.Order createOrder(OrderRequest orderRequest) {
		List<Item> items = orderRequest.getItems();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		double total = 0;
		for (Item item : items) {
			total += item.getTotal();
			OrderItem orderItem = new OrderItem();
			orderItem.setName(item.getName());
			orderItem.setTotal(item.getTotal());
			orderItem.setItemId(item.getId());
		}
		com.abc.demo.domain.Order order = new com.abc.demo.domain.Order();
		order.setTotal(total);
		order.setOrderDate(LocalDate.now());
		Order order2 = OrderConvoter.toEntity(order);
		order2 = orderRepo.save(order2);
		for (OrderItem item : orderItems) {
			item.setOrderId(order2.getId());
			orderIRepo.save(item);
		}
		return null;
	}

}
