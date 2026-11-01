import java.util.Optional;

public interface ITransactionListRepository {
    Optional<Transaction> searchTransaction(String nameClient);
}
