package com.bugdigger.springboot.querydsl.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugdigger.springboot.querydsl.entity.Category;
import com.bugdigger.springboot.querydsl.entity.Item;
import com.bugdigger.springboot.querydsl.entity.QCategory;
import com.bugdigger.springboot.querydsl.entity.QItem;
import com.bugdigger.springboot.querydsl.repository.ItemRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class ItemService {

	@PersistenceContext
	EntityManager em;
	
	
	private ItemRepository itemRepository;
	
	public ItemService(@Autowired ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@PostConstruct
	public void init() {
		Item item = new Item();
		item.setName("Item 1");
		Category category = new Category();
		category.setPriority(1000);
		category.setActive(true);
		item.setCategories(Arrays.asList(category));
		category.setItem(item);
		itemRepository.save(item);
		
		Item item2 = new Item();
		item2.setName("Item 2");
		Category category2 = new Category();
		category2.setPriority(9000);
		category2.setActive(true);
		item2.setCategories(Arrays.asList(category2));
		category2.setItem(item2);
		itemRepository.save(item2);
	}
	
	public List<Item> getItems() {
		QItem item = QItem.item;
		QCategory category = QCategory.category;
		BooleanExpression booleanExpression = item.categories.contains(
		        JPAExpressions.selectFrom(category).
		          where(category.item.eq(item).
		           and(category.priority.eq(1000)
		        		   .and(category.active.eq(true)))));
		return (List<Item>) itemRepository.findAll(booleanExpression);
	}
	
}
