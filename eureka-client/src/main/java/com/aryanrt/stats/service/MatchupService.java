package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Matchup;


public interface MatchupService {
	List<Matchup> findAll();
	Matchup findOne(int id);
}
