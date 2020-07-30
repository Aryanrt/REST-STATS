package com.aryanrt.stats.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Team;
import com.aryanrt.stats.models.Teamstat;
import com.aryanrt.stats.models.TeamstatsPK;

@RepositoryRestResource(collectionResourceRel = "teamstat", path = "teamstat")
public interface TeamstatRepository extends PagingAndSortingRepository<Teamstat, TeamstatsPK> {
	//List<Teamstats> findByGameID(int gameID);
	//List<Teamstats> findByTeamID(Team teamID);
	//Teamstats findByGameID(int gameID);
}