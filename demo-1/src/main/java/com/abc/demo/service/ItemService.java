package com.abc.demo.service;

import java.util.List;

import com.abc.demo.domain.Item;
import com.abc.demo.exceptions.ItemNotFoundException;

public interface ItemService {

	List<Item> getItems(String name);
	void deleteItem(long id) throws ItemNotFoundException;
	Item updateItem(Item item);
	void createItem(Item item);
	Item getItem(Long id) throws ItemNotFoundException;

}
