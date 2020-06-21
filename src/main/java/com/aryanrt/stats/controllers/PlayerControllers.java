package com.aryanrt.stats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.aryanrt.stats.models.Player;
//import com.aryanrt.stats.repositories.PlayerRepository;

@RestController
public class PlayerControllers {
	//@Autowired
	//private PlayerRepository repository;


	  // Aggregate root

//	  @GetMapping("/players")
//	  List<Player> all() {
//	    return (List<Player>) repository.findAll();
//	  }

//	  @PostMapping("/employees")
//	  Employee newEmployee(@RequestBody Employee newEmployee) {
//	    return repository.save(newEmployee);
//	  }
//
//	  // Single item
//
//	  @GetMapping("/employees/{id}")
//	  Employee one(@PathVariable Long id) {
//
//	    return repository.findById(id)
//	      .orElseThrow(() -> new EmployeeNotFoundException(id));
//	  }
//
//	  @PutMapping("/employees/{id}")
//	  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//	    return repository.findById(id)
//	      .map(employee -> {
//	        employee.setName(newEmployee.getName());
//	        employee.setRole(newEmployee.getRole());
//	        return repository.save(employee);
//	      })
//	      .orElseGet(() -> {
//	        newEmployee.setId(id);
//	        return repository.save(newEmployee);
//	      });
//	  }
//
//	  @DeleteMapping("/employees/{id}")
//	  void deleteEmployee(@PathVariable Long id) {
//	    repository.deleteById(id);
//	  }

}
