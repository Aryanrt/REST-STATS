package com.aryanrt.stats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.HypermediaMappingInformation;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;



@EnableDiscoveryClient
@SpringBootApplication
public class LoginApp {

	public static void main(String[] args) {
		SpringApplication.run(LoginApp.class, args);
	}
	

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LoginApp.class);
	}
//
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true); // you USUALLY want this
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("POST");
//		config.addAllowedHeader("x-firebase-auth");
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//	}

	@Bean
	public FirebaseAuth firebaseAuth() throws IOException {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		FileInputStream serviceAccount = new FileInputStream(
				"serviceAccount.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://bball-auth.firebaseio.com/").build();	

		FirebaseApp.initializeApp(options);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		return FirebaseAuth.getInstance();
	}
 }
