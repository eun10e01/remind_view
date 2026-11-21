package remindview.repository;

import remindview.domain.User;

public interface UserRepository {
	void storeUser(User user); //User 정보 저장하기
	User findById(String loginId); //로그인Id로 User 찾기
	Boolean existsByLoginId(String loginId); //로그인Id 중복되는지 확인하기
}
