package remindview.service;

import java.util.List;

import remindview.domain.ContentRecord;
import remindview.repository.CommentRepository;
import remindview.repository.LikeRepository;
import remindview.repository.RecordRepository;
import remindview.repository.ScrapRepository;
import remindview.util.ServiceException;

public class RecordService {
	private final RecordRepository recordRepository;
	private final CommentRepository commentRepository;
	private final LikeRepository likeRepository;
	private final ScrapRepository scrapRepository;
	
	//인터페이스 주입
	public RecordService(RecordRepository recordRepository, CommentRepository commentRepository, LikeRepository likeRepository, ScrapRepository scrapRepository) {
		this.recordRepository = recordRepository;
		this.commentRepository = commentRepository;
		this.likeRepository = likeRepository;
		this.scrapRepository = scrapRepository;
	}
	
	//기록 등록
	public void createRecord(long userId, String youtubeUrl, String title, String content, boolean isShared) {
		ContentRecord record = new ContentRecord(userId, youtubeUrl, title, content, isShared);
		recordRepository.save(record);
	}
	
	//기록 상세 조회
	public ContentRecord getRecord(long recordId) {
		return recordRepository.findById(recordId).orElseThrow(() -> new ServiceException("존재하지 않는 기록입니다."));
	}
	
	//전체 공개 기록 조회
	public List<ContentRecord> getSharedRecords(){
		return recordRepository.findAllShared();
	}
	
	//기록 수정
	public void updateRecord(long recordId, long loginUserId, String newYoutubeUrl, String newTitle, String newContent, boolean isShared) {
		ContentRecord record = recordRepository.findById(recordId).orElseThrow(() -> new ServiceException("수정할 기록이 존재하지 않습니다."));
		
		if(!record.isOwned(loginUserId)) {
			throw new ServiceException("본인이 작성한 기록만 수정할 수 있습니다.");
		}
		
		record.update(newYoutubeUrl, newTitle, newContent, isShared);
		recordRepository.update(record);
	}
	
	//기록 삭제
	public void deleteRecord(long recordId, long loginUserId) {
		ContentRecord record = recordRepository.findById(recordId).orElseThrow(() -> new ServiceException("삭제할 기록이 존재하지 않습니다."));
		
		if(!record.isOwned(loginUserId)) {
			throw new ServiceException("본인이 작성한 기록만 수정할 수 있습니다.");
		}
		
		commentRepository.deleteByRecordId(recordId);
		likeRepository.deleteByRecordId(recordId);
		scrapRepository.deleteByRecordId(recordId);
		
		recordRepository.delete(recordId);
	}
}