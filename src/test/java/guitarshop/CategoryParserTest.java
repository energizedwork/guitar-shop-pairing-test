package guitarshop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CategoryParserTest {

    private final CategoryParser underTest = new CategoryParser();

    @Test
    public void countVolumesByCategory() {

        // arrange
        final List<String> reportData = new ArrayList<>();
        reportData.add("Time,Item,Category,Quantity,PriceEach");
        reportData.add("2016-11-19T12:31:37,Ernie ball light steel strings,Strings,12,1.20");
        reportData.add("2016-11-22T12:11:42,Ibanez Steve Vai 7 string,Guitar,1,2999.99");
        reportData.add("2016-11-21T11:11:11,Epiphone Les Paul,Guitar,1,449.99");
        reportData.add("2016-11-21T11:50:15,Ernie ball nylon strings,Strings,10,1.40");
        reportData.add("2016-11-21T12:30:40,Jackson Soloist,Guitar,1,999.99");

        // act
        final Map<String,Integer> result = underTest.countVolumesByCategory(reportData);

        // assert
        assertThat(result.values().size(), is(2));
        assertTrue(result.containsKey("Guitar"));
        assertTrue(result.containsKey("Strings"));
        assertThat(result.get("Strings"), is(22));
        assertThat(result.get("Guitar"), is(3));

    }

}