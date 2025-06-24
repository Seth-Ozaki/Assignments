package com.seth.dojoswithninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.dojoswithninjas.models.Dojo;
import com.seth.dojoswithninjas.repositories.DojoRepository;

@Service
public class DojoService {
	// Member variable that contains all our CRUD tools
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dR) {
		this.dojoRepo = dR;
	}
	
	// CRUD-------------
	
	// Create
	public Dojo create(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// Read One
	public Dojo getOne(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}else {
			return null;
		}
	}
	
	//Read All
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
