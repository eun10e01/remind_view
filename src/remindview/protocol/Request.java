package remindview.protocol;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 클라이언트 → 서버 요청.
 * command(무엇을 해 달라) + params(필요한 값들)로 이루어진다.
 *
 * 사용 예:
 *   Request req = new Request(Command.LOGIN).put("loginId", "abc").put("password", "1234");
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String command;
    private final Map<String, Object> params = new HashMap<>();

    public Request(String command) {
        this.command = command;
    }

    /** 값을 넣고 자기 자신을 돌려줘서 .put().put() 처럼 이어 쓸 수 있다. */
    public Request put(String key, Object value) {
        params.put(key, value);
        return this;
    }

    public String getCommand() {
        return command;
    }

    /** 값이 없으면 null */
    public String getString(String key) {
        Object value = params.get(key);
        return value == null ? null : value.toString();
    }

    public Object get(String key) {
        return params.get(key);
    }

    @Override
    public String toString() {
        // 비밀번호가 로그에 찍히지 않도록 params 내용은 출력하지 않는다
        return "Request{command=" + command + "}";
    }
}
