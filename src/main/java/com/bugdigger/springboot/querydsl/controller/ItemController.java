package com.bugdigger.springboot.querydsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugdigger.springboot.querydsl.entity.Item;
import com.bugdigger.springboot.querydsl.repository.ItemRepository;
import com.bugdigger.springboot.querydsl.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<Item> getItems() {
		return (List<Item>) itemService.getItems();
	}
	
}
