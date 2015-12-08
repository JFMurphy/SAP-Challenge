
public class Player {

	public static final int RED_WEIGHT = 0;
	public static final int GREEN_WEIGHT = 16;
	public static final int BLUE_WEIGHT = 32;
	public static final int YELLOW_WEIGHT = 48;

	private int precedenceValue;
	private int productOfTokens;
	private int bestTokenValue;
	private int tokenValue;
	private String[] tokens = new String[4];

	public void checkMatchingColours() {
		precedenceValue = 0;

		int redCount = 0;
		int greenCount = 0;
		int blueCount = 0;
		int yellowCount = 0;
		int max = 0;
		boolean twoMatchingPairs = false;

		for (int i = 0; i < tokens.length; i++) {

			switch (tokens[i].charAt(0)) {

			case 'r':
				redCount++;
				break;

			case 'g':
				greenCount++;
				break;

			case 'b':
				blueCount++;
				break;

			case 'y':
				yellowCount++;
				break;

			}
		}

		int[] colourCounts = { redCount, greenCount, blueCount, yellowCount };

		for (int i = 0; i < colourCounts.length; i++) {
			for (int j = i + 1; j < colourCounts.length; j++) {
				if (colourCounts[i] == 2 && colourCounts[j] == 2) {
					twoMatchingPairs = true;
				}
			}

			if (colourCounts[i] > max)
				max = colourCounts[i];

		}

		if (twoMatchingPairs) {
			precedenceValue = 3;
		} else if (max >= 3) {
			/*
			 * Add one to max to account for a matching pair needing a
			 * precedence value of 3
			 */
			precedenceValue = max + 1;
		} else {
			precedenceValue = max;
		}
	}

	public void checkProductOfTokens() {
		productOfTokens = 0;

		for (int i = 0; i < tokens.length; i++) {
			int number = Integer.parseInt(tokens[i].substring(1));

			if (productOfTokens != 0)
				productOfTokens *= number;
			else
				productOfTokens = number;
		}

	}

	public void checkBestTokenValue() {
		bestTokenValue = 0;
		char colour;
		int number;
		int tokenValue = 0;

		for (int i = 0; i < tokens.length; i++) {
			colour = tokens[i].charAt(0);
			number = Integer.parseInt(tokens[i].substring(1));

			switch (colour) {

			case 'r':
				tokenValue = RED_WEIGHT + number;
				break;

			case 'g':
				tokenValue = GREEN_WEIGHT + number;
				break;

			case 'b':
				tokenValue = BLUE_WEIGHT + number;
				break;

			case 'y':
				tokenValue = YELLOW_WEIGHT + number;
				break;

			}

			if (tokenValue > bestTokenValue)
				bestTokenValue = (int) tokenValue;

		}

	}

	public int getNumMatchingColors() {
		return precedenceValue;
	}

	public void setNumMatchingColors(int numMatchingColors) {
		this.precedenceValue = numMatchingColors;
	}

	public int getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(int tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String[] getTokens() {
		return tokens;
	}

	public void setTokens(String set) {
		this.tokens = set.split(" ");
	}

	public int getPrecedenceValue() {
		return precedenceValue;
	}

	public int getProductOfTokens() {
		return productOfTokens;
	}

	public int getBestTokenValue() {
		return bestTokenValue;
	}

}
