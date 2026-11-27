package remindview.service;

import java.util.List;

import remindview.domain.Comment;
import remindview.repository.CommentRepository;
import remindview.repository.RecordRepository;
import remindview.util.ServiceException;

public class CommentService {
	private final CommentRepository commentRepository;
	private final RecordRepository recordRepository;
	
	public CommentService(CommentRepository commentRepository, RecordRepository recordRepository) {
		this.commentRepository = commentRepository;
		this.recordRepository = recordRepository;
	}
	
	//댓글 작성
	public void addComment(long userId, long recordId, String content) {
		if(recordRepository.findById(recordId).isEmpty()) {
			throw new ServiceException("존재하지 않는 기록에는 댓글을 작성할 수 없습니다.");
		}
		
		Comment comment = new Comment(recordId, userId, content);
		commentRepository.save(comment);
	}
	
	//특정 기록의 댓글 목록 조회
	public List<Comment> getCommentsByRecordId(long recordId){
		return commentRepository.findByRecordId(recordId);
	}
	
	//댓글 수정
	public void updateComment(long commentId, long loginUserId, String newContent) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ServiceException("수정할 댓글이 존재하지 않습니다."));
		
		if(!comment.isOwned(loginUserId)) {
			throw new ServiceException("본인이 작성한 댓글만 수정할 수 있습니다.");
		}
		
		comment.edit(newContent);
		commentRepository.update(comment);
	}
	
	//댓글 삭제
	public void deleteComment(long commentId, long loginUserId) {
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ServiceException("삭제할 댓글이 존재하지 않습니다."));
		
		if(!comment.isOwned(loginUserId)) {
			throw new ServiceException("본인이 작성한 댓글만 삭제할 수 있습니다.");
		}
		
		commentRepository.delete(commentId);
	}
}