package com.aryanrt.stats.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.repositories.MatchupRepository;

import net.minidev.json.JSONArray;

@RestController
public class MatchupController {
	
	@Autowired
	private MatchupRepository repository;


		  // Aggregate root

	  @GetMapping("/matchups")
	  public Object all() {
	    return (List<Matchup>) repository.findAll();
	  }

	  @GetMapping("/matchups/{matchupID}")
	  public Matchup one(@PathVariable int matchupID) {

	    return repository.findById(matchupID);
	  }

}
