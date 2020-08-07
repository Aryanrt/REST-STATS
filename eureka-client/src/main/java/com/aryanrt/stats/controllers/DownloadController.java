package com.aryanrt.stats.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aryanrt.stats.service.DownloadService;

@Controller
public class DownloadController {
	
	private final DownloadService downloadService;

	public DownloadController(DownloadService downloadService) 
	{
		this.downloadService = downloadService;
	}
	@GetMapping("/download")
	public String download( @RequestParam(name="one-date", required = false) boolean  oneDate,
	 @RequestParam(name="multi-dates", required = false) boolean  multiDates,
	 @RequestParam(name="date-wanted", required = false) String  dateWanted ,
	 @RequestParam(name="date-from", required = false) String  dateFrom ,
	 @RequestParam(name="date-to", required = false) String  dateTo , 
	 @RequestParam(name="all-teams", required = false) boolean  allTeams , 
	 @RequestParam(name="some-teams", required = false) boolean  someTeams ,
	 @RequestParam(name="teams-selected", required = false) String[]  teamsSelected , Model model)
	{

		File file = new File("./data.csv");
		FileWriter fileWriter = null;
		String result = "";
		try {
			if(file.createNewFile())
				System.out.println("created");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dateWanted = dateWanted.replaceAll("-", "");
		dateFrom = dateFrom.replaceAll("-", "");
		dateTo = dateTo.replaceAll("-", "");
		
		if(oneDate)
		{
			if(allTeams)
				result = downloadService.getStatDate(dateWanted);
			else
				result = downloadService.getStatDate(dateWanted, teamsSelected);
		}
		else
		{
			if(allTeams)
				result = downloadService.getStatDateRange(dateFrom, dateTo);
			else
				result = downloadService.getStatDateRange(dateFrom, dateTo, teamsSelected);
		}
		
		try {
			fileWriter.append(result);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "confirmation.html";          
	}
	
	@GetMapping("/downloaded")
	public void downloaded(HttpServletRequest request, HttpServletResponse response)
	{
		File file = new File("./data.csv");
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		response.addHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName()));
		response.setContentLength((int) file.length());
		try
		{
			Files.copy(file.toPath(), response.getOutputStream());
			response.getOutputStream().flush();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		file.delete();//?never reached
	}

}
