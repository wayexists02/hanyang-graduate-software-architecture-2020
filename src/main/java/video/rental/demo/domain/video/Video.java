package video.rental.demo.domain.video;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import video.rental.demo.domain.VideoPriceCodes;
import video.rental.demo.domain.VideoRatings;
import video.rental.demo.domain.VideoRentalEntity;
import video.rental.demo.domain.VideoTypes;


@Entity
@Table(name = "VIDEO", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
public class Video implements VideoRentalEntity<Video> {
	
	@Id
	private VideoTitle title;
	private Rating videoRating;
	private VideoPriceCode priceCode;

	private VideoType videoType;

	private Date registeredDate;
	private boolean rented;

	public Video() {}	// for hibernate

	public Video(String title, VideoTypes videoType, VideoPriceCodes priceCode, VideoRatings videoRating) {
		this.title = new VideoTitle(title); 
		this.videoType = new VideoType(videoType);
		this.priceCode = new VideoPriceCode(priceCode);
		this.videoRating = new Rating(videoRating);
		this.registeredDate = new Date();
	}

	public int getLateReturnPointPenalty() {
		return videoType.getLateReturnPointPenalty();
	}

	public int getDaysRentedLimit() {
		return videoType.getDaysRentedLimit();
	}

	public VideoPriceCodes getPriceCode() {
		return priceCode.getPriceCode();
	}

	public void setPriceCode(VideoPriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title.getTitle();
	}

	public VideoRatings getVideoRating() {
		return videoRating.getRating();
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public VideoTypes getVideoType() {
		return videoType.getVideoType();
	}

	public int getRentDateLimit() {
		return videoType.getDaysRentedLimit();
	}

	@Override
	public boolean sameIdAs(Video obj) {
		return this.title.equals(obj.title);
	}
}
