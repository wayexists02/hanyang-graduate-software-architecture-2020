package video.rental.demo.infrastructure.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import video.rental.demo.domain.video.Video;
import video.rental.demo.domain.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {
    
    private Map<String, Video> videos;

    public VideoRepositoryImpl() {
        videos = new TreeMap<>();
    }

    @Override
    public void saveVideo(Video video) {
        this.videos.put(video.getTitle(), video);
    }

    @Override
    public Video findByTitle(String title) {
        return videos.getOrDefault(title, null);
    }

    @Override
    public List<Video> findAllVideos() {
        List<Video> videoList = new ArrayList<>(videos.size());

        for (Video video: videos.values()) {
            videoList.add(video);
        }

        return videoList;
    }
}