package tujiorg.profile.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tujiorg.profile.db.entities.ProjectsCo;


public interface ProjectsCoRepo extends JpaRepository<ProjectsCo, String> {
	public List<ProjectsCo> findByPriroityNotOrderByPriroityDesc(int priroity);
}
