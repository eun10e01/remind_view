package remindview.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB 접속 정보. 연결 정보는 이 클래스 한곳에서만 관리한다.
 * (HeidiSQL에 접속할 때 쓰는 host / port / 계정과 같은 값)
 *
 * connect()는 호출할 때마다 새 Connection을 만들어 준다.
 * → 클라이언트가 여러 명이어도 스레드끼리 Connection을 공유하지 않아 안전하다.
 * → 나중에 커넥션 풀을 쓰고 싶으면 이 메소드 안만 바꾸면 된다 (DAO는 그대로).
 */
public final class DBConfig {

    private static final String URL =
            "jdbc:mariadb://127.0.0.1:3306/remindview?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = env("RV_DB_USER", "root");

    // 비밀번호를 코드에 적어서 Git에 올리지 않으려면 환경변수 RV_DB_PASSWORD를 설정한다.
    // (설정하지 않으면 아래 기본값을 쓴다. 이 줄을 고쳤다면 커밋하지 말 것)
    private static final String PASSWORD = env("RV_DB_PASSWORD", "your_password");

    private DBConfig() { }

    /** 새 Connection을 만든다. 쓰는 쪽에서 반드시 try-with-resources로 닫을 것. */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String env(String name, String defaultValue) {
        String value = System.getenv(name);
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }
}
