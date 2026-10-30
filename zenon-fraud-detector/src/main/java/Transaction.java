import java.math.BigDecimal;

public record Transaction(int step, TypeCategory type, BigDecimal amount,
                          String nameOrig, BigDecimal oldBalanceOrg,
                          BigDecimal newBalanceOrig, String nameDest,
                          BigDecimal oldBalanceDest, BigDecimal newBalanceDest,
                          int isFraud, int isFlaggedFraud) {


    public enum TypeCategory {
        CASH_IN, CASH_OUT, DEBIT, PAYMENT, TRANSFER
    }
}
