package com.tujiorg.products.profile.db.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujiorg.products.profile.db.entities.Awards;
import com.tujiorg.products.profile.db.repo.AwardsRepo;
import com.tujiorg.products.profile.db.services.AwardsService;

@Service
public class AwardsServiceImpl implements AwardsService {
	@Autowired
	private AwardsRepo awardsRepo;
	
	public Awards getAwardById(int id) {
		return awardsRepo.findById(id).get();
	}
}
