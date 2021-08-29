package tujiorg.profile.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tujiorg.profile.db.entities.User;


public interface UserRepo extends JpaRepository<User, String> {
	
}
