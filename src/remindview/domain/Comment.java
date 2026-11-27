package remindview.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comment implements Serializable{
	private long commentId; //댓글 고유 번호(기본키, AUTO_INCREMENT)
	private long recordId; //기록 번호(외래키(ContentRecord))
	private long userId; //작성자 번호(외래키(User))
	private String content; //댓글 내용
	private LocalDateTime createdAt; //작성 일시
	private LocalDateTime updatedAt; //수정 일시
	
	//새 댓글 작성 시 사용
	public Comment(long recordId, long userId, String content) {
		validate(content);
		
		this.recordId = recordId;
		this.userId = userId;
		this.content = content;
	}
	
	//DB에서 조회한 데이터를 가져올 때 사용
	public Comment(long commentId, long recordId, long userId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.commentId = commentId;
		this.recordId = recordId;
		this.userId = userId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//댓글 수정
	public void edit(String newContent) {
		validate(newContent);
		
		this.content = newContent;
	}
	
	//작성자 본인 여부 확인
	public boolean isOwned(long requestUserId) {
		return this.userId == requestUserId;
	}
	
	//유효성 검증
	private void validate(String content) {
		if(content == null || content.isBlank()) {
			throw new IllegalArgumentException("댓글 내용은 비어 있을 수 없습니다.");
		}
	}
	
	//getter
	public long getCommentId() {
		return commentId;
	}
	
	public long getRecordId() {
		return recordId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public String getContent() {
		return content;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}