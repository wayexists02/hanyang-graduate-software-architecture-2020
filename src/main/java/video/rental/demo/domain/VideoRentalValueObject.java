package video.rental.demo.domain;


public interface VideoRentalValueObject<T> {
    
    public boolean sameAs(T obj);
}