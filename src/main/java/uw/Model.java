package uw;

import java.util.List;

public class Model {

    // todo equals/hashcode


    public static class Product {
        private final String item;
        private final String category;

        public Product(String item, String category) {
            this.item = item;
            this.category = category;
        }
    }

    public static class Sale {
        // todo timestamp
        private final int quantity;
        // per item
        private final double price;
        private final Product product;

        public Sale(int quantity, double price, Product product) {
            this.quantity = quantity;
            this.price = price;
            this.product = product;
        }
    }

    // report here or in specific reporter
    public static class BaseReport {
        private final List<Sale> sales;

        private final double total;
        private final Product bestSeller;

        public BaseReport(List<Sale> sales) {
            this.sales = sales;
            this.total = total(sales);
            this.bestSeller = bestSeller(sales);
        }

        public static Product bestSeller(List<Sale> sales) {
            return null;
        }

        public static double total(List<Sale> sales) {
            return 0;
        }
    }


}
