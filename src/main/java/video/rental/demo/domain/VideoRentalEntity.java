package video.rental.demo.domain;


public interface VideoRentalEntity<T> {
    
    public boolean sameIdAs(T obj);
}