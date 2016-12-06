package uw;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class GuitarSalesReporter {

    public static void main(String[] args) throws Exception {
        File csvFile = new File("src/main/resources/sales.csv");
        List<String> lines = Files.readAllLines(csvFile.toPath());

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

        ArrayList<Map.Entry<String, Integer>> entryList = new ArrayList<>(categories.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
        });

        String mostPopularCategory = entryList.get(0).getKey();

        System.out.println("############");
        System.out.println("Sales Report");
        System.out.println("############");
        System.out.println();
        System.out.println("Total sales: £" + totalSales);
        System.out.println("Most popular category: " + mostPopularCategory);

    }
}
