package remindview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import remindview.domain.ContentRecord;
import remindview.domain.Scrap;
import remindview.repository.RecordRepository;
import remindview.repository.ScrapRepository;
import remindview.util.ServiceException;

public class ScrapService {
	private final ScrapRepository scrapRepository;
	private final RecordRepository recordRepository;
	
	public ScrapService(ScrapRepository scrapRepository, RecordRepository recordRepository) {
		this.scrapRepository = scrapRepository;
		this.recordRepository = recordRepository;
	}
	
	//스크랩 토글(T-스크랩 등록 / F-스크랩 취소)
	public boolean toggleScrap(long userId, long recordId) {
		if(recordRepository.findById(recordId).isEmpty()) {
			throw new ServiceException("존재하지 않는 기록은 스크랩할 수 없습니다.");
		}
		
		if(scrapRepository.exists(userId, recordId)) {
			scrapRepository.delete(userId, recordId);
			
			return false;
		}
		else {
			scrapRepository.save(new Scrap(userId, recordId));
			
			return true;
		}
	}
	
	//특정 기록의 스크랩 여부 확인
	public boolean isScrapped(long userId, long recordId) {
		return scrapRepository.exists(userId, recordId);
	}
	
	//내가 스크랩한 기록 목록 조회
	public List<ContentRecord> getScrappedRecord(long userId){
		List<Scrap> scraps = scrapRepository.findByUserId(userId);
		List<ContentRecord> result = new ArrayList<>();
		
		for(Scrap scrap : scraps) {
			long recordId = scrap.getRecordId();
			Optional<ContentRecord> optionalRecord = recordRepository.findById(recordId);
			
			if(optionalRecord.isPresent()) {
				ContentRecord record = optionalRecord.get();
				result.add(record);
			}
		}
		
		return result;
	}
}