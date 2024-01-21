import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;

        // Initialize variables
        int guess;
        int attempts = 0;

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            // Check if the guess is correct
            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (guess < targetNumber) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }

        } while (guess != targetNumber);

        // Close the scanner
        scanner.close();
    }
}
