package com.aryanrt.stats.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.aryanrt.stats.models.Playerstat;
import com.aryanrt.stats.models.PlayerstatsPK;

@RepositoryRestResource(collectionResourceRel = "playerstat", path = "playerstat")
public interface PlayerstatsRepository extends PagingAndSortingRepository<Playerstat, PlayerstatsPK> {
}