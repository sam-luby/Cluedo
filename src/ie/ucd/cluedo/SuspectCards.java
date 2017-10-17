package ie.ucd.cluedo;

public class SuspectCards extends Cards {

	private static String[] suspects = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	
	public SuspectCards() {
		String[] names = suspects;
	}
	
	
	public static void main(String[] args) {
		SuspectCards s = new SuspectCards();
		String[] x = s.suspects;
		
		for(int i=0; i < x.length; i++) {
			System.out.println(suspects[i]);
		}
	}
}
