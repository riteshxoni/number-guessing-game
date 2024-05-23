import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

// Main class for the Number Guessing Game
public class Number_Guessing_Game {

    public static void main(String args[]) throws InterruptedException {
        System.out.println(
                "################################### Number Guessing Game ###################################");
        System.out.print("Loading");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000); // Pause for 1 second to simulate loading
            System.out.print(".");
        }
        int ch = 0;
        do {
            // Display the main menu
            System.out.println("\n########################### Main Menu ###########################");
            System.out.println("1. > Play");
            System.out.println("2. > Exit");
            System.out.print("Choice : ");
            Scanner sc = new Scanner(System.in);
            try {
                ch = sc.nextInt(); // Read user's choice
                if (ch == 1) {
                    Game g = new Game(); // Create a new game object
                    g.play(); // Start the game
                } else {
                    System.out.println("Thanks for Playing...");
                    return; // Exit the program
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input...\nQuitting....."); // Handle invalid input
            }
        } while (ch != 2); // Continue until user chooses to exit
    }
}

// Class for the game logic
class Game {
    int x, n, count; // Variables to store the random number, user's guess, and count of attempts

    // Constructor to generate a random number
    Game() {
        Random ran = new Random();
        x = ran.nextInt(100) + 1; // Generate a random number between 1 and 100
    }

    // Method to get user's input
    void getdata() {
        Scanner sc = new Scanner(System.in);
        try {
            System.err.print("Guess Number : ");
            n = sc.nextInt(); // Read user's guess
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input..."); // Handle invalid input
            getdata(); // Recursive call to getdata to prompt the user again
        }
    }

    // Method to play the game
    void play() {
        getdata(); // Get the initial guess from the user
        while (true) {
            if (n == x) { // Check if the guess is correct
                System.out.println("You Won... in " + (count + 1) + " attempts..."); // Display success message
                break; // Exit the loop
            } else if (n < x) { // If guess is smaller than the random number
                System.out.println("Think Big.."); // Prompt user to guess a bigger number
                getdata(); // Get the next guess from the user
                count++; // Increment the attempt count
            } else { // If guess is larger than the random number
                System.out.println("Think Small.."); // Prompt user to guess a smaller number
                getdata(); // Get the next guess from the user
                count++; // Increment the attempt count
            }
        }
    }
}