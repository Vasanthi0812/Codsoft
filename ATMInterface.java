import java.util.Scanner;

public class ATMInterface {

    private static double accountBalance = 1000.0; // Initial account balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Current Balance: $" + accountBalance);
    }

    private static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to withdraw: $");
        double amountToWithdraw = scanner.nextDouble();

        if (amountToWithdraw > 0 && amountToWithdraw <= accountBalance) {
            accountBalance -= amountToWithdraw;
            System.out.println("Transaction successful. Remaining Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid amount or insufficient funds. Please try again.");
        }
    }
}
