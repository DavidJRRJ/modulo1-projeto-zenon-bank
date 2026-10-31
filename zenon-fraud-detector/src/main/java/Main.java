void main() {

    var tr = new TransactionIngestor("PS_20174392719_1491204439457_log.csv");
    var tenTransactions = tr.readTransactionsArchive()
            .stream().
            limit(10)
            .toList();

    tenTransactions.forEach(System.out::println);
}
