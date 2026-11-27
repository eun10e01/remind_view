package remindview.service;

import remindview.domain.Like;
import remindview.repository.LikeRepository;
import remindview.repository.RecordRepository;
import remindview.util.ServiceException;

public class LikeService {
	private final LikeRepository likeRepository;
	private final RecordRepository recordRepository;
	
	//인터페이스 주입
	public LikeService(LikeRepository likeRepository, RecordRepository recordRepository) {
		this.likeRepository = likeRepository;
		this.recordRepository = recordRepository;
	}
	
	//좋아요 토글(T-좋아요 등록 / F-좋아요 취소)
	public boolean toggleLike(long userId, long recordId) {
		if(recordRepository.findById(recordId).isEmpty()) {
			throw new ServiceException("존재하지 않는 기록에는 좋아요를 누를 수 없습니다.");
		}
		
		if(likeRepository.exists(userId, recordId)) {
			likeRepository.delete(userId, recordId);
			
			return false;
		}
		else {
			likeRepository.save(new Like(userId, recordId));
			
			return true;
		}
	}
	
	//좋아요 개수 count
	public int getLikeCount(long recordId) {
		return likeRepository.countByRecordId(recordId);
	}
}