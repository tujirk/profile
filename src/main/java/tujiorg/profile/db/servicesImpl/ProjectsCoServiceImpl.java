package tujiorg.profile.db.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tujiorg.profile.db.entities.ProjectsCo;
import tujiorg.profile.db.repo.ProjectsCoRepo;
import tujiorg.profile.db.services.ProjectsCoService;


@Service
public class ProjectsCoServiceImpl implements ProjectsCoService {
	
	@Autowired
	private ProjectsCoRepo projectsCoRepo;
	
	public ProjectsCo getProjectsById(String id) {
		return projectsCoRepo.findById(id.toUpperCase()).get();
	}
	
	public List<ProjectsCo> getActiveProjects(){
		return projectsCoRepo.findByPriroityNotOrderByPriroityDesc(0);
	}
	
}
