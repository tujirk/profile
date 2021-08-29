package tujiorg.profile.db.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tujiorg.profile.db.entities.Awards;
import tujiorg.profile.db.repo.AwardsRepo;
import tujiorg.profile.db.services.AwardsService;


@Service
public class AwardsServiceImpl implements AwardsService {
	@Autowired
	private AwardsRepo awardsRepo;
	
	public Awards getAwardById(int id) {
		return awardsRepo.findById(id).get();
	}
	
	public List<Awards> getActiveAwards() {
		return awardsRepo.findByPriroityNotOrderByDateDesc(0);
	}
}
