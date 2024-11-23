import java.util.Scanner;

class Rangen {
    // Method to generate random number between min and max (inclusive)
    public int generate(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rangen rg = new Rangen();
        int totalAttempts = 0;
        int win = 0;

        while (true) {
            // Prompt user for max and min values
            System.out.println("Enter the maximum number:");
            int max = sc.nextInt();
            System.out.println("Enter the minimum number:");
            int min = sc.nextInt();
            sc.nextLine(); // consume the leftover newline character

            // Generate a random number between min and max
            int cnum = rg.generate(max, min);
            int attempts = 0;

            while (true) {
                // Prompt user to guess
                System.out.println("Guess a number between " + min + " and " + max + ":");
                int gnum = sc.nextInt();
                attempts++;

                // Check the user's guess
                if (gnum > cnum) {
                    System.out.println("It's lower!");
                } else if (gnum < cnum) {
                    System.out.println("It's higher!");
                } else {
                    System.out.println("Correct Guess!");
                    win++;
                    break; // Exit the loop when the user guesses correctly
                }
            }

            // Update total attempts and display win count
            totalAttempts += attempts;
            System.out.println("Attempts this round: " + attempts);
            System.out.println("Wins so far: " + win);

            // Calculate and display the win rate
            double winRate = (double) win / totalAttempts * 100;
            System.out.printf("Your winrate is %.2f%%\n", winRate);

            // Ask the user if they want to play again
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                sc.close();
                System.exit(0);
            }
        }
    }
}
