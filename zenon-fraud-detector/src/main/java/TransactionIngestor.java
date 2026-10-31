import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {
    private List<Transaction> transactionList = new ArrayList<>();
    private String archive;

    public TransactionIngestor(String archive) {
        this.archive = archive;
    }

    public List<Transaction> readTransactionsArchive() {
        Path path = Paths.get("data", archive);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            int counter = 0;

            while ((line = br.readLine()) != null && counter <= 1000) {
                String[] fields = line.split(",");
                System.out.println("Counter = " + counter);
                if (counter > 0) {
                int step = Integer.parseInt(fields[0].trim());
                Transaction.TypeCategory type = Transaction.TypeCategory.valueOf(fields[1].trim());
                BigDecimal amount = new BigDecimal(fields[2].trim());
                String nameOrig = fields[3].trim();
                BigDecimal oldBalanceOrg = new BigDecimal(fields[4].trim());
                BigDecimal newBalanceOrig = new BigDecimal(fields[5].trim());
                String nameDest = fields[6].trim();
                BigDecimal oldBalanceDest = new BigDecimal(fields[7].trim());
                BigDecimal newBalanceDest = new BigDecimal(fields[8].trim());
                int isFraud = Integer.parseInt(fields[9].trim());
                int isFlaggedFraud = Integer.parseInt(fields[10].trim());

                Transaction newTransaction = new Transaction(step, type, amount, nameOrig, oldBalanceOrg,
                        newBalanceOrig, nameDest, oldBalanceDest,
                        newBalanceDest, isFraud, isFlaggedFraud);
//
                transactionList.add(newTransaction);
                }
                counter += 1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return transactionList;
    }
}
