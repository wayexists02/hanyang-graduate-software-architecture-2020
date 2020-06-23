package video.rental.demo.domain.customer;

import video.rental.demo.domain.VideoRentalValueObject;

public class CustomerName implements VideoRentalValueObject<CustomerName> {
    
    private String name;

    public CustomerName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean sameAs(CustomerName obj) {
        return name.equals(obj.name);
    }
}