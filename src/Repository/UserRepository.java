package Repository;

import Domain.User;

public interface UserRepository {
	void storeUser(User user);
	User findById(String loginId);
	Boolean existsByLoginId(String loginId); 	
}
