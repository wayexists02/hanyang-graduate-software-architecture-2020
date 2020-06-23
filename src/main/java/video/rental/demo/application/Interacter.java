package video.rental.demo.application;

import java.util.List;

import video.rental.demo.domain.VideoPriceCodes;
import video.rental.demo.domain.VideoRatings;
import video.rental.demo.domain.VideoTypes;
import video.rental.demo.domain.customer.Customer;
import video.rental.demo.domain.rental.Rental;
import video.rental.demo.domain.video.Video;
import video.rental.demo.domain.repository.RepositoryBridge;


public class Interacter {

    public Interacter() {
        
    }
    
    public String clearRentals(int customerCode) {
		Customer foundCustomer = RepositoryBridge.getCustomerRepository().findById(customerCode);
		String rentalReport = RentalReportService.getRentalReport(foundCustomer);
		foundCustomer.clearRentals();
		return rentalReport;
    }

    public void returnVideos(int customerCode, String videoTitle) {
		Customer foundCustomer = RepositoryBridge.getCustomerRepository().findById(customerCode);
		Video foundVideo = RepositoryBridge.getVideoRepository().findByTitle(videoTitle);

        if (foundCustomer != null && foundVideo != null) {
            for (int rentalId: foundCustomer.getRentalIdList()) {
                Rental foundRental = RepositoryBridge.getRentalRepository().findById(rentalId);
                if (foundRental.getVideoTitle().equals(videoTitle)) {
                    foundCustomer.returnVideo(foundVideo, foundRental);
            
                    RepositoryBridge.getCustomerRepository().saveCustomer(foundCustomer);
                    RepositoryBridge.getVideoRepository().saveVideo(foundVideo);
                    RepositoryBridge.getRentalRepository().saveRental(foundRental);
                }
            }
        }
    }

    public String listCustomers() {
		List<Customer> customers = RepositoryBridge.getCustomerRepository().findAllCustomers();
		return ListCustomerService.listCustomer(customers).toString();
    }

    public String listVideos() {
        List<Video> videos = RepositoryBridge.getVideoRepository().findAllVideos();
		return ListVideoService.listVideo(videos).toString();
    }

    public void rentVideo(int code, String videoTitle) {
		Customer foundCustomer = RepositoryBridge.getCustomerRepository().findById(code);
		Video foundVideo = RepositoryBridge.getVideoRepository().findByTitle(videoTitle);

        if (foundCustomer != null && foundVideo != null) {
            int rentalId = RepositoryBridge.getRentalRepository().newId();
            Rental rental = new Rental(rentalId, foundVideo.getTitle());
            foundCustomer.rentVideo(foundVideo, rental);
            
            RepositoryBridge.getCustomerRepository().saveCustomer(foundCustomer);
            RepositoryBridge.getVideoRepository().saveVideo(foundVideo);
            RepositoryBridge.getRentalRepository().saveRental(rental);
        }
    }

    public String getCustomerReport(int code) {
        Customer foundCustomer = RepositoryBridge.getCustomerRepository().findById(code);
        return CustomerReportService.getCustomerReport(foundCustomer);
    }

    public void registerCustomer(int id, String name, String dateOfBirth) {
        Customer customer = new Customer(id, name, dateOfBirth);
        RepositoryBridge.getCustomerRepository().saveCustomer(customer);
    }

    public void registerVideo(String title, int videoType, int priceCode, int videoRating) {
        
        Video video = new Video(
            title, 
            VideoTypes.getVideoTypeFor(videoType), 
            VideoPriceCodes.getPriceCodeFor(priceCode), 
            VideoRatings.getRatingFor(videoRating)
        );
        RepositoryBridge.getVideoRepository().saveVideo(video);
    }
}