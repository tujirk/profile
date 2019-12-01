package com.tujiorg.products.profile.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujiorg.products.profile.db.entities.ProjectsHo;

public interface ProjectsHoRepo extends JpaRepository<ProjectsHo, String> {
	public List<ProjectsHo> findByPriroityNotOrderByPriroityDesc(int priroity);
}
