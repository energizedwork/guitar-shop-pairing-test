import guitarshop.GuitarSalesReporter;
import guitarshop.InvalidLineException;
import guitarshop.Transaction;
import guitarshop.SalesParser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.dsig.TransformService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalesParserSpec {

    SalesParser parser = new SalesParser();


    @Test(expected = InvalidLineException.class)
    public void shouldThrowExceptionWhenThereAreEmptyLines() {
        List<String> lines = new ArrayList<>();
        lines.add("");

        parser.parse(lines);
    }

    @Test
    public void shouldParseLinesIntoTransactions() {
        List<String> lines = new ArrayList<>();
        lines.add("2016-11-18T12:31:33,Deering 5 string,Banjo,1,10.00");

        List<Transaction> transactions = parser.parse(lines);

        assertThat(transactions.size(), is(1));
        Transaction transaction = transactions.get(0);
        assertThat(transaction.getAmount(), is(10.00));
        assertThat(transaction.getProductType(), is("Banjo"));
        assertThat(transaction.getBrand(), is("Deering 5 string"));
        assertThat(transaction.getQuantity(), is(1));

        //assertThat(transaction.happenedAt(), is(new Date()));


    }



}
