package com.abc.pitstop.helper;

import com.abc.demo.domain.Item;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConverter {

	public static Item toDto(com.abc.demo.entities.Item entity) {
		return (Item) MFUtils.map(entity, Item.class);
	}

	public static com.abc.demo.entities.Item toEntity(Item dto) {
		return (com.abc.demo.entities.Item) MFUtils.map(dto, com.abc.demo.entities.Item.class);
	}
	
}
