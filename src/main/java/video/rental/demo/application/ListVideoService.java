package video.rental.demo.application;

import java.util.List;

import video.rental.demo.domain.video.Video;

public class ListVideoService {
    
    private ListVideoService() {}

    public static String listVideo(List<Video> videos) {
        StringBuffer strBuf = new StringBuffer();

		for (Video video : videos) {
			strBuf.append(
					"Video type: " + video.getVideoType() + 
					"\tPrice code: " + video.getPriceCode() + 
					"\tRating: " + video.getVideoRating() +
					"\tTitle: " + video.getTitle()
					); 
			strBuf.append("\n");
		}
		strBuf.append("End of list");
        strBuf.append("\n");
        
        return strBuf.toString();
    }
}