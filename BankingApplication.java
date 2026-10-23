import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 5000.00; // Opening balance

        while (true) {
            System.out.println("\n===== Banking Application =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: Rs. " + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");

                    try {
                        double deposit = Double.parseDouble(sc.nextLine().trim());

                        if (deposit > 0) {
                            balance += deposit;
                            System.out.println("Money deposited successfully!");
                            System.out.println("Updated Balance: Rs. " + balance);
                        } else {
                            System.out.println("Amount must be greater than zero.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");

                    try {
                        double withdraw = Double.parseDouble(sc.nextLine().trim());

                        if (withdraw <= 0) {
                            System.out.println("Amount must be greater than zero.");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            balance -= withdraw;
                            System.out.println("Withdrawal successful!");
                            System.out.println("Updated Balance: Rs. " + balance);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our Banking Application!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }
        }
    }
}
