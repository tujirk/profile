package com.tujiorg.products.profile.db.services;

import java.util.List;

import com.tujiorg.products.profile.db.entities.ProjectsCo;

public interface ProjectsCoService {
	
	public ProjectsCo getProjectsById(String id);
	public List<ProjectsCo> getActiveProjects();
	
}
