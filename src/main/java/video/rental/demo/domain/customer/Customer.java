package video.rental.demo.domain.customer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import video.rental.demo.domain.VideoRentalEntity;
import video.rental.demo.domain.rental.Rental;
import video.rental.demo.domain.video.Video;

@Entity
public class Customer implements VideoRentalEntity<Customer> {
	@Id
	private CustomerId customerId;
	private CustomerName name;
	private DateOfBirth dateOfBirth;
	
	private RentalList rentalList;

	public Customer() {	// for hibernate
	}

	public Customer(int id, String name, String dateOfBirth) {
		this.customerId = new CustomerId(id);
		this.name = new CustomerName(name);
		this.dateOfBirth = new DateOfBirth(dateOfBirth);

		rentalList = new RentalList();
	}

	public int getCustomerId() {
		return customerId.getId();
	}

	public String getName() {
		return name.getName();
	}

	public List<Integer> getRentalIdList() {
		return rentalList.getRentalIdList();
	}

	public void clearRentals() {
		rentalList.clear();
	}

	public int getNumberOfRentals() {
		return rentalList.getNumberOfRentals();
	}

    public boolean rentVideo(Video video, Rental rental) {
        if (video != null && !video.isRented() && rental != null) {
            if (!isUnderAge(video)) {
				rentalList.addRental(rental.getRentalId());
                video.setRented(true);
                return true;
            }
        }
        return false;
	}

	public boolean returnVideo(Video video, Rental rental) {
		if (video != null && video.isRented() && rental != null) {
            rental.returnVideo();
            video.setRented(false);
            return true;
        }
        return false;
    }
	
	@Override
	public boolean sameIdAs(Customer customer) {
		return this.customerId.sameAs(customer.customerId);
	}

	private boolean isUnderAge(Video video) {
		int age = dateOfBirth.computeAge();

		if (age == -1) {
			return false;
		}
		else {
			switch (video.getVideoRating()) {
				case TWELVE:
					return age < 12;
				case FIFTEEN:
					return age < 15;
				case EIGHTEEN:
					return age < 18;
				default:
					return false;
			}
		}
	}
}
