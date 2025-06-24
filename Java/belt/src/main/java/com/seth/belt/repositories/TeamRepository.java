package com.seth.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seth.belt.models.Team;
@Repository
public interface TeamRepository extends CrudRepository<Team, Long>{
	List<Team> findAll();
}
