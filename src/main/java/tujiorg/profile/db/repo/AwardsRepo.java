package tujiorg.profile.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tujiorg.profile.db.entities.Awards;


public interface AwardsRepo extends JpaRepository<Awards, Integer> {
	public List<Awards> findByPriroityNotOrderByDateDesc(int priroity);
}
