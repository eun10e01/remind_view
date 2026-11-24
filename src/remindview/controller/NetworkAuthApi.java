package remindview.controller;

import java.io.IOException;

import remindview.client.NetworkClient;
import remindview.protocol.Request;
import remindview.protocol.Response;
import remindview.protocol.Command;
public class NetworkAuthApi implements AuthApi {

    private final NetworkClient client;

    public NetworkAuthApi(NetworkClient client) {
        this.client = client;
    }

    @Override
    public Response login(String loginId, String password) throws IOException {
        Request request = new Request("LOGIN") //서버에서 Command.java에 LOGIN 추가하면 Command.LOGIN으로 수정
                .put("loginId", loginId)
                .put("password", password);

        return client.send(request);
    }

    @Override
    public Response register(String loginId, String password, String nickname)
            throws IOException {
        Request request = new Request("REGISTER") //서버에서 Command.java에 REGISTER 추가하면 Command.REGISTER로 수정
                .put("loginId", loginId)
                .put("password", password)
                .put("nickname", nickname);

        return client.send(request);
    }
}