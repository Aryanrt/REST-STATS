package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Playerstats;
import com.aryanrt.stats.models.PlayerstatsPK;
import com.aryanrt.stats.models.Teamstats;
import com.aryanrt.stats.models.TeamstatsPK;

@RepositoryRestResource(collectionResourceRel = "playerstats", path = "playerstats")
public interface PlayerstatsRepository extends PagingAndSortingRepository<Playerstats, PlayerstatsPK> {

    //Matchup findById(long id);
}