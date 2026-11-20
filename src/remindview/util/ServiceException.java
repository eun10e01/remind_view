package remindview.util;

/**
 * 규칙을 어겼을 때 Service가 던지는 예외 (예: 중복 아이디, 로그인 실패).
 * 메시지는 그대로 사용자에게 보여줘도 되는 문장으로 쓴다.
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }
}
