package ie.ucd.cluedo;

import java.util.Scanner; 

public class AddPlayers {
//	private int numberOfPlayers;
	private String[] players;
	
	public String[] getPlayers() {
		return players;
	}
	
	public static String[] setPlayers() {
		System.out.println("How many players are going to play?");
		
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
		return playerNames;
	}
	
	public static void main(String[] args) {

		String[] playerList = setPlayers();
		
		//temp testcode
		int i = 1;
		for(String p : playerList) {
			System.out.println("Player " + i + ": " + p);
			i++;
		}
	}
}
