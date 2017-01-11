package uw;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SalesParserTest {


    @Test(expected = RuntimeException.class)
    public void fiileNotFound() {
        List<Model.Sale> sales = new SalesParser().sales("x");
    }

    @Test
    public void sales() {
        List<Model.Sale> sales = new SalesParser().sales("src/main/resources/sales.csv");
        assertEquals(17, sales.size());
    }

    // todo indiviudual line parse tests
}