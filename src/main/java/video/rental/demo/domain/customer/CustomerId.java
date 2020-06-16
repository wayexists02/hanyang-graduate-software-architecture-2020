package video.rental.demo.domain.customer;

import video.rental.demo.domain.VideoRentalValueObject;

public class CustomerId implements VideoRentalValueObject<CustomerId> {

    private final int id;

    public CustomerId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean sameAs(CustomerId customerId) {
        return this.id == customerId.id;
    }
}