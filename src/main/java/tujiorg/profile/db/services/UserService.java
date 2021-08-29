package tujiorg.profile.db.services;

import java.util.List;

import tujiorg.profile.db.entities.User;


public interface UserService {
	public List<User> getUsersList();
	public User getUserById(String userId);
	public void saveUser(User user);
	public void deleteUser(String userId);
	public boolean isUserExist(String userId);
}
