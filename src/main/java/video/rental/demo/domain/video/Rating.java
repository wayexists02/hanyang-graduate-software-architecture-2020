package video.rental.demo.domain.video;

import video.rental.demo.domain.VideoRatings;
import video.rental.demo.domain.VideoRentalValueObject;

public class Rating implements VideoRentalValueObject<Rating> {

	private VideoRatings rating;

	public Rating(final VideoRatings rating) {
		this.rating = rating;
	}

	public VideoRatings getRating() {
		return rating;
	}

	@Override
	public boolean sameAs(Rating obj) {
		return this.rating == obj.rating;
	}
}
