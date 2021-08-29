package tujiorg.profile.db.services;

import java.util.List;

import tujiorg.profile.db.entities.ProjectsCo;


public interface ProjectsCoService {
	
	public ProjectsCo getProjectsById(String id);
	public List<ProjectsCo> getActiveProjects();
	
}
