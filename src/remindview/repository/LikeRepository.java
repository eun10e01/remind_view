package remindview.repository;

import remindview.domain.Like;

public interface LikeRepository {
	void save(Like like); //좋아요 등록
	void delete(long userId, long recordId); //좋아요 취소
	boolean exists(long userId, long recordId); //이미 좋아요를 눌렀는지 확인(토글 및 좋아요 버튼 상태 표시용)
	int countByRecordId(long recordId); //총 좋아요 개수 세기(기록 상세 화면에 표시하기 위함)
	void deleteByRecordId(long recordId); //기록을 삭제하면 그 기록의 모든 좋아요 같이 삭제
}