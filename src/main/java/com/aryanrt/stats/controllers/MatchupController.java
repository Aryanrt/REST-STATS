package com.aryanrt.stats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.repositories.MatchupRepository;

@RestController
public class MatchupController {
	
	@Autowired
	private MatchupRepository repository;


		  // Aggregate root

	  @GetMapping("/matchup")
	  List<Matchup> all() {
		  System.out.println("hereeeeeeeeeeeeeeeeeeeee");
		  
		System.out.println(repository.findAll().iterator().hasNext());
	    return (List<Matchup>) repository.findAll();
	  }

}
