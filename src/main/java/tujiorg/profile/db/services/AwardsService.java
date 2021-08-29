package tujiorg.profile.db.services;

import java.util.List;

import tujiorg.profile.db.entities.Awards;


public interface AwardsService {
	public Awards getAwardById(int id);
	public List<Awards> getActiveAwards();
}
