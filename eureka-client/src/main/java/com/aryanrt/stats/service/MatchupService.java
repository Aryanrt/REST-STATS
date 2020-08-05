package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;


public interface MatchupService {
	List<Matchup> findAll();
	Matchup findOne(int id);
	List<Matchup> findAll(Team team);
}
