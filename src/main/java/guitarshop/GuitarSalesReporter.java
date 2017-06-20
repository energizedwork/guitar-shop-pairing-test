package guitarshop;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class GuitarSalesReporter {

    private final MostPopularCategoryCalculator mostPopularCategoryCalculator;
    private final CategoryParser categoryParser;

    public GuitarSalesReporter() {
        this(new MostPopularCategoryCalculator(), new CategoryParser());
    }

    public GuitarSalesReporter(
            final MostPopularCategoryCalculator mostPopularCategoryCalculator,
            final CategoryParser categoryParser) {
        this.mostPopularCategoryCalculator = mostPopularCategoryCalculator;
        this.categoryParser = categoryParser;
    }

    public static void main(String[] args) throws Exception {
        final String report = new GuitarSalesReporter().prepareReport();
        System.out.println(report);
    }

    public String prepareReport() throws Exception {

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

        final Map<String,Integer> categories = categoryParser.countVolumesByCategory(lines);
        final String mostPopularCategory = mostPopularCategoryCalculator.calculate(categories);

        final StringBuilder output = new StringBuilder();
        output.append("############");
        output.append(System.lineSeparator());
        output.append("Sales Report");
        output.append(System.lineSeparator());
        output.append("############");
        output.append(System.lineSeparator());
        output.append(System.lineSeparator());
        output.append("Total sales: £" + totalSales);
        output.append(System.lineSeparator());
        output.append("Most popular category: " + mostPopularCategory);
        output.append(System.lineSeparator());

        return output.toString();
    }
    
}
