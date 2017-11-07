package ie.ucd.cluedo;

/**
 * Create dice
 * @author Darren
 */
public class Dice {

	private int faceValue;

	public void roll() {
		faceValue = 1 + (int) (Math.random() * 6.0);
	}

	public int value() {
		return faceValue;
	}

	public Dice() {
		roll();
	}
	
	// Main method to test the above Dice class code
	public static void main(String[] args) {
		Dice diceys = new Dice();
		System.out.println(diceys.value());
		diceys.roll();
		System.out.println(diceys.value());
	}

}

