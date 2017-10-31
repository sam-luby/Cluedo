package ie.ucd.cluedo;

import java.util.Scanner; 

/**
 * Functionality to add the players to the game. Currently implemented in the form of a console scanner/user input.
 * @author Sam
 */
public class AddPlayers {
	private String[] players;
	
	public String[] getPlayers() {
		return players;
	}
	
	public void setPlayers() {
		System.out.println("How many players are going to play? [3-6]");
		
		Scanner numberOfPlayersScanner = new Scanner(System.in);
		int num = numberOfPlayersScanner.nextInt();
		
		System.out.println("Enter all " + num + " player names here:");
		String[] playerNames = new String[num];

		Scanner playersScanner = new Scanner(System.in);
		
		for(int i = 0; i < num; i++) {
			playerNames[i] = (playersScanner.next());
		}
		
		numberOfPlayersScanner.close();
		playersScanner.close();
	
		players = playerNames;
	}
	
}
