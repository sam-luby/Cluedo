package ie.ucd.cluedo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ie.ucd.cluedo.enums.SuspectCards; 

/**
 * Functionality to add the players to the game. Currently implemented in the form of a console scanner/user input.
 * @author Sam
 */
public class PlayerSetup {
	private String[] players;
	private Map<String, String> pawns;
	
	public String[] getPlayers() {
		return players;
	}
	
	public void setPlayers() {
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
	
	
	
	
	
	
//	public static void main(String[] args){
//		
//		PlayerSetup newPlayers = new PlayerSetup();
//		newPlayers.setPlayers();
//		String [] players = newPlayers.getPlayers();
//		
//		int i = 1; 
//		for(String p : players ) {
//			System.out.println("Player " + i + ": " + p);
//			i++;
//		}
//		
//		Map<String, SuspectCards> playerPawnAssignment = new HashMap<String, SuspectCards>();
//		for(int j = 0; j < players.length; j++) {
//			playerPawnAssignment.put(players[j], SuspectCards.values()[j]);
//		}
//		
//		
//		Set<?> set = playerPawnAssignment.entrySet();
//		Iterator<?> iter = set.iterator();
//		
//		while(iter.hasNext()) {
//			Map.Entry me = (Map.Entry)iter.next();
//			System.out.print(me.getKey() + ": ");
//			System.out.println(me.getValue());
//		}
//		
//	}
	
}
