package video.rental.demo.application;

import video.rental.demo.domain.repository.RepositoryBridge;
import video.rental.demo.domain.VideoPriceCodes;
import video.rental.demo.domain.customer.Customer;
import video.rental.demo.domain.rental.Rental;
import video.rental.demo.domain.video.Video;

public class CustomerReportService {

	private CustomerReportService() {

	}
    
    public static String getCustomerReport(Customer customer) {
		StringBuffer strBuf = new StringBuffer();

		if (customer == null) {
			strBuf.append("No customer found");
			strBuf.append("\n");
		}
        else {
			strBuf.append("Customer Report for " + customer.getName() + "\n");

			double totalCharge = 0;
			int totalPoint = 0;

			for (int rentalId : customer.getRentalIdList()) {
				double eachCharge = 0;
				int eachPoint = 0;
				int daysRented = 0;

				Rental rental = RepositoryBridge.getRentalRepository().findById(rentalId);
				Video eachVideo = RepositoryBridge.getVideoRepository().findByTitle(rental.getVideoTitle());
	
				daysRented = rental.getDaysRented();
	
				switch (eachVideo.getPriceCode()) {
					case REGULAR:
						eachCharge += 2;
						if (daysRented > 2)
							eachCharge += (daysRented - 2) * 1.5;
						break;
					case NEW_RELEASE:
						eachCharge = daysRented * 3;
						break;
					case CHILDREN:
						eachCharge += 1.5;
						if (daysRented > 3)
							eachCharge += (daysRented - 3) * 1.5;
						break;
					default:
						return "";
				}
				
				eachPoint++;
				if ((eachVideo.getPriceCode() == VideoPriceCodes.NEW_RELEASE))
					eachPoint++;
	
				if (daysRented > eachVideo.getDaysRentedLimit())
					eachPoint -= Math.min(eachPoint, eachVideo.getLateReturnPointPenalty());
	
				strBuf.append("\t" + eachVideo.getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
						+ "\tPoint: " + eachPoint + "\n");
	
				totalCharge += eachCharge;
				totalPoint += eachPoint;
			}
			
			strBuf.append("Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n");
	
			if (totalPoint >= 10) {
				// System.out.println("Congrat! You earned one free coupon");
				strBuf.append("Congrat! You earned one free coupon");
			}
			if (totalPoint >= 30) {
				// System.out.println("Congrat! You earned two free coupon");
				strBuf.append("Congrat! You earned two free coupon");
			}
			strBuf.append("\n");
		}

		return strBuf.toString();
    }
}