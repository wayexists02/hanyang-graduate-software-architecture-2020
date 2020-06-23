package video.rental.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

public class VideoRentalSystemTest {
    
    private GoldenMaster goldenMaster;

    @BeforeEach
    public void init() {
        goldenMaster = new GoldenMaster();
    }

    @Test
    // @Disabled
    public void checkRunResultWithGoldenMaster() {
        try {
            // given
            String expected = goldenMaster.getGoldenMaster().replace("\r", "");

            // when
            String actual = goldenMaster.getRunResult().replace("\r", "");

            // then
            assertEquals(expected, actual);
        } catch (Exception exc) {
            exc.printStackTrace();
            throw exc;
        }
    }

    @Test
    @Disabled
    public void generateGoldenMaster() {
        // given

        // when
        goldenMaster.generateGoldenMaster();

        // then
    }
}