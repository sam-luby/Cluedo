package ie.ucd.cluedo;

public class SuspectCards extends Cards {
	private static String[] names = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	public SuspectCards() {
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
