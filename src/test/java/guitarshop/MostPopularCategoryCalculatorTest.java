package guitarshop;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MostPopularCategoryCalculatorTest {

    private final MostPopularCategoryCalculator underTest = new MostPopularCategoryCalculator();

    @Test
    public void shouldCalculateMostPopularCategory() {

        final Map<String,Integer> categories = new HashMap<>();

        categories.put("Banjo", 10);
        categories.put("Guitar", 2);
        categories.put("Ukulele", 5);

        final String result = underTest.calculate(categories);

        assertEquals("Guitar", result);
    }

}