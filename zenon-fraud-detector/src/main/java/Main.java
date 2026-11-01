void main() {

    var tr = new TransactionIngestor("PS_20174392719_1491204439457_log.csv");
    var listTransactions = tr.readTransactionsArchive();
    var fraudAnalyzer = new FraudAnalyzer(listTransactions);

    fraudAnalyzer.totalFraudsNumber();
    fraudAnalyzer.topThreeFrauds();
    fraudAnalyzer.suspectClientsList();
    fraudAnalyzer.totalLoss();
    fraudAnalyzer.fraudTypesList();
}
