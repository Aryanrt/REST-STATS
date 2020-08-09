package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aryanrt.stats.models.Player;
import com.aryanrt.stats.models.PlayerPK;
import com.aryanrt.stats.models.Team;
import java.util.List;

@RepositoryRestResource
public interface PlayerRepository extends PagingAndSortingRepository<Player, PlayerPK> {
	Player findByPlayerID(int id);
	List<Player>findById_team(Team team);
}