package com.seth.travelmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.travelmanager.models.Item;
import com.seth.travelmanager.repositories.ItemRepository;

@Service
public class ItemService {
	// Member variable that contains all our CRUD tools
	private final ItemRepository itemRepo;

	public ItemService(ItemRepository iR) {
		this.itemRepo = iR;
	}

	// CRUD----------

	// Create
	public Item create(Item i) {
		return itemRepo.save(i);
	}

	// Read All
	public List<Item> getAll() {
		return itemRepo.findAll();
	}

	// Read One
	public Item getOne(Long id) {
		Optional<Item> optItem = itemRepo.findById(id);

		if (optItem.isPresent()) {
			return optItem.get();
		} else {
			return null;
		}
	}

	// Update
	public Item update(Item i) {
		return itemRepo.save(i);
	}

	// Delete
	public void delete(Long id) {
		itemRepo.deleteById(id);
	}

}
