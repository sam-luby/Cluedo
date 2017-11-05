package ie.ucd.cluedo;

import java.util.ArrayList;

import ie.ucd.cluedo.PlayerSetup;




public class Main {
	public static void main(String[] args) {
			
		
		PlayerSetup setupPlayers = new PlayerSetup();
		setupPlayers.addPlayers();
		ArrayList<Player> players = new ArrayList<Player>();

		
		players = setupPlayers.setPlayers();
		for(Player p : players) {
			System.out.println("Player: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}

	}
}
