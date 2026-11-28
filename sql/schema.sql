-- 리마인드뷰 테이블 정의 (id는 모두 BIGINT = 자바 long)
-- 실행 순서: 다른 테이블이 참조하는 users, content_records를 먼저 만든다.

CREATE TABLE IF NOT EXISTS users (
    user_id       BIGINT       NOT NULL AUTO_INCREMENT,
    login_id      VARCHAR(30)  NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    nickname      VARCHAR(30)  NOT NULL,
    created_at    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id),
    UNIQUE KEY uq_users_login_id (login_id),
    UNIQUE KEY uq_users_nickname (nickname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS content_records (
    record_id   BIGINT       NOT NULL AUTO_INCREMENT,
    user_id     BIGINT       NOT NULL,
    youtube_url VARCHAR(500) NOT NULL,
    title       VARCHAR(200) NOT NULL,
    content     TEXT         NOT NULL,
    is_shared   BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (record_id),
    KEY idx_records_user (user_id),
    KEY idx_records_title (title),
    CONSTRAINT fk_records_user FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS comments (
    comment_id BIGINT   NOT NULL AUTO_INCREMENT,
    record_id  BIGINT   NOT NULL,
    user_id    BIGINT   NOT NULL,
    content    TEXT     NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (comment_id),
    KEY idx_comments_record (record_id),
    CONSTRAINT fk_comments_record FOREIGN KEY (record_id) REFERENCES content_records (record_id) ON DELETE CASCADE,
    CONSTRAINT fk_comments_user   FOREIGN KEY (user_id)   REFERENCES users (user_id)            ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS likes (
    user_id    BIGINT   NOT NULL,
    record_id  BIGINT   NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, record_id),
    KEY idx_likes_record (record_id),
    CONSTRAINT fk_likes_user   FOREIGN KEY (user_id)   REFERENCES users (user_id)            ON DELETE CASCADE,
    CONSTRAINT fk_likes_record FOREIGN KEY (record_id) REFERENCES content_records (record_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS scraps (
    user_id    BIGINT   NOT NULL,
    record_id  BIGINT   NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, record_id),
    KEY idx_scraps_record (record_id),
    CONSTRAINT fk_scraps_user   FOREIGN KEY (user_id)   REFERENCES users (user_id)            ON DELETE CASCADE,
    CONSTRAINT fk_scraps_record FOREIGN KEY (record_id) REFERENCES content_records (record_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS follows (
    follower_id  BIGINT   NOT NULL,
    following_id BIGINT   NOT NULL,
    created_at   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (follower_id, following_id),
    KEY idx_follows_following (following_id),
    CONSTRAINT ck_follows_not_self CHECK (follower_id <> following_id),
    CONSTRAINT fk_follows_follower  FOREIGN KEY (follower_id)  REFERENCES users (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_follows_following FOREIGN KEY (following_id) REFERENCES users (user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS notifications (
    notification_id BIGINT   NOT NULL AUTO_INCREMENT,
    receiver_id     BIGINT   NOT NULL,
    sender_id       BIGINT   NOT NULL,
    record_id       BIGINT   NULL,
    type            ENUM('COMMENT','FOLLOW') NOT NULL,
    is_read         BOOLEAN  NOT NULL DEFAULT FALSE,
    created_at      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (notification_id),
    KEY idx_notifications_receiver (receiver_id),
    CONSTRAINT fk_notif_receiver FOREIGN KEY (receiver_id) REFERENCES users (user_id)            ON DELETE CASCADE,
    CONSTRAINT fk_notif_sender   FOREIGN KEY (sender_id)   REFERENCES users (user_id)            ON DELETE CASCADE,
    CONSTRAINT fk_notif_record   FOREIGN KEY (record_id)   REFERENCES content_records (record_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS login_history (
    history_id BIGINT      NOT NULL AUTO_INCREMENT,
    user_id    BIGINT      NULL,
    login_id   VARCHAR(30) NOT NULL,
    type       ENUM('LOGIN','LOGOUT','LOGIN_FAIL') NOT NULL,
    client_ip  VARCHAR(45) NULL,
    created_at DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (history_id),
    KEY idx_history_user (user_id),
    CONSTRAINT fk_history_user FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;