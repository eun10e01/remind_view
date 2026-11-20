package remindview.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Like implements Serializable{
	private long userId; //누른 회원 번호(외래키(User))
	private long recordId; //기록 번호(외래키(ContentRecord))
	private LocalDateTime createdAt; //누른 일시
	
	//좋아요를 눌렀을 때 사용
	public Like(long userId, long recordId) {
		this.userId = userId;
		this.recordId = recordId;
	}
	
	//DB에서 조회한 데이터를 가져올 때 사용
	public Like(long userId, long recordId, LocalDateTime createdAt) {
		this.userId = userId;
		this.recordId = recordId;
		this.createdAt = createdAt;
	}
	
	//getter
	public long getUserId() {
		return userId;
	}
	
	public long getRecordId() {
		return recordId;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}