package com.seth.belt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seth.belt.models.Team;
import com.seth.belt.repositories.TeamRepository;

@Service
public class TeamService {
	// Member variable that contains all our CRUD tools
	private final TeamRepository teamRepo;

	public TeamService(TeamRepository tR) {
		this.teamRepo = tR;
	}
// 	add once player service is working
//	@Autowired
//	private PlayerService playerService;

	// CRUD-------------

	// Create
	public Team createTeam(Team t) {
		return teamRepo.save(t);
	}
	
	// Read All
	public List<Team> getAllTeams(){
		return teamRepo.findAll();
	}

	// Read One
	public Team getOneTeam(Long id) {
		Optional<Team> optTeam = teamRepo.findById(id);
		if (optTeam.isPresent()) {
			return optTeam.get();
		} else {
			return null;
		}
	}
	
	
	// Update
	public Team updateTeam(Team t) {
		return teamRepo.save(t);
	}
	
	//Delete
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
	
	
	
	
	
	
	
	
}
