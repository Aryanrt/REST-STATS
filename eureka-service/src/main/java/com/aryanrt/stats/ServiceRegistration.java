package com.aryanrt.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.HypermediaMappingInformation;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.fasterxml.jackson.databind.ObjectMapper;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistration {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistration.class, args);
	}

}