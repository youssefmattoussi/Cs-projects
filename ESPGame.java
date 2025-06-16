/*
 * Class: CMSC203 CRN 40438
 * Instructor: Professor: Grigoriy Grinberg
 * Description: for this assignment we created a game which is guessing a color from 16 colors that are in a file if the user guessed correctly he won if he did not guessed correctly he loose. 
 * Due: 06/16/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Youssef Mattoussi
*/
package esp;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class ESPGame {

	public static void main(String[] args) throws IOException {
		final String FILE_NAME = "colors.txt";
		final Random randomNumbers = new Random();
		final int TOTAL_ROUNDS = 3;
		final String RESULTS_FILE = "EspGameResults.txt";
		final Scanner keyboard = new Scanner(System.in);
		int correctGuess = 0;
		boolean playAgain = true;
		while (playAgain) {
			System.out.println("CMSC203 Assignment1: Test your ESP skills!");
			System.out.println("Welcome to ESP - extrasensory perception!");
			System.out.println("Would you please choose one of the 4 options from the menu:");
			System.out.println("1-	read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.");
			System.out.println("2-	read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.");
			System.out.println("3-	read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.");
			System.out.println("4-	Exit form a program");
			int choice = 0;
				while (choice < 1 || choice > 4) {
					System.out.print("Enter a number in the range " + "of 1 through 4: ");
					choice = keyboard.nextInt();
					keyboard.nextLine();
				}
			int numberOfColors = 0;
			if (choice == 1) {
				numberOfColors = 16;
			}
			else if (choice == 2) {
				numberOfColors = 10;
			}
			else if (choice == 3) {
				numberOfColors = 5;
			}
			else if (choice == 4) {
				return;
			}
			File colorFile = new File("colors.txt");
			Scanner fileScanner = new Scanner(colorFile);
			int count = 0;
			while ( count < numberOfColors) {
				String color = fileScanner.nextLine();
				System.out.println((count + 1) + ". " + color);
				count++;
			}
			fileScanner.close();
			for ( int round = 1; round <= 3; round++) 
			{
				System.out.println("\nRound " + round);
				System.out.println("I am thinking of a color.");
				System.out.println("Is it one of the colors listed above?");
				System.out.print("Enter your guess: ");
				String userGuess = keyboard.nextLine();
				File colorFile1 = new File("colors.txt");
				Scanner fileScanner1 = new Scanner(colorFile1);
				int randomLine = randomNumbers.nextInt(numberOfColors) +1;
				int currentLine = 1;
				String selectedColor = "";
				while (fileScanner1.hasNextLine()) {
					String color = fileScanner1.nextLine();
					if (currentLine == randomLine) {
						selectedColor = color;
						break;
					}
					currentLine++;
				}
				fileScanner1.close();
				System.out.println("I was thinking of " + selectedColor + ".");
				if (userGuess.equals(selectedColor)) {
					correctGuess++;
				}
			}
			System.out.println("You guessed " + correctGuess + " out of 3 colors correctly.");
			System.out.print("Would you like to play again? (Yes/No): ");
			String response = keyboard.nextLine();
			if (response.equals("Yes")) {
					playAgain = true;
			} else {
					playAgain = false;
			}
		}
		System.out.print("Enter your name: ");
		String userName = keyboard.nextLine();
		System.out.print("Describe yourself: ");
		String userDescription = keyboard.nextLine();
		System.out.println("Due Date: 06/16");
		System.out.println("Enter your name: Youssef Mattoussi");
		System.out.println("User Description: I am a CMSC student with a major in Computer Science");
		System.out.println("Due Date: 06/16");
		PrintWriter outputFile1 = new PrintWriter("EspGameResults.txt");
		outputFile1.println("Game Over");
		outputFile1.println("You guessed " + correctGuess + " out of 3 colors correctly.");
		outputFile1.println("Due Date: 06/16");
		outputFile1.println("Enter your name: Youssef Mattoussi");
		outputFile1.println("User Description: I am a CMSC student with a major in Computer Science");
		outputFile1.println("Date: 06/16");
		outputFile1.close();
	}
}