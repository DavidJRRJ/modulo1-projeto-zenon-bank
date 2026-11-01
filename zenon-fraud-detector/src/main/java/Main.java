void main() {

    var tr = new TransactionIngestor("PS_20174392719_1491204439457_log.csv");
    ITransactionListRepository transactionListRepository = new TransactionListRepository(tr.readTransactionsArchive());

    String clientId = "C1231006815";
    String clientNotExist = "C12345";

    long startTime = System.nanoTime();
    transactionListRepository.searchTransaction(clientId)
            .ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Transação não encontrada para o cliente " + clientId)
            );
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time search = " + duration);

    long startTime1 = System.nanoTime();
    transactionListRepository.searchTransaction(clientNotExist)
            .ifPresentOrElse(
                    System.out::println,
                    () -> System.out.println("Transação não encontrada para o cliente " + clientNotExist)
            );
    long endTime1 = System.nanoTime();
    long duration1 = endTime1 - startTime1;
    System.out.println("Time search = " + duration1);
}
