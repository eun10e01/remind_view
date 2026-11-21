package remindview.repository;

import java.util.Optional;
import java.util.List;

import remindview.domain.ContentRecord;

public interface RecordRepository {
	void save(ContentRecord record);
	Optional<ContentRecord> findById(int recordId); //존재하지 않는 record를 조회할 경우를 막기 위해 Optional 처리
	List<ContentRecord> findAllShared();
	void update(ContentRecord record);
	void delete(int recordId);
}