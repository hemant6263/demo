package com.abc.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString(callSuper = true)
public class Item {
	
	private long id;
	private String name;
	private double total;
	private double subTotal;
	private double offerTotal;
	
	
}
