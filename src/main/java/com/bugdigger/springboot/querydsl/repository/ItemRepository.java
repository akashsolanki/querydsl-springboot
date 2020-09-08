package com.bugdigger.springboot.querydsl.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.bugdigger.springboot.querydsl.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

}
