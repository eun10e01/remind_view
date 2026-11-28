package remindview.domain;

public class Notification {
	long notificationId; //long으로 타입 변경
	long receiverId;
	long senderId;
	long postId;
	String message;
	boolean isRead;
	void markasRead() {};
	
	//알림 생성할 때 사용
	public Notification(long notificationId, long receiverId, long senderId, long postId, String message, boolean isRead) {
		this.notificationId = notificationId;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.postId = postId;
		this.message = message;
		this.isRead = isRead;
	}
	
	//알림 생성할 때를 제외한 상황에 사용
	public Notification(long notificationId) {
		this.notificationId = notificationId;
	}
	
	//getter
	public long getNotificationId() {
		return notificationId;
	}
	
	public long getReceiverId() {
		return receiverId;
	}
	
	public long getSenderId() {
		return senderId;
	}
	
	public long getPostId() {
		return postId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean getIsRead() {
		return isRead;
	}
}
