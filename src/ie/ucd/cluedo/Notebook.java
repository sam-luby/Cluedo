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
	Cards cards = Cards.getInstance();
	
	public Notebook(Player p) {
		this.playerCards = p.getCards();
		this.player = p.getName();
		this.pawn  = p.getPawn();
		allCards = cards.getAllCards();
		makeNoteBook(playerCards);
	}
	
	/**
	 * Creates a new notebook for a player and shows which cards they have 
	 * @param cards (the randomly assigned cards the player was assigned)
	 */
	public void makeNoteBook(ArrayList<String> cards) {
		PrintWriter playerNotebook = null;
		try {
			playerNotebook = new PrintWriter(player + "'s notebook.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  		
		
		//Creates a new notebook text file for each player
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
	public void updateNotebookWithRefute(String update) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(player + "'s notebook.txt"));
		
		String oldText = "";
		String x = "";
		
		while((x = reader.readLine()) != null) {
			oldText += x + "\r\n";
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(player + "'s notebook.txt"));
		String replaceText = oldText.replaceAll(update, update + " ✓ (Refuted)");
		writer.write(replaceText);
		writer.close();
	}
	
	public void updateNotebookWithHypothesis(String weaponHypothesis, String suspectHypothesis, String roomHypothesis) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(player + "'s notebook.txt"));
		
		String oldText = "";
		String x = "";
		
		while((x = reader.readLine()) != null) {
			oldText += x + "\r\n";
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(player + "'s notebook.txt"));
		String replaceText = oldText;
		replaceText += "\n\n\nHypothesis made: " + weaponHypothesis + ", " + suspectHypothesis + ", " + roomHypothesis;
		writer.write(replaceText);
		writer.close();
		
	}
	
	public void updateNotebookWithAccusation(String weaponHypothesis, String suspectHypothesis, String roomHypothesis) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(player + "'s notebook.txt"));
		
		String oldText = "";
		String x = "";
		
		while((x = reader.readLine()) != null) {
			oldText += x + "\r\n";
		}
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(player + "'s notebook.txt"));
		String replaceText = oldText;
		replaceText += "\n\n\nAccusation made: " + weaponHypothesis + ", " + suspectHypothesis + ", " + roomHypothesis;
		writer.write(replaceText);
		writer.close();
		
	}
}
