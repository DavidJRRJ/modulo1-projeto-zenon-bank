import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionListRepository implements ITransactionListRepository {
    List<Transaction> transactionList = new ArrayList<>();

    public TransactionListRepository(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public Optional<Transaction> searchTransaction(String nameClient) {
        return transactionList
                .stream()
                .filter(tr -> tr.nameOrig().equals(nameClient))
                .findFirst();
    }
}
