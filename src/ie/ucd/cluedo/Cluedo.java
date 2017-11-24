package ie.ucd.cluedo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Cluedo {

	
	public Cluedo() throws IOException {
//		Add & setup players
		Cards deck = Cards.getInstance();
		PlayerSetup setup = new PlayerSetup(deck.getRemainingCards());
		System.out.println(deck.getRemainingCards());
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();
		
//		Below is temporary test code & will be removed soon.
		for(Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}
		System.out.println("ANSWER CARDS");
		System.out.println(deck.getAnswerCards());
		
		
//		Board initialisation
		CluedoBoard myBoard = new CluedoBoard(players);
		myBoard.initialiseBoard();
		myBoard.printBoard();

//		Give each player a turn
		//TODO This will have to keep looping until some boolean endGame == 1
		//TODO After each player moves, they get to do something [Accusation, Hypothesis, SecretPassage, Nothing etc]
		for(Player p : players) {
			myBoard.playerMove(p);
		}
		
		System.out.println("Game demo over...");
		System.exit(0);
	}
		
		
	
}
