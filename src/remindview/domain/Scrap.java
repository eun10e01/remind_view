package remindview.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Scrap implements Serializable{
	private long userId; //스크랩한 회원 번호(외래키(User))
	private long recordId; //기록 번호(외래키(ContentRecord))
	private LocalDateTime createdAt; //누른 일시
	
	//스크랩 했을 때 사용
	public Scrap(long userId, long recordId) {
		this.userId = userId;
		this.recordId = recordId;
	}
	
	//DB에서 조회한 데이터를 가져올 때 사용
	public Scrap(long userId, long recordId, LocalDateTime createdAt) {
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