package com.seth.ecom.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seth.ecom.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findAll();

}
