package video.rental.demo.domain.video;

import video.rental.demo.domain.VideoRentalValueObject;

public class VideoTitle implements VideoRentalValueObject<VideoTitle> {
    
    private final String title;

    public VideoTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean sameAs(VideoTitle obj) {
        return this.title.equals(obj.title);
    }
}