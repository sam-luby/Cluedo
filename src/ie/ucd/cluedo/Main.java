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
		String[] names = setupPlayers.getPlayers();
		ArrayList<Player> players = new ArrayList<Player>();
		
//		setupPlayers.setPawns(names);
//		Map<String, String> playerPawnAssignment = setupPlayers.getPawns();
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
//		SuspectCards suspects;
//		AllCards cards;
//		
//		ArrayList<Player> playerNames = setupPlayers.setPlayers();
//		
//		for(Player p : playerNames) {
//			System.out.println(p.getName());
//			System.out.println(p.getPawn());
//			System.out.println(p.getCards());
//		}
		
		players = setupPlayers.setPlayers();
		for(Player p : players) {
			System.out.println(p.getName());
			System.out.println(p.getPawn());
			System.out.println(p.getCards());
		}

		
	}
}
