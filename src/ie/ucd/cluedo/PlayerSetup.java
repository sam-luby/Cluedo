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
	
	public ArrayList<Player> setPlayers() {
		cards.setCards(players.length);
		for(int i = 0; i < players.length; i++ ) {
			//TODO Fix this card assignment (currently null)
			playerNames.add(new Player(players[i], SuspectCards.values()[i].getSuspect(), cards.getPlayerCards().get(i))); 
		}
		return playerNames;
		
	}
	
}
