-- 리마인드뷰 DB (이번 주 최소 범위: 회원 테이블만)
-- MariaDB 10.x / HeidiSQL에서 전체 선택 후 실행
-- 나머지 테이블(기록, 댓글, 좋아요 ...)은 기능을 붙일 때 하나씩 추가한다.

CREATE DATABASE IF NOT EXISTS remindview DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE remindview;

-- 이미 데이터가 있어도 지워지지 않도록 IF NOT EXISTS 사용
CREATE TABLE IF NOT EXISTS users (
    user_id       INT          NOT NULL AUTO_INCREMENT,
    login_id      VARCHAR(30)  NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    nickname      VARCHAR(30)  NOT NULL,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id),
    UNIQUE KEY uk_users_login_id (login_id),
    UNIQUE KEY uk_users_nickname (nickname)
);
