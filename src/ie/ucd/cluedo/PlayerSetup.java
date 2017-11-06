package ie.ucd.cluedo;

import java.util.ArrayList;

//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

import ie.ucd.cluedo.Player;
import ie.ucd.cluedo.enums.SuspectCards; 

/**
 * Functionality to add the players to the game. Currently implemented in the form of a console scanner/user input.
 * @author Sam
 */
public class PlayerSetup {
	private String[] players;
	ArrayList<Player> playerNames;
	SuspectCards suspects;
	AllCards cards;
	
	public PlayerSetup() {
		cards = new AllCards();
		playerNames = new ArrayList<Player>();
	}
	
	public String[] getPlayers() {
		return players;
	}
	
	public void addPlayers() {
		System.out.println("How many players are going to play? [3-6]");
		
		Scanner numberOfPlayersScanner = new Scanner(System.in);
		int numPlayers = numberOfPlayersScanner.nextInt();
		
		if(numPlayers < 3) {
			System.out.println("There must be at least 3 players, enter a number between 3-6: ");
			numPlayers = numberOfPlayersScanner.nextInt();
		}
		
		System.out.println("Enter all " + numPlayers + " player names here: ");
		String[] playerNames = new String[numPlayers];

		Scanner playersScanner = new Scanner(System.in);
		
		for(int i = 0; i < numPlayers; i++) {
			playerNames[i] = (playersScanner.next());
		}
		
		numberOfPlayersScanner.close();
		playersScanner.close();
	
		players = playerNames;
	}
	
	//Randomly assigns each player with cards, gives each player a pawn card name.
	public ArrayList<Player> setupPlayers() {
		cards.distributeCards(players.length);
		for(int i = 0; i < players.length; i++ ) {
			playerNames.add(new Player(players[i], SuspectCards.values()[i].getSuspect(), cards.getPlayerCards().get(i))); 
		}
		return playerNames;
	}
	
	//Temporary main method to test PlayerSetup class.
//	public static void main(String[] args) {
//		PlayerSetup setupPlayers = new PlayerSetup();
//		setupPlayers.addPlayers();
//		ArrayList<Player> players = new ArrayList<Player>();
//
//		players = setupPlayers.setupPlayers();
//		for(Player p : players) {
//			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
//			System.out.println("Cards: " + p.getCards());
//		}
//	}
	
}
