package ie.ucd.cluedo;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		PlayerSetup setup = new PlayerSetup();
		setup.addPlayers();
		ArrayList<Player> players = setup.setupPlayers();
		
//		TestCode
		for(Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + ", Pawn: " +  p.getPawn());
			System.out.println("Cards: " + p.getCards());
		}
		
		System.exit(0);
	}
}
