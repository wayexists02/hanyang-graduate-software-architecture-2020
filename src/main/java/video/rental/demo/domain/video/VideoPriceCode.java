package video.rental.demo.domain.video;

import video.rental.demo.domain.VideoPriceCodes;
import video.rental.demo.domain.VideoRentalValueObject;

public class VideoPriceCode implements VideoRentalValueObject<VideoPriceCode> {

    private VideoPriceCodes priceCode;

    public VideoPriceCode(final VideoPriceCodes priceCode) {
        this.priceCode = priceCode;
    }

    public VideoPriceCodes getPriceCode() {
        return priceCode;
    }

    @Override
    public boolean sameAs(VideoPriceCode obj) {
        return priceCode == obj.priceCode;
    }
}