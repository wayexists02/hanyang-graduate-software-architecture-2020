package video.rental.demo.application;

import java.util.List;

import video.rental.demo.domain.customer.Customer;

public class ListCustomerService {
    
    private ListCustomerService() {
        
    }

    public static String listCustomer(List<Customer> customers) {
		StringBuffer strBuf = new StringBuffer();
        
		for (Customer customer : customers) {
			strBuf.append(RentalReportService.getRentalReport(customer));
		}
		strBuf.append("End of list");
        strBuf.append("\n");
        
        return strBuf.toString();
    }
}