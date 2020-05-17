package com.abc.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "order")
public class Order extends AbstractEntity {
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "total")
	private Double total;
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name = "email")
	private String email;

}
