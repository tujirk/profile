package com.tujiorg.tuji.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujiorg.tuji.db.entities.User;

public interface UserRepo extends JpaRepository<User, String> {
	
}
