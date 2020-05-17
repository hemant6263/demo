package com.abc.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.demo.domain.Item;
import com.abc.demo.exceptions.ItemNotFoundException;
import com.abc.demo.repository.ItemRepo;
import com.abc.demo.service.ItemService;
import com.abc.pitstop.helper.ItemConverter;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo irep;
	
	@Override
	public List<Item> getItems(String name) {
		List<com.abc.demo.entities.Item> items = irep.findAllByName(name);
		List<Item> itemDtos = items.stream().map(ItemConverter::toDto).collect(Collectors.toList()); 
		return itemDtos;
	}

	@Override
	public void deleteItem(long id) throws ItemNotFoundException {
		if(irep.existsById(id)) {
			irep.deleteById(id);
		}else {
			throw new ItemNotFoundException("no items found");
		}
		
	}

	@Override
	public Item updateItem(Item item) {
		com.abc.demo.entities.Item item2 = ItemConverter.toEntity(item);
		item2 = irep.save(item2);
		item = ItemConverter.toDto(item2);
		return item;
	}

	@Override
	public void createItem(Item item) {
		com.abc.demo.entities.Item item2 = ItemConverter.toEntity(item);
		irep.save(item2);
		
	}

	@Override
	public Item getItem(Long id) throws ItemNotFoundException {
		com.abc.demo.entities.Item item = irep.findById(id).orElseThrow(() ->
		new ItemNotFoundException(""));
		Item item2 = ItemConverter.toDto(item);
		return item2;
	}

}
