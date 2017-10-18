package ie.ucd.cluedo;

public class SuspectCards extends Cards {
	private static String[] names = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	public SuspectCards() {}
	

	//code to test shuffling of cards
	public static void main(String[] args) {
		String[] xyz = new SuspectCards().names;
		xyz = shuffleCards(xyz);
		for(int i = 0; i < names.length; i++) {
			System.out.println(xyz[i]);
		}
	}
	
}
