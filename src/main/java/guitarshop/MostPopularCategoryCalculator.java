package guitarshop;

import java.util.Comparator;
import java.util.Map;

public class MostPopularCategoryCalculator {

    public String calculate(final Map<String,Integer> categories) {
        return categories
                .entrySet()
                .stream()
                .sorted(byCount())
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("no category provided"));

    }

    private Comparator<Map.Entry<String, Integer>> byCount() {
        return (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue());
    }

}
