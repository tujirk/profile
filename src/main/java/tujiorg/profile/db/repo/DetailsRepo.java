package tujiorg.profile.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tujiorg.profile.db.entities.Details;


public interface DetailsRepo extends JpaRepository<Details, String>{

	public Details findByKey(String key);
	
}
