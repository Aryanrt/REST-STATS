package com.aryanrt.stats.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.repositories.TeamRepository;
import com.aryanrt.stats.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	private TeamRepository teamRepository;


	public TeamServiceImpl(TeamRepository teamRepository) {
		super();
		this.teamRepository = teamRepository;
	}
	
	@Override
	public List<Team> findAll() {
		return (List<Team>) teamRepository.findAll();
	}

	@Override
	public Team findOne(String abbriviation) {
		return teamRepository.findByAbbriviation(abbriviation);
	}

}
