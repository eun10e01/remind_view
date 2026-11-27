package remindview.domain;

public class Follow {
	long followerId; //long으로 타입변경
	long followingId;
	
	public Follow(long followerId, long followingId) {
		this.followerId = followerId;
		this.followingId = followingId;
	}
	
	//getter
	public long getFollowerId() {
		return followerId;
	}
	
	public long getFollowingId() {
		return followingId;
	}
}
