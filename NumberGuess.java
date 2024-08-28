import java.util.Scanner;

public class NumberGuess {
    
    public static void playGame(int min, int max, int maxAttempts) {
        Scanner scanner = new Scanner(System.in);
        int secretNumber = min + (int) (Math.random() * (max - min + 1));
        int attempts = 0;
        int guess;
        
        System.out.println("A number has been chosen between " + min + " and " + max + ".");
        System.out.println("Your task is to guess the number within " + maxAttempts + " attempts.");
        
        while (attempts < maxAttempts) {
            System.out.println("Attempt " + (attempts + 1) + ": Enter your guess:");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number:");
                scanner.next();
            }
            guess = scanner.nextInt();
            attempts++;
            
            if (secretNumber == guess) {
                System.out.println("Congratulations! You've guessed the correct number.");
                break;
            } else if (secretNumber > guess && attempts != maxAttempts) {
                System.out.println("The secret number is greater than your guess.");
            } else if (secretNumber < guess && attempts != maxAttempts) {
                System.out.println("The secret number is less than your guess.");
            }
        }
        
        if (attempts == maxAttempts) {
            System.out.println("You have exhausted all " + maxAttempts + " attempts.");
            System.out.println("The secret number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Choose a difficulty level:");
            System.out.println("1. Easy (Range: 1-50, Attempts: 10)");
            System.out.println("2. Medium (Range: 1-100, Attempts: 7)");
            System.out.println("3. Hard (Range: 1-200, Attempts: 5)");
            int difficulty = scanner.nextInt();

            int min = 1, max = 50, maxAttempts = 10;

            switch (difficulty) {
                case 1:
                    max = 50;
                    maxAttempts = 10;
                    break;
                case 2:
                    max = 100;
                    maxAttempts = 7;
                    break;
                case 3:
                    max = 200;
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Easy level.");
                    break;
            }

            playGame(min, max, maxAttempts);

            System.out.println("Would you like to play again? (yes/no)");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}