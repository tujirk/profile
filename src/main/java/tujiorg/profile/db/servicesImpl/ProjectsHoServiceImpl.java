package tujiorg.profile.db.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tujiorg.profile.db.entities.ProjectsHo;
import tujiorg.profile.db.repo.ProjectsHoRepo;
import tujiorg.profile.db.services.ProjectsHoService;


@Service
public class ProjectsHoServiceImpl implements ProjectsHoService {
	@Autowired
	private ProjectsHoRepo projectsHoRepo;
	
	public List<ProjectsHo> getActiveProjects() {
		return projectsHoRepo.findByPriroityNotOrderByPriroityDesc(0);
	}
}
