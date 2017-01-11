package guitarshop;

import java.util.Date;

public class Transaction {
    private Double amount;
    private Date happenedAt;
    private String productType;
    private String brand;
    private Integer quantity;

    public Transaction(Double amount, String productType, String brand, Integer quantity) {
        this.amount = amount;
        this.productType = productType;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public Date happenedAt() {
        return happenedAt;
    }

    public String getProductType() {
        return productType;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
