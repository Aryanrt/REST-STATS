package com.aryanrt.stats.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.repositories.TeamRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.BasicLinkBuilder;


@RestController
public class TeamController {
	
	//@Autowired
	//private TeamRepository repository;


//		  // Aggregate root
//
//	  @GetMapping("/teams")
//	  public List<Team> all() {
//	    return (List<Team>) repository.findAll();
//	  }
//
//	  @GetMapping("/teams/{abbriviation}")
//	  public EntityModel<Team> one(@PathVariable String abbriviation) {
//
//	    //return ;
//	    return new EntityModel<>(repository.findById(abbriviation),
//	    		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class).one(abbriviation)).withSelfRel(),
//	    		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TeamController.class).all()).withRel("teams"));
//	  }

}
