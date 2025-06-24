package com.seth.travelmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seth.travelmanager.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findAll();
}
