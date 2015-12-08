
public class Player {

	public static final double RED_WEIGHT = 0.25;
	public static final double GREEN_WEIGHT = 0.5;
	public static final double BLUE_WEIGHT = 0.75;
	public static final double YELLOW_WEIGHT = 1.0;

	private int precedenceValue;
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
		boolean noMatchingColours = false;

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

}
