import java.util.InputMismatchException;
import java.util.Scanner;

/*USE 

The app asks the user to enter the number of sides for a pair of dice
prompts the user to roll the dice.
App rolls the 2 n-sided dice, displays the results of each, and then
asks the user if they want to roll the dice again.

BUILD SPEC

Use  static methods to implement the methods that generate the random number.
Try different random number generators.

HINTS

Use math random
Murach's Java Chapter 4

CHALLENGE

Display special messages for craps, snake eyes, and box cars.

*/

public class GameStateExample {

	public static Scanner sc = new Scanner(System.in);

	public static int sidesOfDice;
	public static int drinkCounter = 0;

	public static String input;
	public static String state;

	public static boolean q = false;

	public static void main(String[] args) {

		state1();

		do {
			state2();
			switch (input) {

			case "play":
				// choose dice number of sides
				play();
				break;
			case "drink":
				System.out.println(" + Martini \n");
				drinkCounter++;
				if(drinkCounter == 2){
					System.out.println(" +Buzz \n");
				}
					
				break;
			case "q":
				System.out.println(" GOODBYE!");
				q = true;
				break;
			default:
				break;
			}
			// if(q == false)
			// state2();
		} while (q == false);

		sc.close();

	} // End of main

	public static void state1() {
		System.out.println("      =============================================================");
		System.out.println("   ===================================================================");
		System.out.println(" ================= Welcome to the Grand Circus Casino! ==================");
		System.out.println("   ===================================================================");
		System.out.println("      =============================================================\n\n");

		System.out.println(" Would you like to play a Dice game? ");
	}

	public static void state2() {
		System.out.println(" What would you like to do?\n");
		System.out.println(" Roll Dice \t Get a drink \t Quit \n");
		System.out.println("  (play) \t   (drink) \t  (q) \n");

		input = sc.nextLine();
	}

	public static void play() {
		System.out.println("\n How many sides should the Dice have?");
		System.out.print(" Enter 6 - 20: ");
		try {
			sidesOfDice = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			state2();
		}

		System.out.println("\n **SHAKE**");
		System.out.println(" **SHAKE**");
		System.out.println(" **TOSS** \n");

		int diceOne = (int) (Math.random() * sidesOfDice + 1);
		int diceTwo = (int) (Math.random() * sidesOfDice + 1);

		System.out.println(" Die one: " + diceOne);
		System.out.println(" Die two: " + diceTwo + "\n");
		if(diceOne == 1 && diceTwo == 1){
			System.out.println(" SNAKE EYES! \n");
		}
		if(diceOne + diceTwo == 7 || diceOne + diceTwo == 11){
			System.out.println(" CRAPS! \n");
		}
		if(diceOne + diceTwo == 12){
			System.out.println(" BOXCARS! \n");
		}

	}

	public static void yesOrNo(Scanner sc) {
		do {
			System.out.println("\n Y --OR-- N\n");

			input = sc.next();
			while (!input.matches("^[yYnN]$")) {
				System.out.println("try again");
				input = sc.next();
			} // end while

		} while (input.equalsIgnoreCase("y"));
		System.out.println(" GOODBYE!");
		// End Do While loop
	}

} // End of class
