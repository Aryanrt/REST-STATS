package com.aryanrt.stats.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
 
@Controller  
public class LoginController {
  
   
  @GetMapping(value="/login")
  public String login(HttpServletRequest request)
  {   
//	  FileInputStream serviceAccount = null;
//		try {
//			serviceAccount = new FileInputStream("./serviceAccount.json");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();  
//		}
//
//		FirebaseOptions options = null;
//		try { 
//			options = new FirebaseOptions.Builder()
//			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//			  .setDatabaseUrl("https://bball-auth.firebaseio.com")
//			  .build();   
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		FirebaseApp.initializeApp(options);
//		
		//FirebaseApp app = FirebaseApp.getInstance();
		//System.out.println(app.getName());
		//app.
			
	return "login.html";
  }
  @GetMapping(value="/log")  
  public void log(HttpServletRequest request)
  {

	//return "login.html";
  } 

}
