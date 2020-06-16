package video.rental.demo.domain.rental;

import java.util.Date;

import video.rental.demo.domain.VideoRentalValueObject;

public class RentalDuration implements VideoRentalValueObject<RentalDuration> {
    
    private Date rentDate;
    private Date returnDate;

    public RentalDuration() {
        rentDate = new Date();
    }

    public void complete() {
        returnDate = new Date();
    }

	public int getDaysRented() {
		long diff = 0;
		if (returnDate != null) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}

    @Override
    public boolean sameAs(RentalDuration obj) {
        if (returnDate == null) {
            return obj.returnDate == null && rentDate.getTime() == obj.rentDate.getTime();
        }
        else {
            return obj.returnDate != null && rentDate.getTime() == obj.rentDate.getTime() && returnDate.getTime() == obj.returnDate.getTime();
        }
    }
}