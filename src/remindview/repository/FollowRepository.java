package remindview.repository;

import java.util.List;

import remindview.domain.Follow;

public interface FollowRepository {
	void following(Follow follow); //팔로우하기
	void unfollowing(Follow follow); //언팔로우하기
	List<Follow> findFollowers(long followingId); //나를 팔로우하는 사람 리스트 조회하기
	List<Follow> findFollowing(long foillowerId); //내가 팔로우하는 사람 리스트 조회하기
	boolean exists(long followerId, long followingId); //팔로우 여부 확인하기
}
