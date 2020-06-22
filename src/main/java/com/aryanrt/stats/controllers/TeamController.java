package com.aryanrt.stats.controllers;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.repositories.TeamRepository;

import net.minidev.json.JSONArray;

@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository repository;


		  // Aggregate root

	  @GetMapping("/teams")
	  public List<Team> all() {
	    return (List<Team>) repository.findAll();
	  }

	  @GetMapping("/teams/{abbriviation}")
	  public Optional<Team> one(@PathVariable String abbriviation) {

	    return repository.findById(abbriviation);
	  }

}
