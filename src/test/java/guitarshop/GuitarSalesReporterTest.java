package guitarshop;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by toma on 14/06/17.
 */
public class GuitarSalesReporterTest {

    private GuitarSalesReporter instance;

    private String goodCsvPath = "src/main/resources/sales.csv";

    private String expectedOutputFromSalesCSv = "############\n" +
            "Sales Report\n" +
            "############\n" +
            "\n" +
            "Total sales: £6359.529999999999\n" +
            "Most popular category: Strings";


    @Test
    public void generateSalesReport() throws Exception {

        // Initialise the instance under test
        instance = new GuitarSalesReporter();

        final String result = instance.generateSalesReport(goodCsvPath);

        assertEquals(expectedOutputFromSalesCSv, result);
    }

    @Test
    public void main() throws Exception {

        /**
         * Change the System.out from console to a String so we can assert the method output
         */
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);

        // Initialise the instance under test
        instance = new GuitarSalesReporter();

        // Invoke the method under test, no output is returned as it is written to System.out (which we redirected earlier)
        instance.main(null);

        // Assert that output matches expected
        assertEquals(expectedOutputFromSalesCSv + "\n", baos.toString());

        // Put things back
        System.out.flush();
        System.setOut(old);
    }

}