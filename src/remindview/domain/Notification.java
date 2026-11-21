package remindview.domain;

public class Notification {
	long notificationId; //long으로 타입 변경
	long receiverId;
	long senderId;
	long postId;
	String message;
	boolean isRead;
	void markasRead() {};
}
