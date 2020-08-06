package com.aryanrt.stats.service;

import java.util.List;

import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.models.Teamstat;

public interface TeamstatService {
	List<Teamstat> finaAll();
	Teamstat findOne(String teamID, int gameId);

}
