package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aryanrt.stats.models.Teamstats;
import com.aryanrt.stats.models.TeamstatsPK;

@RepositoryRestResource(collectionResourceRel = "teamstats", path = "teamstats")
public interface TeamstatsRepository extends PagingAndSortingRepository<Teamstats, TeamstatsPK> {

    //Matchup findById(long id);
}