package com.seth.dojoswithninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seth.dojoswithninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
