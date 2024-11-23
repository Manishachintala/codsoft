import java.util.Scanner;

public class ATMInterface{
    private static Scanner in;
    private static float balance = 1000;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        
        transaction();
    }

    private static void transaction() {
        int choice;

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    float withdrawAmount;
                    System.out.println("Please enter the amount to withdraw:");
                    withdrawAmount = in.nextFloat();

                    if (withdrawAmount > balance || withdrawAmount <= 0) {
                        System.out.println("Insufficient funds or invalid amount. Try again.\n");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("You have withdrawn " + withdrawAmount + ". Your new balance is " + balance + ".\n");
                    }
                    break;

                case 2:
                    float depositAmount;
                    System.out.println("Please enter the amount to deposit:");
                    depositAmount = in.nextFloat();

                    if (depositAmount <= 0) {
                        System.out.println("Invalid deposit amount. Try again.\n");
                    } else {
                        balance += depositAmount;
                        System.out.println("You have deposited " + depositAmount + ". Your new balance is " + balance + ".\n");
                    }
                    break;

                case 3:
                    System.out.println("Your current balance is " + balance + ".\n");
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;  // Exit the program

                default:
                    System.out.println("Invalid option. Please select a valid option.\n");
                    break;
            }
        }
    }
}
