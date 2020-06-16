package video.rental.demo.domain.repository;

import video.rental.demo.domain.rental.Rental;

public interface RentalRepository {
    
    public int newId();
    public void saveRental(Rental rental);
    public Rental findById(int rentalId);
}