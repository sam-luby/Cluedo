package ie.ucd.cluedo;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<String> cards = new ArrayList<String>();
	private String name;
	private String pawn;
	
	
	// TODO might need to change name and pawn to hashmap
	public Player(String name, String pawn, ArrayList<String> arrayList) {
		this.name = name;
		this.pawn = pawn;
		this.cards = arrayList;
	}

	public ArrayList<String> getCards() {
		return cards;
	}
	
	public String getPawn() {
		return pawn;
	}
	
	public String getName() {
		return name;
	}
	
}
