import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemoTest {

    public static void main(String[] args) {

        CheckingAccount account1 = new CheckingAccount("John");

        boolean flag = false;

        Scanner reader = new Scanner(System.in);

        do {
            try {
                flag = false;
                System.out.println("Enter deposit amount: ");
                BigDecimal depositValue = reader.nextBigDecimal();
                account1.deposit(depositValue);

            } catch (InputMismatchException e) {
                reader.next();
                flag = true;
                System.out.println("Invalid deposit input! Please key in a valid number. ");
                // e.printStackTrace();
            }
        } while (flag == true);

        do {
            try {
                flag = false;
                System.out.println("Enter withdraw amount: ");
                BigDecimal withdrawValue = reader.nextBigDecimal();
                account1.withdraw(withdrawValue);
                System.out.println("The balance after withdraw is: " + account1.getBalance());

            } catch (InsufficientFundsException e) {
                System.out.println("Sorry, but your account is short by: " + e.getAmount());
            } catch (InputMismatchException e) {
                reader.next();
                flag = true;
                System.out.println("Invalid withdrawal input! Please key in a valid number. ");
                // e.printStackTrace();
            }
        } while (flag == true);

        reader.close();
    }
}
