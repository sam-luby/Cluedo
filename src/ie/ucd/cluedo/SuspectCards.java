package ie.ucd.cluedo;

public class SuspectCards extends Cards {
	private String[] suspects = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	public SuspectCards() {}
	
	public String[] getCards() {
		return suspects;
	}
	
	

	//code to test shuffling of cards
	public static void main(String[] args) {
		String[] xyz = new SuspectCards().suspects;
		xyz = shuffleCards(xyz);
		for(int i = 0; i < xyz.length; i++) {
			System.out.println(xyz[i]);
		}
	}

	
	
}
