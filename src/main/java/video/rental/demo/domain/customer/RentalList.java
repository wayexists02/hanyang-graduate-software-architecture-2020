package video.rental.demo.domain.customer;

import java.util.LinkedList;
import java.util.List;

import video.rental.demo.domain.VideoRentalValueObject;

public class RentalList implements VideoRentalValueObject<RentalList> {
    
    private final List<Integer> rentalList;

    public RentalList() {
        rentalList = new LinkedList<>();
    }

    public List<Integer> getRentalIdList() {
        return rentalList;
    }

    public void addRental(int rentalId) {
        if (!rentalList.contains(Integer.valueOf(rentalId)))
            rentalList.add(Integer.valueOf(rentalId));
    }

    public void clear() {
        rentalList.clear();
    }

    public int getNumberOfRentals() {
        return rentalList.size();
    }

    @Override
    public boolean sameAs(RentalList obj) {
        if (rentalList.size() == obj.rentalList.size()) {
            for (int i = 0; i < rentalList.size(); i += 1) {
                if (rentalList.get(i) != obj.rentalList.get(i))
                    return false;
            }
            return true;
        }
        return false;
    }
}