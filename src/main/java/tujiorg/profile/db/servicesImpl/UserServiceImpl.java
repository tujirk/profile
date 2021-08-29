package tujiorg.profile.db.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tujiorg.profile.db.entities.User;
import tujiorg.profile.db.repo.UserRepo;
import tujiorg.profile.db.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public List<User> getUsersList(){
		return userRepo.findAll();
	}
	
	public User getUserById(String userId) {
		return userRepo.findById(userId).get();
	}
	public void saveUser(User user){
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	public void deleteUser(String userId) {
		userRepo.deleteById(userId);
	}
	public boolean isUserExist(String userId) {
		return userRepo.existsById(userId);
	}

}
