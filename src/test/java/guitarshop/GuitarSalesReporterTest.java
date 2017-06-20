package guitarshop;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuitarSalesReporterTest {

    private final GuitarSalesReporter underTest = new GuitarSalesReporter();

    @Test
    public void shouldPrintSalesReport() throws Exception {

        final String expectedReport =
                "############\n" +
                "Sales Report\n" +
                "############\n" +
                "\n" +
                "Total sales: £6359.529999999999\n" +
                "Most popular category: Strings\n";

        final String report = underTest.prepareReport();

        assertEquals(expectedReport, report);
    }

}