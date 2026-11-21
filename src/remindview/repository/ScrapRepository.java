package remindview.repository;

import java.util.List;

import remindview.domain.Scrap;

public interface ScrapRepository {
	void save(Scrap scrap); //스크랩 등록
	void delete(long userId, long recordId); //스크랩 취소
	void exists(long userId, long recordId); //이미 스크랩을 했는지 확인(토글 및 스크랩 버튼 상태 표시용)
	List<Scrap> findByUserId(long userId); //특정 user의 스크랩 기록 가져오기(마이페이지에 표시하기 위함)
	void deleteByRecordId(long recordId); //기록을 삭제하면 그 기록의 스크랩도 다 삭제
}