package guitarshop;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class GuitarSalesReporter {

    public static final String TOTAL_SALES = "totalSales";
    public static final String MOST_POPULAR_CATEGORY = "mostPopularCategory";

    public static void main(String[] args) throws Exception {
        File csvFile = new File("src/main/resources/sales.csv");
        List<String> lines = Files.readAllLines(csvFile.toPath());

        Map<String, Object> results = generateReport(lines);

        System.out.println("############");
        System.out.println("Sales Report");
        System.out.println("############");
        System.out.println();
        System.out.println("Total sales: £" + results.get(TOTAL_SALES));
        System.out.println("Most popular category: " + results.get("mostPopularCategory"));

    }

    public static Map<String, Object> generateReport(List<String> lines) {
        double totalSales = 0d;
        for (int i = 1; i < lines.size(); i++) {
            String[] cells = lines.get(i).split(",");
            if (cells.length < 5) continue;
            int quantity = Integer.parseInt(cells[3]);
            double price = Double.parseDouble(cells[4]);
            totalSales += (quantity * price);
        }

        HashMap<String, Integer> categories = new HashMap<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] cells = lines.get(i).split(",");
            if (cells.length < 5) continue;
            String category = cells[2];
            int quantity = Integer.parseInt(cells[3]);
            Integer existingCategoryCount = categories.get(category);
            int newTotal;
            if (existingCategoryCount != null) {
                newTotal = existingCategoryCount + quantity;
            } else {
                newTotal = quantity;
            }
            categories.put(category, newTotal);
        }

        int biggestSoFar = 0;
        String mostPopularCategory = null;
        for (Iterator<String> iterator = categories.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            int quantity = categories.get(key);
            if (quantity > biggestSoFar) {
                mostPopularCategory = key;
                biggestSoFar = quantity;
            }
        }

        Map<String, Object> values = new HashMap<>();
        values.put(TOTAL_SALES, totalSales);
        values.put(MOST_POPULAR_CATEGORY, mostPopularCategory);
        return values;
    }
}
