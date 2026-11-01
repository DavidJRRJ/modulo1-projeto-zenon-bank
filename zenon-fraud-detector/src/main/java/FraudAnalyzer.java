import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FraudAnalyzer {
    public static final DecimalFormat DF = new DecimalFormat("0.00");
    private List<Transaction> transactionList = new ArrayList<>();

    public FraudAnalyzer(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void totalFraudsNumber() {
        int totalFrauds = transactionList
                            .stream()
                            .filter(Transaction::isFraud)
                            .toList()
                            .size();
        System.out.println("1. Total de Fraudes: " + totalFrauds);
    }

    public void topThreeFrauds() {
        List<Transaction> topThreeFrauds = transactionList
                                            .stream()
                                            .sorted(Comparator.comparing(Transaction::amount).reversed())
                                            .limit(3)
                                            .toList();
        System.out.println("2. Top 3 Fraudes de Maior Valor:");
        topThreeFrauds.forEach( transaction -> System.out.println(DF.format(transaction.amount())));
    }

    public void suspectClientsList() {
        Set<Transaction> suspectClients = transactionList
                                            .stream()
                                            .filter(Transaction::isFraud)
                                            .sorted(Comparator.comparing(Transaction::amount).reversed())
                                            .limit(5)
                                            .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("3. Clientes Suspeitos:");
        suspectClients.forEach( transaction -> System.out.println(transaction.nameOrig()));
    }

    public void totalLoss() {
        BigDecimal total = transactionList
                            .stream()
                            .filter(Transaction::isFraud)
                            .map(Transaction::amount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("4. Prejuizo Total: " + DF.format(total));
    }

    public void fraudTypesList() {
        Map<Transaction.TypeCategory, Long> fraudTypes = transactionList
                                                            .stream()
                                                            .filter(Transaction::isFraud)
                                                            .collect(Collectors.groupingBy(
                                                                    Transaction::type,
                                                                    Collectors.counting()
                                                            ));
        System.out.println("5. Fraudes por Tipo:");
        fraudTypes.forEach((type, qtd) -> {
            System.out.println(" - " + type + ": " + qtd);
        });
    }
}
