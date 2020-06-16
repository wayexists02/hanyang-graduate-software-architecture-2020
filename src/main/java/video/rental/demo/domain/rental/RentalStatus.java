package video.rental.demo.domain.rental;

import video.rental.demo.domain.VideoRentalValueObject;

public enum RentalStatus implements VideoRentalValueObject<RentalStatus> {
    RENTED(0), RETURNED(1), INVALID(-1);

    private final int status;

    private RentalStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public boolean sameAs(RentalStatus obj) {
        return status == obj.status;
    }
}