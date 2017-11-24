package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.Scanner;

public class Accusation {
	
	private Player player;
//	private ArrayList<Player> players;
	private static Cards cards = Cards.getInstance();
	private static ArrayList<String> answerCards = cards.getAnswerCards();
	private String weaponAccusation;
	private String suspectAccusation;
	private String roomAccusation;
	private boolean accusationCheck;
	
	public Accusation(Player player, String room) {
		this.player = player;
		this.roomAccusation = room;
		
		Scanner myScanner = new Scanner(System.in);
		while(!myScanner.hasNext()) {        					//Keep asking for a number
			System.out.println("Which weapon: ");
			myScanner.next();
		}
		this.weaponAccusation = myScanner.next();
		
		while(!myScanner.hasNext()) {        					//Keep asking for a number
			System.out.println("Which suspect: ");
			myScanner.next();
		}
		this.suspectAccusation = myScanner.next();
		
		this.accusationCheck = checkAccusation(weaponAccusation, suspectAccusation, roomAccusation);
		if(accusationCheck) {
			//Winner
			//TODO End game
			System.out.println("Winner.");
			System.exit(0);
		} else {
			//Loser
			//TODO Kick from game
			System.out.println("Loser.");
		}
		
	}
	
//	If any part of the accusation is wrong, the whole accusation is wrong so delete the player
	public boolean checkAccusation(String w, String s, String r) {
		if(w.equals(answerCards.get(0))) {
			return false;
		} else if(s.equals(answerCards.get(1))) {
			return false;
		} else if(r.equals(answerCards.get(2))) {
			return false;
		} else {
			return true;
		}
	}
	
}
