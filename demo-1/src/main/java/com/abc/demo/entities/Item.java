package com.abc.demo.entities;

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
@Table(name = "item")
public class Item extends AbstractEntity {
	@Column(name = "name")
	private String name;
	@Column(name = "total")
	private String total;
	@Column(name = "sub_total")
	private String subTotal;
	@Column(name = "offer_total")
	private String offerTotal;
	
}
