
public class Token {
	
	public static final int RED = 0;
	public static final int GREEN = 1;
	public static final int BLUE = 2;
	public static final int YELLOW = 3;
	
	private int colour = 0;
	private int number = 0;
	
	public Token(int color, int number) {
		this.colour = color;
		if (number > 16)
			System.out.println("Token number cannot be more than 16");
		else
			this.number = number;
	}

}
