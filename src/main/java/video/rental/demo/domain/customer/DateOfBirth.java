package video.rental.demo.domain.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import video.rental.demo.domain.VideoRentalValueObject;

public class DateOfBirth implements VideoRentalValueObject<DateOfBirth> {
    
    private String dateOfBirth;

    public DateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

	public int computeAge() {
		try {
			Calendar calDateOfBirth = Calendar.getInstance();
			calDateOfBirth.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(getDateOfBirth()));

			// get current date
			Calendar calNow = Calendar.getInstance();
			calNow.setTime(new java.util.Date());

			// calculate age different in years and months
			int ageYr = (calNow.get(Calendar.YEAR) - calDateOfBirth.get(Calendar.YEAR));
			int ageMo = (calNow.get(Calendar.MONTH) - calDateOfBirth.get(Calendar.MONTH));

			// decrement age in years if month difference is negative
			if (ageMo < 0) {
				ageYr--;
			}
			int age = ageYr;
			return age;

		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
    }
    
    @Override
    public boolean sameAs(DateOfBirth obj) {
        return dateOfBirth.equals(obj.dateOfBirth);
    }
}