package com.aryanrt.stats.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aryanrt.stats.models.Team;

@RepositoryRestResource
public interface TeamRepository extends PagingAndSortingRepository<Team, java.lang.String> {

    Team findByAbbriviation(String abbrivation);
}