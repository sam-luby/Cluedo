package ie.ucd.cluedo;

import java.io.IOException;
import java.util.ArrayList;

public class Cluedo {

	//DemoMode is for for dev/QA purposes
	public static boolean demoMode = false;
	
	//End game can be set from the accusations/hypothesis classes 
	static boolean endGame = false;
	
	//Signal to delete player from game
	static boolean deletePlayerFlag = false;
	static Player deletePlayerName;

	public Cluedo() throws IOException {
		//Game setup
		Cards deck = Cards.getInstance();
		PlayerSetup setup = new PlayerSetup(deck.getRemainingCards());
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();

		//Board initialisation
		CluedoBoard myBoard = new CluedoBoard(players);
		myBoard.initialisePlayerLocations();
		char[][] board = myBoard.getBoard();


		//Print out sensitive information if in demo mode
		if (demoMode) {
			for (Player p : players) {
				System.out.println("\nPlayer: " + p.getName() + ", Pawn: " + p.getPawn());
				System.out.println("Cards: " + p.getCards());
			}
			System.out.println("\nANSWER CARDS");
			System.out.println(deck.getAnswerCards());
		}

		
		//Give each player a turn until the game ends
		players = setup.getPlayers();
		while (!endGame) {
			for (int i = 0; i < players.size(); i++) {
				myBoard.playerMove(players.get(i));

				//If we need to delete a player after a round of turns, remove them from the game
				if (i == players.size()-1 && deletePlayerFlag) {
					PlayerSetup.deletePlayer(deletePlayerName);
					int[] loc = deletePlayerName.getLocation();
					board[loc[0]][loc[1]] = ' ';
					Cluedo.deletePlayerFlag = false;
				}
			}
		}

		System.out.println("Game over...");
		System.exit(0);
	}

}
