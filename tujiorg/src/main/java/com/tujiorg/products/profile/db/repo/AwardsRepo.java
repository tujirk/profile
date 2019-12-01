package com.tujiorg.products.profile.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujiorg.products.profile.db.entities.Awards;

public interface AwardsRepo extends JpaRepository<Awards, Integer> {
	
}
