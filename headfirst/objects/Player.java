/**
 * A player of the Guess game.
 */
public class Player {
    int number = 0;

    /**
     * Guesses a random number from 0 to 9.
     */
    public void guess() {
        number = (int) (Math.random() * 10);
        System.out.println("I'm guessing " + number);
    }
}
