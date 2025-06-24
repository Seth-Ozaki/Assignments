package com.seth.burgertrack.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seth.burgertrack.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
}
