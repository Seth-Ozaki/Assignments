package com.seth.burgertrack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.burgertrack.models.Burger;
import com.seth.burgertrack.repositories.BurgerRepository;

@Service
public class BurgerService {
	// Member variable that contains all our CRUD tools
	private final BurgerRepository BurgerRepo;

	public BurgerService(BurgerRepository bR) {
		this.BurgerRepo = bR;
	}

	// Create
	public Burger createBurger(Burger b) {
		return BurgerRepo.save(b);
	}

	// Read All
	public List<Burger> getAllBurgers() {
		return BurgerRepo.findAll();
	}

	// Read One
	public Burger getOneBurger(Long id) {
		Optional<Burger> optBurger = BurgerRepo.findById(id);

		if (optBurger.isPresent()) {
			return optBurger.get();
		} else {
			return null;
		}
	}

	// Update
	public Burger updateBurger(Burger b) {
		return BurgerRepo.save(b);
	}

	// Delete
	public void deleteBurger(Long id) {
		BurgerRepo.deleteById(id);
	}

}
