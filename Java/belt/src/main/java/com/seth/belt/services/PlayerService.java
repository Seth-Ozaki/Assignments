package com.seth.belt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seth.belt.models.Player;
import com.seth.belt.repositories.PlayerRepository;

@Service
public class PlayerService {
	// Member variable that contains all our CRUD tools
		private final PlayerRepository playerRepo;

		public PlayerService(PlayerRepository pR) {
			this.playerRepo = pR;
		}
		
		// CRUD------
		
		// Create
		public Player createPlayer(Player p) {
			return playerRepo.save(p);
		}
		
		// Read All
		public List<Player> getAllPlayers(){
			return playerRepo.findAll();
		}
}
