package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles a player accusation. Creates a new instance of Accusation and gets the user's guess from console.
 * If correct, they win.
 * If incorrect, they are kicked from the game.
 * @author Sam
 */
public class Accusation {
	private Player player;
	private static Cards deck = Cards.getInstance();
	private static ArrayList<String> answerCards = deck.getAnswerCards();
	private String weaponAccusation;
	private String suspectAccusation;
	private String roomAccusation;
	private boolean accusationCheck;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	public Accusation(Player player, String room) {
		this.player = player;
		this.roomAccusation = room;
		suspectCards = deck.getSuspectCards();
		System.out.println(suspectCards);
		weaponCards = deck.getWeaponCards();
		
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
			System.out.println("Winner.");
			System.exit(0);
		} else {
			//Loser
			//TODO Kick from game
			System.out.println("Loser, you are removed from the game.");
		}
	}
	
//	If any part of the accusation is wrong, the whole accusation is wrong so delete the player
	public boolean checkAccusation(String weapon, String suspect, String room) {
		System.out.println(weapon + " " + suspect + " " + room);
		System.out.println(answerCards);
		if(!weapon.equals(answerCards.get(0))) {
			return false;
		} else if(!suspect.equals(answerCards.get(1))) {
			return false;
		} else if(!room.equals(answerCards.get(2))) {
			return false;
		} else {
			return true;
		}
	}
	
}
