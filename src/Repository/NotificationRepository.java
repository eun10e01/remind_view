package Repository;

import java.util.List;

import Domain.Notification;

public interface NotificationRepository {
	void notify(Notification notification);
	Notification findByNId(int notificationId);
	List<Notification> findByReceiverId(int receiverId);
}
