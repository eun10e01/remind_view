package remindview.service;

import java.time.LocalDateTime;
import java.util.Objects;

import remindview.domain.LoginHistory;
import remindview.domain.User;
import remindview.repository.LoginHistoryRepository;
import remindview.repository.UserRepository;
import remindview.util.ServiceException;

public class UserService {
    // 공백 없이 영문 알파벳(대소문자포함)과 숫자만 1~30자 허용
    private static final String ALLOWED_PATTERN = "^[a-zA-Z0-9]{1,30}$"; //gemini 사용
    // 사용할 레포지터리
    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;

    public UserService(UserRepository userRepository, LoginHistoryRepository loginHistoryRepository) {
        this.userRepository = userRepository;
        this.loginHistoryRepository = loginHistoryRepository;
    }

    // 회원가입-입력 형식 검증 + 아이디 중복 확인 후 저장
    public void signup(User user) {
        if (user == null) {
            throw new ServiceException("해당 회원 정보가 존재하지 않습니다.");
        } //오류 처리는 ServiceException으로 통일
        validateFormat(user.getLoginId(), "아이디");
        validateFormat(user.getPassword(), "비밀번호");
        validateFormat(user.getNickname(), "닉네임");

        if (Boolean.TRUE.equals(userRepository.existsByLoginId(user.getLoginId()))) {
            throw new ServiceException("중복된 아이디입니다.");
        }

        userRepository.storeUser(user);
    }

    // 로그인-아이디 존재 여부 및 비밀번호 일치 확인 후 User 반환
    public User login(String loginId, String password) {
        if (loginId == null || password == null) {
            throw new ServiceException("아이디 또는 비밀번호가 비어 있습니다.");
        }

        User loginUser = userRepository.findById(loginId);
        if (loginUser == null) {
            throw new ServiceException("존재하지 않는 아이디입니다.");
        }

        if (!Objects.equals(loginUser.getPassword(), password)) {
            throw new ServiceException("비밀번호가 일치하지 않습니다.");
        }
        
        LoginHistory loginHistory = new LoginHistory(loginUser.getUserId(), LocalDateTime.now(), null);
        loginHistoryRepository.storeLoginTime(loginHistory);
        System.out.println(loginUser.getNickname() + "님, 환영합니다!");
        return loginUser;
    }

    // 로그아웃 - 현재 로그인 상태 해제
    public void logout(long userId) {
        if (userId <= 0) {
            throw new ServiceException("유효하지 않은 userId입니다: " + userId);
        }
        LoginHistory loginHistory = new LoginHistory(userId, null, LocalDateTime.now());
        loginHistoryRepository.storeLoginTime(loginHistory);
        System.out.println("로그아웃되었습니다.");
    }

    private void validateFormat(String value, String fieldName) {
    	//형식에 맞지 않는 값이 들어왔을 대 Exception 던져서 회원 가입 중단 시킴.
        if (value == null || value.isEmpty()) {
            throw new ServiceException(fieldName + " 입력값이 비어 있습니다.");
        }
        if (value.length() > 30) {
            throw new ServiceException(fieldName + " 길이 초과 (30자 이하만 가능)");
        }
        if (!value.matches(ALLOWED_PATTERN)) {
            throw new ServiceException(fieldName + " 형식 오류 (공백 없이 영문과 숫자만 가능)");
        }
    }
}
