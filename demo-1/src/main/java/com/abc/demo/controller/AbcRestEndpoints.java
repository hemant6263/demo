package com.abc.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.demo.domain.Item;
import com.abc.demo.domain.Order;
import com.abc.demo.domain.OrderRequest;
import com.abc.demo.exceptions.ItemNotFoundException;
import com.abc.demo.exceptions.OrderNotFoundException;
import com.abc.demo.service.ItemService;
import com.abc.demo.service.OrderService;

@RestController
@RequestMapping("/abc")
public class AbcRestEndpoints {
	@Autowired
	OrderService impl;

	@Autowired
	ItemService itemService;

	@PostMapping("/createitem")
	public ResponseEntity<?> addUser(@Valid Item item, BindingResult result) {
		ResponseEntity<?> entity = null;
		if (result.hasErrors()) {
			entity = new ResponseEntity<>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
			return entity;
		} else {
			itemService.createItem(item);
			entity = new ResponseEntity<>(null, HttpStatus.OK);
		}
		return entity;
	}

	@GetMapping("/getItems")
	public ResponseEntity<?> getItem(String name) {
		{
			List<Item> items = itemService.getItems(name);
			return new ResponseEntity<>(items, HttpStatus.OK);
		}

	}

	@GetMapping("/deleteItem")
	public ResponseEntity<?> deleteItem(@RequestParam("itemId")Long id) {
		try {
			itemService.deleteItem(id);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping("/updateItem")
	public ResponseEntity<?> updateItem(@Valid Item item, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError(), HttpStatus.BAD_REQUEST);
		}
		Item item2 = itemService.updateItem(item);
		return new ResponseEntity<>(item2, HttpStatus.OK);
	}

	@GetMapping("/getItem")
	public ResponseEntity<?> getItem(@RequestParam("itemId")Long itemId) {
		Item item = null;
		try {
			item = itemService.getItem(itemId);
		} catch (ItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@PostMapping("/createorder")
	public ResponseEntity<?> order(@RequestBody @Valid OrderRequest orderRequest,BindingResult result) throws Exception {
		ResponseEntity<?> entity = null;
		if (result.hasErrors()) {
			entity = new ResponseEntity<>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
			return entity;
		} else {
			impl.createOrder(orderRequest);
		}
		return entity;
	}

	@GetMapping("/getOrders")
	public ResponseEntity<?> getAllOrders(@RequestParam("email")String email) {
		ResponseEntity<?> entity = null;
		List<Order> orders = impl.getAllOrders(email);
		entity = new ResponseEntity<>(orders, HttpStatus.OK);
		return entity;
	}

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomerOrderByOrderId(@PathVariable("orderId") long orderId)
			throws OrderNotFoundException {
		ResponseEntity<?> entity = null;
		OrderRequest orders = impl.getOrderById(orderId);
		entity = new ResponseEntity<>(orders, HttpStatus.OK);
		return entity;
	}
}
