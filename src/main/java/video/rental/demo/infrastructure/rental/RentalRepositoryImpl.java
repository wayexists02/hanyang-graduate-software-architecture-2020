package video.rental.demo.infrastructure.rental;

import java.util.Map;
import java.util.TreeMap;

import video.rental.demo.domain.rental.Rental;
import video.rental.demo.domain.repository.RentalRepository;

public class RentalRepositoryImpl implements RentalRepository {
    
    private Map<Integer, Rental> rentals;

    public RentalRepositoryImpl() {
        rentals = new TreeMap<>();
    }

    @Override
    public int newId() {
        return rentals.size();
    }

    @Override
    public Rental findById(int rentalId) {
        return rentals.getOrDefault(rentalId, null);
    }

    @Override
    public void saveRental(Rental rental) {
        rentals.put(rental.getRentalId(), rental);
    }
}