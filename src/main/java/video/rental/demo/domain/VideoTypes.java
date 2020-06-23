package video.rental.demo.domain;

public enum VideoTypes {
    VHS, CD, DVD, INVALID;

    public static VideoTypes getVideoTypeFor(int type) {
        switch (type) {
            case 1: return VideoTypes.VHS;
            case 2: return VideoTypes.CD;
            case 3: return VideoTypes.DVD;
            default: return VideoTypes.INVALID;
        }
    }
}