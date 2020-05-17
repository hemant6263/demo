package com.abc.demo.domain;

import java.time.LocalDate;
import java.util.List;

import com.abc.demo.domain.Order.OrderBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
	private String email;
	private double total;
	private List<Item> items;  
	

}
