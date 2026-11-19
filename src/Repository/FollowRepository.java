package Repository;

import java.util.List;

import Domain.Follow;

public interface FollowRepository {
	void following(Follow follow);
	void unfollowing(Follow follow);
	List<Follow> findFollowers(int followingId);
	List<Follow> findFollowing(int foillowerId);
}
