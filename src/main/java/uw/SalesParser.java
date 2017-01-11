package uw;

import uw.Model.Product;
import uw.Model.Sale;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class SalesParser {

    // todo review interface


    // time,Item,Category,Quantity,PriceEach
    // 2016-11-18T15:01:00,Fender Telecaster,Guitar,1,699.99

    public List<Sale> sales(String name) {
        try {
            List<String> lines = Files.readAllLines(new File(name).toPath());
            return lines.stream().skip(1).map(line -> convert(line)).collect(Collectors.toList());

        } catch (IOException e) {
            // todo ...
            throw new RuntimeException(e);
        }
    }

    public Sale convert(String line) {
        try {

            final String[] split = line.split(",");
            final String item = split[1].trim();
            final String category = split[2].trim();
            final int quantity = Integer.parseInt(split[3].trim());
            final double price = Double.parseDouble(split[4].trim());

            return new Sale(quantity, price, new Product(item, category));
        } catch (Exception e) {
            throw new RuntimeException("could not convert " + line, e);
        }
    }
}
