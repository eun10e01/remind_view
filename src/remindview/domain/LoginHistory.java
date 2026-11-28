package remindview.domain;

import java.time.LocalDateTime;

public class LoginHistory {
	private long userId; //계정 고유 번호
	private LocalDateTime loginAt; //로그인 일시
	private LocalDateTime logoutAt;
	
	//login history 조회 시 사용
	public LoginHistory(long userId, LocalDateTime loginAt, LocalDateTime logoutAt) {
		this.userId = userId;
		this.loginAt = loginAt;
		this.logoutAt = logoutAt;
	}
	
	//getter
	public long getUserId() {
		return userId;
	}
	public LocalDateTime getLoginAt() {
		return loginAt;
	}
	public LocalDateTime getLogoutAt() {
		return logoutAt;
	}
}
