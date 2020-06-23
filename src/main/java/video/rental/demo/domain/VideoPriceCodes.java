package video.rental.demo.domain;

public enum VideoPriceCodes {
    REGULAR, NEW_RELEASE, CHILDREN, INVALID;

    public static VideoPriceCodes getPriceCodeFor(int priceCode) {
        switch (priceCode) {
            case 1: return VideoPriceCodes.REGULAR;
            case 2: return VideoPriceCodes.NEW_RELEASE;
            case 3: return VideoPriceCodes.CHILDREN;
            default: return VideoPriceCodes.INVALID;
        }
    }
}