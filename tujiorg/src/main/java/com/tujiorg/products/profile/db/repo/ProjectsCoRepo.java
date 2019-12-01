package com.tujiorg.products.profile.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujiorg.products.profile.db.entities.ProjectsCo;

public interface ProjectsCoRepo extends JpaRepository<ProjectsCo, String> {
	public List<ProjectsCo> findByPriroityNotOrderByPriroityDesc(int priroity);
}
