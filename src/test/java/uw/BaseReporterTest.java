package uw;

import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BaseReporterTest {


    @Test
    public void baseReport(){
        String expected = TestHelper.read("src/test/resources/base-report.txt");

        StringWriter writer = new StringWriter();

        List<Model.Sale> sales = null;
        new BaseReporter().process(sales, writer);



        assertEquals(expected, writer.toString());

    }

}
