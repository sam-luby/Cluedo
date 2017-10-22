package ie.ucd.cluedo;

import org.apache.commons.lang3.ArrayUtils;

public class PlayerCards extends Cards {
	private String[] rooms = new String[9];
	private String[] weapons = new String[6];
	private String[] suspects = new String[6];
	
	int numPlayers;		
	
	public PlayerCards(int numPlayers) {
		this.numPlayers = numPlayers;
		rooms = RoomCards.getCards();
		weapons = WeaponCards.getCards();
		suspects = SuspectCards.getCards();
		String[] allCards = (String[]) ArrayUtils.addAll(rooms, weapons, suspects);
	}
	
	
	
	
}
