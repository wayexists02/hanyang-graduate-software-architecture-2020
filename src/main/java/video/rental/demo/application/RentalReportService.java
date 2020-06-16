package video.rental.demo.application;

import video.rental.demo.domain.repository.RepositoryBridge;
import video.rental.demo.domain.customer.Customer;
import video.rental.demo.domain.rental.Rental;
import video.rental.demo.domain.rental.RentalStatus;
import video.rental.demo.domain.video.Video;

public class RentalReportService {
    
    private RentalReportService() {
		
	}

    public static String getRentalReport(Customer customer) {
		StringBuffer strBuf = new StringBuffer();


        if (customer == null) {
			strBuf.append("No customer found");
			strBuf.append("\n");
        }
        else {
            strBuf.append("Id: " + customer.getCustomerId() + "\nName: " + customer.getName() + "\tRentals: "
                    + customer.getNumberOfRentals());
			strBuf.append("\n");
			
			for (int rentalId: customer.getRentalIdList()) {
				Rental rental = RepositoryBridge.getRentalRepository().findById(rentalId);
				Video video = RepositoryBridge.getVideoRepository().findByTitle(rental.getVideoTitle());
				RentalStatus rentalStatus = rental.getStatus();

				strBuf.append("\tTitle: " + video.getTitle() + " ");
				strBuf.append("\tPrice Code: " + video.getPriceCode());
				strBuf.append("\tReturn Status: " + rentalStatus);
				strBuf.append("\n");
			}
		}

		return strBuf.toString();
    }
}