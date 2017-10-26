package ie.ucd.cluedo;

import java.util.Random;

public enum SuspectCards {
	MISSSCARLET("Miss Scarlet"),
	PROFESSORPLUM("Professor Plum"),
	MRSPEACOCK("Mrs. Peacock"),
	REVERENDMRGREEN("Reverend Mr. Green"),
	COLONOLMUSTARD("Colonel Mustard"),
	MRSWHITE("Mrs. White");
	
	private final String name;
	
	SuspectCards(String n){
		this.name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public static SuspectCards random() {
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
}
