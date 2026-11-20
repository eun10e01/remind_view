package remindview.protocol;

/**
 * 클라이언트가 서버에 보낼 수 있는 명령 이름 목록.
 * 클라이언트·서버 모두 이 상수를 사용해서 오타로 인한 오류를 막는다.
 *
 * 기능 담당자는 자기 기능의 명령을 여기에 한 줄씩 추가하고,
 * RequestRouter의 switch에 case를 추가한다.
 */
public final class Command {

    private Command() { }

    /** 서버 연결 확인용. params: 없음 → message: "PONG" */
    public static final String PING = "PING";
}
