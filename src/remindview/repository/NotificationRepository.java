package remindview.repository;

import java.util.List;

import remindview.domain.Notification;

public interface NotificationRepository {
	void notify(Notification notification);
	Notification findByNId(int notificationId);
	List<Notification> findByReceiverId(int receiverId);
}
