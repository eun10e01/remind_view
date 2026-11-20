```bash
remind_view/
├── lib/                                 ◀ JDBC 드라이버(.jar) 보관 폴더 (Git에 함께 업로드)
│   └── mysql-connector-j-9.x.x.jar      (사용하는 DB에 맞는 드라이버 파일)
├── src/
│   └── remindview/
│       ├── Main.java                    ◀ 프로그램 시작점 (객체 조립 및 실행)
│       ├── config/
│       │   └── DBConnection.java        ◀ JDBC 드라이버 로드 및 Connection 생성·해제
│       ├── domain/                      ◀ DB 테이블과 1:1로 매핑되는 핵심 객체
│       │   ├── User.java               
│       │   ├── ContentRecord.java
│       │   ├── Comment.java
│       │   ├── Like.java
│       │   ├── Scrap.java
│       │   ├── Follow.java
│       │   ├── Notification.java
│       │   └── NotificationType.java
│       ├── dto/                         ◀ 조인(JOIN) 조회 결과 등 화면 전달용 객체
│       │   └── ContentRecordDetailDto.java  (예: 게시글 내용 + 작성자 닉네임 + 좋아요 수)
│       ├── repository/                  ◀ SQL 실행 (PreparedStatement, ResultSet 처리)
│       │   ├── UserRepository.java      (인터페이스)
│       │   └── JdbcUserRepository.java  (JDBC 구현 클래스)
│       ├── service/                     ◀ 비즈니스 로직 및 트랜잭션 처리
│       │   ├── UserService.java
│       │   ├── ContentRecordService.java
│       │   └── CommentService.java
│       ├── controller/                  ◀ 사용자 요청을 받아 Service 호출 후 결과 전달
│       └── view/                        ◀ 콘솔(Scanner/System.out) 또는 UI 입출력 담당
├── db.properties                        ◀ 실제 DB 주소·아이디·비밀번호 (.gitignore에 등록)
├── db.properties.example                ◀ 팀원 공유용 DB 설정 양식 파일 (Git에 업로드)
├── .gitignore
└── README.md
```