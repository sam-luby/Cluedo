package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.Scanner;

public class Accusation {
	
	private Player player;
	private static Cards deck = Cards.getInstance();
	private static ArrayList<String> answerCards = deck.getAnswerCards();
	private String weaponAccusation;
	private String suspectAccusation;
	private String roomAccusation;
	private boolean accusationCheck;
	private ArrayList<String> myCards;
	private ArrayList<String> allCards;
	private ArrayList<String> roomCards;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	
	public Accusation(Player player, String room) {
		this.player = player;
		this.roomAccusation = room;
		myCards = player.getCards();
		allCards = deck.getAllCards();
		suspectCards = deck.getSuspectCards();
		System.out.println(suspectCards);
		weaponCards = deck.getWeaponCards();
		roomCards = deck.getRoomCards();
		
		Scanner myScanner = new Scanner(System.in);
		String input;
		
		System.out.println("Please enter a weapon: ");
		do {
			input = myScanner.nextLine().trim();
		} while(!weaponCards.contains(input)) ;
		weaponAccusation = input;
		
		System.out.println("Please enter a suspect: ");
		do {
			input = myScanner.nextLine().trim();
		} while(!suspectCards.contains(input)) ;
		suspectAccusation = input;
		
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
		System.out.println(w + " " + s + " " + r);
		System.out.println(answerCards);
		if(!w.equals(answerCards.get(0))) {
			return false;
		} else if(!s.equals(answerCards.get(1))) {
			return false;
		} else if(!r.equals(answerCards.get(2))) {
			return false;
		} else {
			return true;
		}
	}
	
}
