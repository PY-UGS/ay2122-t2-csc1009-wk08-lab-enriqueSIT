import java.math.BigDecimal;
import java.util.UUID;

public class CheckingAccount {

    private String accountHolder;

    public String getAccountHolder() {
        return accountHolder;
    }

    private final String accountNumber;

    public String getNumber() {
        return accountNumber;
    }

    private final int accountPIN;

    public int getPIN() {
        return accountPIN;
    }

    BigDecimal balance;

    public double getBalance() {
        return balance.doubleValue();
    }

    // the default balance in an account- this is an arbitary value purely for
    // testing.
    private final static int INITIAL_TOTAL = 0;

    // For testing- we need to get user input and pass it as an argument.
    public CheckingAccount(String accountHolder) {
        this.accountHolder = accountHolder;

        accountNumber = UUID.randomUUID().toString();
        // For testing, for setting up an actual account, get user input
        accountPIN = RandHelpers.RandomIntInRange(10000, 999999);

        balance = new BigDecimal(INITIAL_TOTAL);
    }

    public void deposit(BigDecimal value) throws NumberFormatException {
        if (value.compareTo(BigDecimal.ZERO) <= 0)
            throw new NumberFormatException("Value must be positive!");
        balance = balance.add(value);
    }

    public void withdraw(BigDecimal value) throws InsufficientFundsException {
        if (value.compareTo(balance) == 1)
            throw new InsufficientFundsException(value.subtract(balance).doubleValue());
        balance = balance.subtract(value);
    }

    // // Huh.
    // public <T extends Number> void deposit(T value) {
    // balance.add(new BigDecimal((Double) value));
    // }

    // public <T extends Number> void withdraw(T value) {
    // balance.subtract(new BigDecimal((Double) value));
    // }

    // determines whether a user-specified PIN matches PIN in Account
    public boolean validatePIN(int userPIN) {
        if (userPIN == getPIN())
            return true;
        else
            return false;
    }

}