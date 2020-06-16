package video.rental.demo.domain.rental;

import javax.persistence.Entity;
import javax.persistence.Id;

import video.rental.demo.domain.VideoRentalEntity;

@Entity
public class Rental implements VideoRentalEntity<Rental> {

	@Id
	private RentalId id;

	private RentalStatus status; // 0 for Rented, 1 for Returned
	private RentalDuration rentalDuration;

	private String videoTitle;

	Rental() {
	}

	public Rental(int rentalId, String videoTitle) {
		this.id = new RentalId(rentalId);
		this.videoTitle = videoTitle;
		this.status = RentalStatus.RENTED;
		this.rentalDuration = new RentalDuration();
	}

	public int getRentalId() {
		return id.getId();
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public RentalStatus getStatus() {
		return status;
	}

	public void returnVideo() {
		if (status == RentalStatus.RENTED) {
			this.status = RentalStatus.RETURNED;
			rentalDuration.complete();
		}
	}

	public int getDaysRented() {
		return rentalDuration.getDaysRented();
	}

	@Override
	public boolean sameIdAs(Rental obj) {
		return id == obj.id;
	}
}