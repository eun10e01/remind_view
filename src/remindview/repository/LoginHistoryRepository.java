package remindview.repository;

import remindview.domain.LoginHistory;

public interface LoginHistoryRepository {
	void storeLoginTime(LoginHistory loginHistory);
	LoginHistory findbyId(long userId);
}
