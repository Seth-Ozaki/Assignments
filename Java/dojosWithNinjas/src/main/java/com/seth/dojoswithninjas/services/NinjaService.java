package com.seth.dojoswithninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seth.dojoswithninjas.models.Ninja;
import com.seth.dojoswithninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// Member variable that contains all our CRUD tools
		private final NinjaRepository ninjaRepo;

		public NinjaService(NinjaRepository nR) {
			this.ninjaRepo = nR;

		}
		
		
		// CRUD-------------
		
		// Create
		public Ninja create(Ninja n) {
			return ninjaRepo.save(n);
		}
		
		//Read All
		public List<Ninja> getAll(){
			return ninjaRepo.findAll();
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
