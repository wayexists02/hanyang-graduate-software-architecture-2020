package video.rental.demo.domain.repository;

import java.util.List;

import video.rental.demo.domain.video.Video;

public interface VideoRepository {
    
    public Video findByTitle(String title);
    public void saveVideo(Video video);
    public List<Video> findAllVideos();
}