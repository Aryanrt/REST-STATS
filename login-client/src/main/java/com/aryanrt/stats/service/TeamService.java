package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Team;

public interface TeamService {
	List<Team> findAll();
    Team findOne(String abbriviation);
}
