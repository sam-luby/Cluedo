package ie.ucd.cluedo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		PlayerSetup setup = new PlayerSetup();
		setup.addPlayers();
		ArrayList<Player> players = setup.setupPlayers();
		
		for(Player p : players) {
			Notebook nb = new Notebook(p);
			nb.makeNoteBook(p.getCards());
		}
		
//		TestCode
		for(Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}
		
		System.exit(0);
	}
}
