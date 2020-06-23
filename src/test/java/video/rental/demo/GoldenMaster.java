package video.rental.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import video.rental.demo.application.Interacter;
import video.rental.demo.domain.repository.CustomerRepository;
import video.rental.demo.domain.repository.RentalRepository;
import video.rental.demo.domain.repository.RepositoryBridge;
import video.rental.demo.domain.repository.VideoRepository;
import video.rental.demo.presentation.CmdUI;
import video.rental.demo.infrastructure.customer.CustomerRepositoryImpl;
import video.rental.demo.infrastructure.rental.RentalRepositoryImpl;
import video.rental.demo.infrastructure.video.VideoRepositoryImpl;
import video.rental.demo.util.SampleGenerator;

public class GoldenMaster {

    private String goldenMasterFile = ".goldenmaster/goldenmaster.txt";
    private String simulatedInput = "1\n" // List customer
                                    + "2\n"	// List video
                                    + "3\n"	// Register customer
                                    + "Peter\n" + "2\n" + "1980-07-11\n" 
                                    + "1\n"	// List customer
                                    + "4\n" // Register video
                                    + "V3\n" + "1\n" + "2\n" + "3\n"
                                    + "2\n" // List video 
                                    + "5\n" // Rent video
                                    + "2\n" + "V3\n"
                                    + "1\n"	// List customer
                                    + "6\n" // Return video
                                    + "0\n" + "V1\n"
                                    + "7\n" // Show customer report
                                    + "0\n"
                                    + "6\n" // Return video
                                    + "0\n" + "V2\n"
                                    + "8\n" // Show customer and clear rentals
                                    + "0\n"
                                    + "1\n" // List customers
                                    + "0\n"; // Bye";

    private CmdUI ui;

    public String getRunResult() {

        // redirect input
        ByteArrayInputStream istream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(istream);

        // redirect output
        ByteArrayOutputStream ostream = new ByteArrayOutputStream();
        PrintStream pstream  = new PrintStream(ostream);
        System.setOut(pstream);

        // run app
		VideoRepository videoRepository = new VideoRepositoryImpl();
		CustomerRepository customerRepository = new CustomerRepositoryImpl();
		RentalRepository rentalRepository = new RentalRepositoryImpl();

		RepositoryBridge.setVideoRepository(videoRepository);
		RepositoryBridge.setCustomerRepository(customerRepository);
		RepositoryBridge.setRentalRepository(rentalRepository);

		Interacter interacter = new Interacter();
		new SampleGenerator(interacter).generateSamples();

        ui = new CmdUI(interacter);
        ui.start();

        return ostream.toString();
    }

    public String getGoldenMaster() {
        try {
            String goldenMasterString = Files.readAllLines(Paths.get(goldenMasterFile))
                                             .stream()
                                             .collect(Collectors.joining("\n", "", "\n"));
            return goldenMasterString;
        }
        catch (IOException exc) {
            exc.printStackTrace();
            return null;
        }
    }

    public void generateGoldenMaster() {
        String result = getRunResult();

        try {
            Files.write(Paths.get(goldenMasterFile), result.getBytes());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}