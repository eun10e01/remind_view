package remindview.server;

import remindview.protocol.Command;
import remindview.protocol.Request;
import remindview.protocol.Response;
import remindview.util.DaoException;
import remindview.util.ServiceException;

/**
 * 요청의 command를 보고 알맞은 처리로 넘겨 주는 분배기 (뼈대).
 * 모든 ClientHandler 스레드가 하나를 같이 쓰므로, 상태를 필드에 저장하지 않는다.
 *
 * 지금은 PING만 처리한다.
 * 기능 담당자는 Command에 이름을 추가하고, 아래 switch에 case를 한 줄 추가하면 된다.
 *   예) case Command.SIGNUP: return Response.ok(userService.signUp(...));
 */
public class RequestRouter {

    public Response route(Request request) {
        try {
            switch (request.getCommand()) {
                case Command.PING:
                    return Response.ok("PONG", null);
                default:
                    return Response.fail("알 수 없는 요청입니다: " + request.getCommand());
            }
        } catch (ServiceException e) {
            // 사용자에게 보여줘도 되는 메시지
            return Response.fail(e.getMessage());
        } catch (DaoException e) {
            // DB 오류 내용은 서버 로그에만 남기고, 클라이언트에는 일반 문구만 보낸다
            System.err.println("[DB 오류] " + e.getMessage());
            return Response.fail("서버에서 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");
        }
    }
}
