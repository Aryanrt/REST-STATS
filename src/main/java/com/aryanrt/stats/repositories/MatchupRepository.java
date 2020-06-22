package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Matchup;

@RepositoryRestResource(collectionResourceRel = "matchup", path = "matchup")
public interface MatchupRepository extends PagingAndSortingRepository<Matchup, Integer> {

    Matchup findById(int id);
}