package com.abc.demo.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.abc.demo.entities.AbstractEntity;
import com.abc.demo.validator.AllowedTotal;
import com.sun.istack.NotNull;

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
public class Order extends AbstractEntity {
	@NotNull
	@Email
	private String email;
	private String name;
	@AllowedTotal(fieldName = "total")
	private Double total;
	private LocalDate orderDate;	

}
