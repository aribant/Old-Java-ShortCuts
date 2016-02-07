import java.util.Scanner;

public class DoWhileLoopWithContinueViaRegularExpression {
	public static String input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Begin Do While Loop
		do {

			// Enter program here

			// Continue program option
			// ||
			// \/

			System.out.println("\n\n\n Would you like to play again?");
			System.out.println("\n Y --OR-- N\n\n");

			input = sc.next();
			while (!input.matches("^[yYnN]$")) {
				System.out.println("try again");
				input = sc.next();
			} // end while
		} while (input.equalsIgnoreCase("y"));

		// End Do While loop

		sc.close();
	}// End main
}// End class