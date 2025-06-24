package com.seth.ecom.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.ecom.models.Item;
import com.seth.ecom.repositories.ItemRepository;

@Service
public class ItemService {
	// Member variable that contains all our CRUD tools
	private final ItemRepository itemRepo;

	public ItemService(ItemRepository iR) {
		this.itemRepo = iR;
	}

	// CRUD---------------

	// Create
	public Item create(Item i){
		return itemRepo.save(i);
	}
	
	// Read One
	public Item getOne(Long id) {
		Optional<Item> optItem = itemRepo.findById(id);
		
		if(optItem.isPresent()) {
			return optItem.get();
		}else {
			return null;
		}
	}
	
	// Read All
	public List<Item> getAll(){
		return itemRepo.findAll();
	}
}
