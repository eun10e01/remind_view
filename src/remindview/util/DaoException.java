package remindview.util;

import java.sql.SQLException;

/**
 * DAO에서 SQLException이 났을 때 던지는 예외 (unchecked).
 * 인터페이스 메소드마다 throws SQLException을 붙이지 않아도 된다.
 */
public class DaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private static final int MYSQL_DUPLICATE_ENTRY = 1062;

    public DaoException(String message, SQLException cause) {
        super(message + " (" + cause.getMessage() + ")", cause);
    }

    /** UNIQUE / PRIMARY KEY 중복 때문에 난 오류인지 */
    public static boolean isDuplicate(SQLException e) {
        return e.getErrorCode() == MYSQL_DUPLICATE_ENTRY;
    }
}
