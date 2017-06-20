package guitarshop;

public class ReportEntry {

    private final String category;
    private final int quantity;

    ReportEntry(
            final String category,
            final int quantity) {
        this.category = category;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

}
