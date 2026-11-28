package remindview.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ContentRecord implements Serializable{
	private long recordId; //게시글 고유 번호(기본키, AUTO_INCREMENT)
	private long userId; //작성자 번호(외래키(User))
	private String youtubeUrl; //유튜브url
	private String title; //제목
	private String content; //기록 내용
	private boolean isShared; //공유 여부
	private LocalDateTime createdAt; //작성 일시
	private LocalDateTime updatedAt; //수정 일시
	
	
	//새 게시글 작성 시 사용
	public ContentRecord(long userId, String youtubeUrl, String title, String content, boolean isShared) {
		validate(youtubeUrl, title, content);
		
		this.userId = userId;
		this.youtubeUrl = youtubeUrl;
		this.title = title;
		this.content = content;
		this.isShared = isShared;
	}
	
	//DB에서 조회한 데이터를 가져올 때 사용
	public ContentRecord(long recordId, long userId, String youtubeUrl, String title, String content, boolean isShared, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.recordId = recordId;
		this.userId = userId;
		this.youtubeUrl = youtubeUrl;
		this.title = title;
		this.content = content;
		this.isShared = isShared;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	//기록 수정
	public void update(String newYoutubeUrl, String newTitle, String newContent, boolean newIsShared) {
		validate(newYoutubeUrl, newTitle, newContent);
		
		this.youtubeUrl = newYoutubeUrl;
		this.title = newTitle;
		this.content = newContent;
		this.isShared = newIsShared;
	}
	
	//작성자 본인 여부 확인
	public boolean isOwned(long requestUserId) {
		return this.userId == requestUserId;
	}
	
	//유효성 검증
	private void validate(String youtubeUrl, String title, String content) {
		if(youtubeUrl == null || youtubeUrl.isBlank()) {
			throw new IllegalArgumentException("url은 비어 있을 수 없습니다.");
		}
		
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("제목은 비어 있을 수 없습니다.");
		}
		
		if(content == null || content.isBlank()) {
			throw new IllegalArgumentException("내용은 비어 있을 수 없습니다.");
		}
	}
	
	//getter
	public long getRecordId() {
		return recordId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public String getYoutubeUrl() {
		return youtubeUrl;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public boolean getIsShared() {
		return isShared;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}