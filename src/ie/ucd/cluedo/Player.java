package ie.ucd.cluedo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Player class to store name, pawn and player cards
 * author: Darren
 */
public class Player {
	
	private ArrayList<String> cards = new ArrayList<String>();
	private String name;
	private String pawn;
	private int[] location;
	private Notebook nb; 
	
	public Player(String name, String pawn, ArrayList<String> arrayList) throws FileNotFoundException {
		this.name = name;
		this.pawn = pawn;
		this.cards = arrayList;
		this.location = new int[2];
		nb = new Notebook(this);
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
	
	public void setLocation(int i, int j) {
		this.location[0] = i;
		this.location[1] = j;
	}
	
	public int[] getLocation() {
		return location;
	}
	
	public Notebook getNoteBook() {
		return nb;
	}
	
}
