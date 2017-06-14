package guitarshop;

import com.csvreader.CsvReader;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class GuitarSalesReporter {

    private int totalSales = 0;

    protected void addToTotalSales(final int quantity, final double price) {
        totalSales += (quantity * price);
    }

    protected static List<String> readCsv(String filePath) {

        //final StringBuilder csvData = new StringBuilder();
        final List<String> csvData = new ArrayList<String>();

        try {
            final CsvReader csvFile = new CsvReader(filePath);

            while (csvFile.readRecord()) {
                csvData.add(csvFile.getRawRecord());

                int quantity = Integer.parseInt(cells[3]);
                double price = Double.parseDouble(cells[4]);
                totalSales += (quantity * price);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        //return csvData.toString();
        return csvData;
    }

    /**
     * For a given CSV file (path) generate a Sale Report.
     * @param fileName
     * @return
     */
    protected static String generateSalesReport(final String fileName) {

        // List<String> lines = Files.readAllLines(csvFile.toPath());
        List<String> lines = readCsv(fileName);

        int quantity = Integer.parseInt(cells[3]);
        double price = Double.parseDouble(cells[4]);
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

        final StringBuilder salesReport = new StringBuilder();
        salesReport.append("############\n");
        salesReport.append("Sales Report\n");
        salesReport.append("############\n");
        salesReport.append("\n");
        salesReport.append("Total sales: £" + totalSales + "\n");
        salesReport.append("Most popular category: " + mostPopularCategory);

        return salesReport.toString();
    }

    public static void main(String[] args) throws Exception {
        File csvFile = new File("src/main/resources/sales.csv");

        System.out.println(generateSalesReport(csvFile.toPath().toString()));
    }
}
