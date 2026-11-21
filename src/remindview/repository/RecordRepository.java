package remindview.repository;

import java.util.Optional;
import java.util.List;

import remindview.domain.ContentRecord;

public interface RecordRepository {
	Optional<ContentRecord> findById(long recordId); //존재하지 않는 record를 조회할 경우를 막기 위해 Optional 처리
	List<ContentRecord> findByUserId(long userId); //특정 user가 쓴 기록을 모두 띄우기 위해 사용(마이페이지에서)
	List<ContentRecord> findSharedByUserId(long userId); //특정 user가 쓴 공유 기록만 보여주기 위해 사용(다른 회원 프로필에서)
	List<ContentRecord> findAllShared(); //전체 기록 화면에서 전체 회원의 공개 기록을 띄우기 위해 사용
	List<ContentRecord> searchSharedByKeyword(String keyword); //기록 검색을 위해 사용
	void save(ContentRecord record); //기록 저장
	void update(ContentRecord record); //기록 수정
	void delete(long recordId); //기록 삭제
}