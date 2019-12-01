package com.tujiorg.products.profile.db.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujiorg.products.profile.db.entities.ProjectsHo;
import com.tujiorg.products.profile.db.repo.ProjectsHoRepo;
import com.tujiorg.products.profile.db.services.ProjectsHoService;

@Service
public class ProjectsHoServiceImpl implements ProjectsHoService {
	@Autowired
	ProjectsHoRepo projectsHoRepo;
	
	public List<ProjectsHo> getActiveProjects() {
		return projectsHoRepo.findByPriroityNotOrderByPriroityDesc(0);
	}
}
