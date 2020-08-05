package com.aryanrt.stats.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.models.TeamstatsPK;
import com.aryanrt.stats.repositories.TeamRepository;
import com.aryanrt.stats.repositories.TeamstatRepository;
import com.aryanrt.stats.service.TeamstatService;

@Service
@Transactional
public class TeamstatServiceImpl implements TeamstatService {
	private TeamstatRepository teamstatRepository;
	private TeamRepository teamRepository;
	
	public TeamstatServiceImpl(TeamstatRepository teamstatRepository, TeamRepository teamRepository) {
		super();
		this.teamstatRepository = teamstatRepository;
		this.teamRepository = teamRepository;
	}

	@Override
	public List<Teamstat> finaAll() {
		return (List<Teamstat>) teamstatRepository.findAll();
	}

	@Override
	public Teamstat findOne(String teamID, int gameId) {
		return teamstatRepository.findById(new TeamstatsPK(gameId, teamRepository.findById(teamID).orElse(null))).orElse(null);
	}

}
