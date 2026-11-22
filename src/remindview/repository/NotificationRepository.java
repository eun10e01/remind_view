package remindview.repository;

import java.util.List;

import remindview.domain.Notification;

public interface NotificationRepository {
	void notify(Notification notification); //알림 만들기
	Notification findByNId(long notificationId); //알림Id로 알림조회하기
	List<Notification> findByReceiverId(long receiverId); //알림받은user의 Id로 알림조회하기
}
