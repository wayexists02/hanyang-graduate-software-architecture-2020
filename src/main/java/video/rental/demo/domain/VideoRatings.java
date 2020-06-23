package video.rental.demo.domain;

public enum VideoRatings {
	TWELVE, FIFTEEN, EIGHTEEN, INVALID;

	public static VideoRatings getRatingFor(int rating) {
		switch (rating) {
			case 1: return VideoRatings.TWELVE;
			case 2: return VideoRatings.FIFTEEN;
			case 3: return VideoRatings.EIGHTEEN;
			default: return VideoRatings.INVALID;
		}
	}
}