public class SimpleDotComGame {
	public static void main(String[] args) {
		int numOfGuesses = 0;
		SimpleDotCom game = new SimpleDotCom();
		GameHelper helper = new GameHelper();
		int cell = (int) (Math.random() * 5);
		int[] locations = {cell, cell+1, cell+2};
		game.setLocationCells(locations);
		String guess, result = "miss";
		do {
			guess = helper.getUserInput("Enter a number");
			result = game.checkYourself(guess);
			numOfGuesses++;
		} while(!result.equals("kill"));
		System.out.println("You took " + numOfGuesses + " guesses");
	}
}
