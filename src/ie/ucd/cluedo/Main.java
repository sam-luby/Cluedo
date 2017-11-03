package ie.ucd.cluedo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
			
		
		PlayerSetup setupPlayers = new PlayerSetup();
		setupPlayers.setPlayers();
		String[] names = setupPlayers.getPlayers();
		
		setupPlayers.setPawns(names);
		Map<String, String> playerPawnAssignment = setupPlayers.getPawns();
		
		Set<?> set = playerPawnAssignment.entrySet();
		Iterator<?> iter = set.iterator();
		
		while(iter.hasNext()) {
			Map.Entry me = (Map.Entry)iter.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		
	}
}
