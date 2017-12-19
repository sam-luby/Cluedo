package ie.ucd.cluedo;

import java.io.IOException;
import java.util.ArrayList;

public class Cluedo {

	// demoMode is for for dev/QA purposes
	boolean demoMode = true;
	static boolean endGame = false;
	static boolean deletePlayerFlag = false;
	static Player deletePlayerName;

	public Cluedo() throws IOException {
		// Game setup
		Cards deck = Cards.getInstance();
		PlayerSetup setup = new PlayerSetup(deck.getRemainingCards());
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();

//		Print out sensitive information if in demo mode
		if (demoMode) {
			for (Player p : players) {
				System.out.println("\nPlayer: " + p.getName() + ", Pawn: " + p.getPawn());
				System.out.println("Cards: " + p.getCards());
			}
			System.out.println("\nANSWER CARDS");
			System.out.println(deck.getAnswerCards());
		}

		// Board initialisation
		CluedoBoard myBoard = new CluedoBoard(players);
		myBoard.initialisePlayerLocations();

		// Give each player a turn
		players = setup.getPlayers();
		while (!endGame) {
			for (int i = 0; i < players.size(); i++) {
				myBoard.playerMove(players.get(i));

				// If we need to delete a player, remove them from the game.
				if (i == players.size()-1 && deletePlayerFlag) {
					PlayerSetup.deletePlayer(deletePlayerName);
					Cluedo.deletePlayerFlag = false;
				}
			}
		}

		System.out.println("Game over...");
		System.exit(0);
	}

}
