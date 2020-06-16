package video.rental.demo;

import video.rental.demo.application.Interacter;
import video.rental.demo.domain.repository.CustomerRepository;
import video.rental.demo.domain.repository.RentalRepository;
import video.rental.demo.domain.repository.RepositoryBridge;
import video.rental.demo.domain.repository.VideoRepository;
import video.rental.demo.infrastructure.customer.CustomerRepositoryImpl;
import video.rental.demo.infrastructure.rental.RentalRepositoryImpl;
import video.rental.demo.infrastructure.video.VideoRepositoryImpl;
import video.rental.demo.presentation.*;
import video.rental.demo.util.SampleGenerator;

public class Main
{
	private static GraphicUI ui;

	public static void main(String[] args)
	{
		VideoRepository videoRepository = new VideoRepositoryImpl();
		CustomerRepository customerRepository = new CustomerRepositoryImpl();
		RentalRepository rentalRepository = new RentalRepositoryImpl();

		RepositoryBridge.setVideoRepository(videoRepository);
		RepositoryBridge.setCustomerRepository(customerRepository);
		RepositoryBridge.setRentalRepository(rentalRepository);

		Interacter interacter = new Interacter();
		new SampleGenerator(interacter).generateSamples();

		ui = new GraphicUI(interacter);
		ui.start();
	}
}


