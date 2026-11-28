package remindview.domain;

import java.io.Serializable;

public class User implements Serializable{ 
	private long userId; //계정 고유 번호 - long으로 타입변경
	private String loginId; //사용자가 실제로 입력하는 로그인아이디
	private String password; //비밀번호
	private String nickname; //닉네임
	
	
	//회원가입, 로그인 시 사용
	public User(long userId, String loginId, String password, String nickname) {
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.nickname = nickname;
	}
	
	
	//로그아웃, 팔로우서비스 등 다른 서비스들 이용시 사용
	public User(long userId) {
		this.userId = userId;
		this.nickname = nickname;
	}
	
	//getter
	public long getUserId() {
		return userId;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getNickname() {
		return nickname;
	}
}
