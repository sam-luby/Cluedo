package ie.ucd.cluedo;

import org.apache.commons.lang3.ArrayUtils;

public class PlayerCards extends Cards {
	
	RemainingCards remainingCards = new RemainingCards(); // remaining cards after choosing the solution cards
	
	int numPlayers;		
	
	public PlayerCards(int numPlayers, RemainingCards r) {
		this.numPlayers = numPlayers;
		this.remainingCards = r;
	}
	
	public String[] distribute(String[] answerCards) {
				
		// doesnt divide evenly for 4 or 5 players
		if(numPlayers==4 || numPlayers==5) {
			
		}
		else {
			
		}
	}
	
}
