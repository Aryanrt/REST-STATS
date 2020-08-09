package com.aryanrt.stats.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Matchup;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.repositories.MatchupRepository;
import com.aryanrt.stats.service.MatchupService;

@Service
@Transactional
public class MatchupServiceImpl implements MatchupService {
	private MatchupRepository matchupRepository;

	public MatchupServiceImpl(MatchupRepository matchupRepository) {
		super();
		this.matchupRepository = matchupRepository;
	}
	
	@Override
	public List<Matchup> findAll() {
		return (List<Matchup>) matchupRepository.findAll();
	}

	@Override
	public Matchup findOne(int id) {
		return matchupRepository.findById(id);
	}
	public List<Matchup> findAll(Team team)
	{
		List<Matchup> result = matchupRepository.findByTeam1(team);
		result.addAll(matchupRepository.findByTeam2(team));
		return result;
	}
}
