import guitarshop.GuitarSalesReporter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static guitarshop.GuitarSalesReporter.MOST_POPULAR_CATEGORY;
import static guitarshop.GuitarSalesReporter.TOTAL_SALES;

public class GuitarSalesReporterSpec {



    @Test
    public void shouldProvideTheTotalSalesWhenThereAreNoTransacations() {
        List<String> lines = new ArrayList<>();

        Map<String, Object> results = GuitarSalesReporter.generateReport(lines);

        Assert.assertEquals(0.0,results.get(TOTAL_SALES));
    }

    @Test
    public void shouldProvideTheTotalSalesForGivenTransactions() {
        List<String> lines = new ArrayList<>();
        lines.add("Time,Item,Category,Quantity,PriceEach");
        lines.add("2016-11-18T12:31:33,Deering 5 string,Banjo,1,10.00");
        lines.add("2016-11-18T15:01:00,Fender Telecaster,Guitar,1,0.5");

        Map<String, Object> results = GuitarSalesReporter.generateReport(lines);

        Assert.assertEquals(10.5, results.get(TOTAL_SALES));
    }

    @Test
    public void shouldProvideTheMostPopularCategory() {
        List<String> lines = new ArrayList<>();
        lines.add("Time,Item,Category,Quantity,PriceEach");
        lines.add("2016-11-18T12:31:33,Deering 5 string,Banjo,1,10.00");
        lines.add("2016-11-18T15:01:00,Fender Telecaster,Guitar,1,0.5");
        lines.add("2016-11-21T12:30:40,Jackson Soloist,Guitar,1,999.99");

        Map<String, Object> results = GuitarSalesReporter.generateReport(lines);

        Assert.assertEquals("Guitar", results.get(MOST_POPULAR_CATEGORY));
    }

}
