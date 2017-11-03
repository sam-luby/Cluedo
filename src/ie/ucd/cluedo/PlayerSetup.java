package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
	private Map<String, String> pawns;
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
		int num = numberOfPlayersScanner.nextInt();
		
		System.out.println("Enter all " + num + " player names here: ");
		String[] playerNames = new String[num];

		Scanner playersScanner = new Scanner(System.in);
		
		for(int i = 0; i < num; i++) {
			playerNames[i] = (playersScanner.next());
		}
		
		numberOfPlayersScanner.close();
		playersScanner.close();
	
		players = playerNames;
	}
	
	
	public void setPawns(String[] players) {
		Map<String, String> playerPawnAssignment = new HashMap<String, String>();
		
		for(int j = 0; j < players.length; j++) {
			playerPawnAssignment.put(players[j], SuspectCards.values()[j].toString());
		}
		
		pawns = playerPawnAssignment;
	}
	
	
	public Map<String, String> getPawns() {
		return pawns;
	}
	
	
	public ArrayList<Player> setPlayers() {
		
		for(int i = 0; i < players.length; i++ ) {
			//TODO Fix this card assignment (currently null)
			playerNames.add(new Player(players[i], suspects.random().getSuspect(), cards.getplayer1Cards())); 
			
//			System.out.println(p1.getName());
//			System.out.println(p1.getPawn());
//			System.out.println(p1.getCards());
		}
		return playerNames;
		
	}
	
}
