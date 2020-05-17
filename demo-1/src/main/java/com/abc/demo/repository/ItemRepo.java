package com.abc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.demo.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

	List<Item> findAllByName(String name);

}
