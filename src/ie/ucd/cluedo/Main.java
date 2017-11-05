package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ie.ucd.cluedo.AllCards;
import ie.ucd.cluedo.PlayerSetup;
import ie.ucd.cluedo.enums.SuspectCards;



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
