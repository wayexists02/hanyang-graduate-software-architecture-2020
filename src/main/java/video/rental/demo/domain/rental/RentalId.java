package video.rental.demo.domain.rental;

import video.rental.demo.domain.VideoRentalValueObject;

public class RentalId implements VideoRentalValueObject<RentalId> {
    
    private final int id;

    public RentalId(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean sameAs(RentalId obj) {
        return this.id == obj.id;
    }
}