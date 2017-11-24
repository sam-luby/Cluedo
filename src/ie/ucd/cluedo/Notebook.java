package ie.ucd.cluedo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Notebook class for an individual player notebook that contains the known non-answer cards
 * @author Sam
 */
public class Notebook {
	private ArrayList<String> playerCards;
	private String player;
	private String pawn;
	private ArrayList<String> allCards;
	Cards cards = new Cards();
	
	public Notebook(Player p) throws FileNotFoundException {
		this.playerCards = p.getCards();
		this.player = p.getName();
		this.pawn  = p.getPawn();
		allCards = cards.getAllCards();
		makeNoteBook(playerCards);
	}
	
	//TODO Change this to a GUI implementation
	/**
	 * Creates a new notebook for a player and shows which cards they have 
	 * @param cards (the randomly assigned cards the player was assigned)
	 */
	public void makeNoteBook(ArrayList<String> cards) throws FileNotFoundException {
		PrintWriter playerNotebook = new PrintWriter(player + "'s notebook.txt");  		//Creates a new notebook text file for each player
		playerNotebook.println(player + " " + pawn);								 
		playerNotebook.println();
		for(String s : allCards) {
			int i = 0;
			for(String c : cards) {
				if(!c.equalsIgnoreCase(s)) {											
					i++;
					if(i == cards.size()) {
						playerNotebook.println(s);										//If player doesn't have this card, print as normal
					}
				} else if(c.equalsIgnoreCase(s)) {
					playerNotebook.println(s + " ✓");									//If player does have this card, add a checkmark
				} 
			}
		}
		playerNotebook.close();
	}
	
	// updates the notebook one string at a time with a tick
	public void updateNoteBook(String update) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(player + "'s notebook.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(player + "'s notebook.txt"));
		
		String oldText = "";
		for(String x = reader.readLine(); x != null; x = reader.readLine()) {
			oldText += x + "\r\n";
		}
		reader.close();
		
		String replaceText = oldText.replaceAll(update, update + " ✓");
		writer.write(replaceText);
	}
	
	
	//Temporary main method for testing Notebook class
//	public static void main(String[] args) throws FileNotFoundException {
//		PlayerSetup setup = new PlayerSetup();
//		setup.addPlayers();
//		ArrayList<Player> players = setup.setupPlayers();
//		Notebook nb = new Notebook(players.get(0));
//	}
}
