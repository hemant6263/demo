package com.abc.pitstop.helper;

import com.abc.demo.domain.Order;
import com.abc.demo.domain.Item;

public class OrderConvoter {
	public static Order toDto(com.abc.demo.entities.Order entity) {
		return (Order) MFUtils.map(entity, Order.class);
	}

	public static com.abc.demo.entities.Order toEntity(Order dto) {
		return ( com.abc.demo.entities.Order) MFUtils.map(dto, Order.class);
	}
}
