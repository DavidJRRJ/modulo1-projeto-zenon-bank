import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionMapRepository implements ITransactionListRepository{
    Map<String, Transaction> transactionMap = new HashMap<>();

    public TransactionMapRepository(List<Transaction> transactionList) {
        this.transactionMap = transactionList
                .stream()
                .collect(Collectors.toMap(
                        Transaction::nameOrig,
                        Function.identity()
                        ));
    }

    @Override
    public Optional<Transaction> searchTransaction(String nameClient) {
        return Optional.ofNullable(transactionMap.get(nameClient));
    }
}
