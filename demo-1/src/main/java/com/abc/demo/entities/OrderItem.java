package com.abc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "orderitem")
public class OrderItem extends AbstractEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "total")
	private double total;
	@Column(name = "sub_total")
	private String subTotal;
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "item_id")
	private long itemId;
	@Column(name = "offer_total")
	private String offerTotal;
	
}
