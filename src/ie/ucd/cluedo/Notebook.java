package ie.ucd.cluedo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Notebook {
	private ArrayList<String> playerCards;
	private String player;
	private String pawn;
	private ArrayList<String> allCards;
	
	
	public Notebook(Player p) throws FileNotFoundException {
		
		this.playerCards = p.getCards();
		this.player = p.getName();
		this.pawn  = p.getPawn();
		Cards cards = new Cards();
		allCards = cards.getAllCards();
	}
	
	public void makeNoteBook(ArrayList<String> cards) throws FileNotFoundException {
		PrintWriter playerNotebook = new PrintWriter(player + "'s notebook.txt");
		for(String s : allCards) {
			int i = 0;
			for(String c : cards) {
				if(!c.equalsIgnoreCase(s)) {
					i++;
					if(i == cards.size()) {
						playerNotebook.println(s);
					}
				} 
				else if(c.equalsIgnoreCase(s)) {
					playerNotebook.println(s + " ✓");
					System.out.println(c);
				} 
			}
		}
		playerNotebook.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		PlayerSetup setup = new PlayerSetup();
		setup.addPlayers();
		ArrayList<Player> players = setup.setupPlayers();
		Notebook nb = new Notebook(players.get(0));
		nb.makeNoteBook(players.get(0).getCards());
	}
}
