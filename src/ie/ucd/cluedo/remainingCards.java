package ie.ucd.cluedo;

import org.apache.commons.lang3.ArrayUtils;

public class RemainingCards extends Cards{
	
	private String[] allCards = new String[21];
	private String[] rooms = new String[9];
	private String[] weapons = new String[6];
	private String[] suspects = new String[6];
	private String[] remainingCards = new String[18];	
	
	public RemainingCards() {
		rooms = RoomCards.getCards();
		weapons = WeaponCards.getCards();
		suspects = SuspectCards.getCards();
		allCards = (String[]) ArrayUtils.addAll(rooms, weapons, suspects);
	}
	
	public String[] getRemainingCards(String[] answerCards) {
		int j = 0;
		for(int i=0;i<allCards.length;i++) {
			// Might be a better way to do this comparison if statement
			if(allCards[i]!=answerCards[0] || allCards[i]!=answerCards[1] || allCards[i]!=answerCards[2]) {
				remainingCards[j] = allCards[i];
				j++;
			}
		}
		return remainingCards;
	}
		
}
