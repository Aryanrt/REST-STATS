package com.aryanrt.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.HypermediaMappingInformation;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RestNbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestNbaApplication.class, args);
	}
//	@Bean
//	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder,
//	                                 HypermediaMappingInformation mappingInformation) {
//	    ObjectMapper objectMapper = builder.build();
//	    mappingInformation.configureObjectMapper(objectMapper);
//	    return objectMapper;
//	}
}
