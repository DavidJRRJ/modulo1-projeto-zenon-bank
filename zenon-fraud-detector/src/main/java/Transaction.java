import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.function.Function;

public record Transaction(int step, TypeCategory type, BigDecimal amount,
                          String nameOrig, BigDecimal oldBalanceOrg,
                          BigDecimal newBalanceOrig, String nameDest,
                          BigDecimal oldBalanceDest, BigDecimal newBalanceDest,
                          boolean isFraud, boolean isFlaggedFraud) {


    public Transaction {
        if (step < 1) {
            throw new IllegalArgumentException("step should be positive: " + step);
        }
        if (!EnumSet.allOf(TypeCategory.class).contains(type)) {
            throw new IllegalArgumentException("this type doesn't exist: " + type);
        }
        if (amount == null) {
            throw new IllegalArgumentException("amount should not be null");
        }
        if (amount.signum() < 0) {
            throw new IllegalArgumentException("amount should be positive: " + amount);
        }
        if (nameOrig == null || nameOrig.isEmpty()) {
            throw new IllegalArgumentException("name should not be empty");
        }
        if (oldBalanceOrg == null) {
            throw new IllegalArgumentException("oldBalance should not be null");
        }
        if (oldBalanceOrg.signum() < 0) {
            throw new IllegalArgumentException("oldBalance should be positive: " + oldBalanceOrg);
        }
        if (newBalanceOrig == null) {
            throw new IllegalArgumentException("newBalance should not be null");
        }
        if (newBalanceOrig.signum() < 0) {
            throw new IllegalArgumentException("newBalance should be positive: " + newBalanceOrig);
        }
        if (nameDest == null || nameDest.isEmpty()) {
            throw new IllegalArgumentException("name should not be empty");
        }
        if (oldBalanceDest == null) {
            throw new IllegalArgumentException("oldBalance should not be null");
        }
        if (oldBalanceDest.signum() < 0) {
            throw new IllegalArgumentException("oldBalance should be positive: " + oldBalanceDest);
        }
        if (newBalanceDest == null) {
            throw new IllegalArgumentException("newBalance should not be null");
        }
        if (newBalanceDest.signum() < 0) {
            throw new IllegalArgumentException("newBalance should be positive: " + newBalanceDest);
        }
    }

    public enum TypeCategory {
        CASH_IN, CASH_OUT, DEBIT, PAYMENT, TRANSFER
    }
}