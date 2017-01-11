import guitarshop.GuitarSalesReporter;
import guitarshop.Presenter;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.*;

import static guitarshop.GuitarSalesReporter.MOST_POPULAR_CATEGORY;
import static guitarshop.GuitarSalesReporter.TOTAL_SALES;
import static org.hamcrest.CoreMatchers.is;

public class HtmlReportSpec {

    Presenter presenter = new Presenter();


    @Test
    public void shouldPresentAnHtmlReportForSalesReport() {

        DecimalFormat formatter = new DecimalFormat("#.##");

        Map<String, Object> reportDto = new HashMap<>();
        Double totalSales = 50.5;
        reportDto.put(TOTAL_SALES, totalSales);
        String mostPopularCategory = "Guitar";
        reportDto.put(MOST_POPULAR_CATEGORY, mostPopularCategory);

        String expectedHtml = "<html><body><article>" +
            "<header><h1>Sales Report</h1></header>" +
            "<p>Total Sales: " + formatter.format(totalSales) + "</p>"+
            "<p>Most Popular Category: " + formatter.format(totalSales) + "</p>"+
            "</article></body></html>";

        String html = presenter.present(reportDto);

        Assert.assertThat(html, is(expectedHtml));

    }

}
