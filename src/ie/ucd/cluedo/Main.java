package ie.ucd.cluedo;

/*
 * Main class, run this to set up the game. 
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
//		Add & setup players
		PlayerSetup setup = new PlayerSetup();
		setup.addPlayers();
		ArrayList<Player> players = setup.setupPlayers();
		
//      Create a customised notebook for each player		
		for(Player p : players) {
			Notebook nb = new Notebook(p);
		}
		
		
//		Below is temporary test code & will be removed soon.
		for(Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}
		System.exit(0);
	}
}
