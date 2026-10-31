void main() {

    var tr = new TransactionIngestor("paysim_with_bad_data.csv");
    var tenTransactions = tr.readTransactionsArchive()
            .stream()
            .toList();

    tenTransactions.forEach(System.out::println);
}
