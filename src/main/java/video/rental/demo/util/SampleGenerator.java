package video.rental.demo.util;

import video.rental.demo.application.Interacter;

public class SampleGenerator {

	private Interacter interacter;

    public SampleGenerator(Interacter interacter) {
		this.interacter = interacter;
    }

	public void generateSamples() {
		interacter.registerCustomer(0, "James", "1975-5-15");
		interacter.registerCustomer(1, "Brown", "2001-3-17");

		interacter.registerVideo(
			"V1", 2, 1, 2
		);
		interacter.registerVideo(
			"V2", 3, 2, 1
		);

		interacter.rentVideo(0, "V1");
		interacter.rentVideo(0, "V2");
	}
}