import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		Player player1 = new Player();
		Player player2 = new Player();

		ArrayList<String> data = new ArrayList<String>();

		int count = 1576;
		// String data = "";
		String game;

		System.out.println("Enter data:");

		// Adding game data to list.
		for (int i = 0; i < count; i++) {
			data.add(sc.nextLine());
		}

		System.out.println("Data loaded...");
		Thread.sleep(750);
		System.out.println("Determining winners...");
		Thread.sleep(750);

		for (int i = 0; i < data.size(); i++) {
			// use temporary string array to store the separated sets.
			String[] temp = new String[2];

			game = data.get(i);

			temp = game.split(":");
			
			player1.setTokens(temp[0]);
			player2.setTokens(temp[1]);
			
			player1.checkMatchingColours();
			player2.checkMatchingColours();
			
			if (player1.getPrecedenceValue() > player2.getPrecedenceValue())
				System.out.println("Player 1 wins!");
			else if (player2.getPrecedenceValue() > player1.getPrecedenceValue())
				System.out.println("Player 2 wins!");
			else 
				System.out.println("Go to next rule");
			
			Thread.sleep(450);
			
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(player1.getTokens()[i]);
		}

		/*
		 * Pseudo code
		 * 
		 * if (player1.numOfMathcingColors > player2.numOfMatchingColors) {
		 * player1.outcome = win; binaryString += "0"; } else if (player2 has
		 * more) { player2 wins; } else if (playerHaveSameAmount) {
		 * moveToNextRule(); }
		 * 
		 * 
		 */
	}
}
