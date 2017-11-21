package ie.ucd.cluedo;

/*
 * Main class, run this to set up the game. 
 * @author Sam & Darren
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
//		Add & setup players
		PlayerSetup setup = new PlayerSetup();
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();
		
//      Create a customized notebook for each player		
		for(Player p : players) {
			Notebook nb = new Notebook(p);
		}
		
//		Below is temporary test code & will be removed soon.
		for(Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}
		
//		Board initialisation
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.initialiseBoard(players);
		myBoard.printBoard();

//		Give each player a turn
		//TODO This will have to keep looping until some boolean endGame == 1
		//TODO After each player moves, they get to do something [Accusation, Hypothesis, SecretPassage, Nothing etc]
		for(Player p : players) {
			myBoard.movePlayer(p);
		}
		
		System.out.println("Game demo over...");
		System.exit(0);
	}
}
