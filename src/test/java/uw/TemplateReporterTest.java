package uw;

import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TemplateReporterTest {


    @Test
    public void findTemplate(){
        String expected = TestHelper.read("src/test/resources/base-report.txt");

        StringWriter writer = new StringWriter();

        List<Model.Sale> sales = null;
        new TemplateReporter("sample.fm").process(sales, writer);

        assertEquals("tom", writer.toString());

//        assertEquals(expected, writer.toString());

    }

}
