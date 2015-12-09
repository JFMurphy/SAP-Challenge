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
		int line = 1;
		String game; /* A single game between two players */
		String binaryString = "";
		String message = "";

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
			
			player1.checkProductOfTokens();
			player2.checkProductOfTokens();
			
			player1.checkBestTokenValue();
			player2.checkBestTokenValue();
			
			
			if (player1.getPrecedenceValue() > player2.getPrecedenceValue()) {
				System.out.print("0");
				binaryString += "0";
			} else if (player2.getPrecedenceValue() > player1.getPrecedenceValue()) {
				System.out.print("1");
				binaryString += "1";
			} else if (player1.getProductOfTokens() > player2.getProductOfTokens()) {
				System.out.print("0");
				binaryString += "0";
			} else if (player2.getProductOfTokens() > player1.getProductOfTokens()) {
				System.out.print("1");
				binaryString += "1";
			} else if (player1.getBestTokenValue() > player2.getBestTokenValue()) {
				System.out.print("0");
				binaryString += "0";
			} else if (player2.getBestTokenValue() > player1.getBestTokenValue()) {
				System.out.print("1");
				binaryString += "1";
			} else
				System.out.println("I... what... uh... this is impossible! " + line);
			
			if (line == 8) {
				int charCode = Integer.parseInt(binaryString, 2);
				String str = new Character((char)charCode).toString();
				message += str;
				System.out.println("");
				line = 0;
				binaryString = "";
			}		
			line++;
		}
		
		System.out.println(message);
	}
}
