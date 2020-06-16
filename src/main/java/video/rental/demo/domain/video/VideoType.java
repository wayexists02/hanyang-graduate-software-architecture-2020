package video.rental.demo.domain.video;

import video.rental.demo.domain.VideoRentalValueObject;
import video.rental.demo.domain.VideoTypes;

public class VideoType implements VideoRentalValueObject<VideoType> {

    private VideoTypes videoType;

    public VideoType(final VideoTypes videoType) {
        this.videoType = videoType;
    }

    public VideoTypes getVideoType() {
        return videoType;
    }

	public int getLateReturnPointPenalty() {
		int pentalty = 0;
		switch (videoType) {
			case VHS:
				pentalty = 1; break;
			case CD:
				pentalty = 2; break;
			case DVD:
				pentalty = 3; break;
			case INVALID:
				pentalty = -1; break;
			}
		return pentalty;
	}

	public int getDaysRentedLimit() {
		int limit = 0;
		switch (videoType) {
			case VHS:
				limit = 5;
				break;
			case CD:
				limit = 3;
				break;
			case DVD:
				limit = 2;
				break;
			case INVALID:
				limit = -1;
				break;
		}
		return limit;
	}

	public int getRentDateLimit() {
		int limit = 0;

		switch (videoType) {
			case VHS: limit = 5; break;
			case CD: limit = 3; break;
			case DVD: limit = 2; break;
			case INVALID: limit = -1; break;
		}
		return limit;
	}

	@Override
	public boolean sameAs(VideoType obj) {
		return this.videoType == obj.videoType;
	}
}