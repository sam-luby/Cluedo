package ie.ucd.cluedo;

/**
 * Create dice
 * @author Darren
 */
public class Dice {
	
	//Returns a random integer between 2-12 to simulate two dice being thrown.
	public int roll() {
		if(Cluedo.demoMode) {
			return 50;
		} else {
			return (2 + (int)(Math.random() * 11));	
		}
	}
}

