package remindview.controller;

import java.io.IOException;
import remindview.protocol.Response;

public interface AuthApi {
    Response login(String loginId, String password) throws IOException;

    Response register(String loginId, String password, String nickname)
            throws IOException;
}