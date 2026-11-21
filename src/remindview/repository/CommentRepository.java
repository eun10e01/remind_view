package remindview.repository;

import java.util.Optional;
import java.util.List;

import remindview.domain.Comment;

public interface CommentRepository {
	Optional<Comment> findById(long commentId); //존재하지 않는 comment를 조회할 경우를 막기 위해 Optional 처리
	List<Comment> findByRecordId(long recordId); //특정 기록의 모든 댓글 찾기(댓글 보여줘야 하니까)
	void save(Comment comment); //댓글 저장
	void update(Comment comment); //댓글 수정
	void delete(long commentId); //댓글 삭제
	void deleteByRecordId(long recordId); //기록을 삭제하면 해당 기록의 모든 댓글도 삭제
}