package com.abc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.entities.Order;
@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{
	List<Order> findAllByEmail(String email);

}
