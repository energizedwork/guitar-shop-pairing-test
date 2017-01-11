package guitarshop;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class SalesParser {
    public List<Transaction> parse(List<String> lines) {

        Transaction transaction = parse(lines.get(0));

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        return transactions;
    }

    public Transaction parse(String line) throws InvalidLineException {
        if(line == null || line.trim().isEmpty()) {
            throw new InvalidLineException(line);
        }


        String[] fields = line.split(",");

        String brand = fields[1];
        String productType = fields[2];
        Integer quantity = Integer.parseInt(fields[3]);
        Double amount = Double.parseDouble(fields[4]);

        Transaction transaction = new Transaction(amount, productType, brand, quantity);


        return transaction;
    }
}
