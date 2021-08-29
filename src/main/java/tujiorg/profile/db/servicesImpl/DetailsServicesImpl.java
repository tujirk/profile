package tujiorg.profile.db.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tujiorg.profile.db.repo.DetailsRepo;
import tujiorg.profile.db.services.DetailsServices;


@Service
public class DetailsServicesImpl implements DetailsServices{
	@Autowired
	private DetailsRepo detailsRepo;
	
	public String getValueOf(String key) {
		return detailsRepo.findByKey(key.toUpperCase()).getValue();
	}
}
