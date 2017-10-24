package ie.ucd.cluedo;

public class SuspectCards extends Cards {
	private static String[] suspects = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	public SuspectCards() {}
	
	public static String[] getCards() {
		return suspects;
	}
	
	public static String random() {
		String randomSuspect = suspects[(int)(Math.random() * suspects.length)];
		return randomSuspect;
	}
	

	//code to test shuffling of cards
	public static void main(String[] args) {
		new SuspectCards();
		String[] xyz = SuspectCards.suspects;
		xyz = shuffleCards(xyz);
		for(int i = 0; i < xyz.length; i++) {
			System.out.println(xyz[i]);
		}
	}

	
	
}
