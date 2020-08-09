package com.aryanrt.stats.service;

import java.util.List;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.Team;

public interface PlayerService {
	List<Player> finalAll();
	Player findOne(int id);
	List<Player> findByTeam(Team team);

}
