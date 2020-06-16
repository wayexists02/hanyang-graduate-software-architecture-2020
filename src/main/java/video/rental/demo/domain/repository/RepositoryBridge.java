package video.rental.demo.domain.repository;


public abstract class RepositoryBridge {
    
    private static VideoRepository videoRepository;
    private static CustomerRepository customerRepository;
    private static RentalRepository rentalRepository;

    public static VideoRepository getVideoRepository() {
        return videoRepository;
    }

    public static CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public static RentalRepository getRentalRepository() {
        return rentalRepository;
    }

    public static void setVideoRepository(VideoRepository videoRepository) {
        RepositoryBridge.videoRepository = videoRepository;
    }

    public static void setCustomerRepository(CustomerRepository customerRepository) {
        RepositoryBridge.customerRepository = customerRepository;
    }

    public static void setRentalRepository(RentalRepository rentalRepository) {
        RepositoryBridge.rentalRepository = rentalRepository;
    }
}