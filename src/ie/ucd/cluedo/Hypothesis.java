package ie.ucd.cluedo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ie.ucd.cluedo.enums.RoomCards;
import ie.ucd.cluedo.enums.SuspectCards;
import ie.ucd.cluedo.enums.WeaponCards;

public class Hypothesis {
	
	private Player p;
	private ArrayList<Player> players;
	private String roomHypothesis;
	private String suspectHypothesis;
	private String weaponHypothesis;
	private boolean hypothesisCheck;
	private ArrayList<String> cards;
	private ArrayList<String> myCards;
	private ArrayList<String> allCards;
	private ArrayList<String> roomCards;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	public Hypothesis(Player p, ArrayList<Player> players, String room) throws IOException {
		this.p = p;
		this.players = players;
		this.roomHypothesis = room;
		myCards = p.getCards();
		
		Cards deck = Cards.getInstance();
		allCards = deck.getAllCards();
		suspectCards = deck.getSuspectCards();
		weaponCards = deck.getWeaponCards();
		roomCards = deck.getRoomCards();

		Scanner myScanner = new Scanner(System.in);
		String input;
				
		System.out.println("Please enter a weapon: ");
		do {
			input = myScanner.nextLine().trim();
		} while(!weaponCards.contains(input)) ;
		weaponHypothesis = input;
		
		System.out.println("Please enter a suspect: ");
		do {
			input = myScanner.nextLine().trim();
		} while(!suspectCards.contains(input)) ;
		suspectHypothesis = input;
		
		this.hypothesisCheck = refute(p);
		if(hypothesisCheck) {
			// refuted
			System.out.println("Refuted");
		} else {
			System.out.println("Winner.");
			System.exit(0);
		}
		
	}
	
	public boolean refute(Player p) throws IOException {
		int num = 0;
		String output = null;
		for(Player player : players) {
			cards = player.getCards();
			
			Notebook nb = player.getNoteBook();
			if(cards.contains(weaponHypothesis)) {
				output = weaponHypothesis;
				System.out.println("refuted weapon: " + output);
				nb.updateNoteBook(output);
				return true;
			}
			else if(cards.contains(suspectHypothesis)) {
				output = suspectHypothesis;
				System.out.println("refuted suspect: " + output);
				nb.updateNoteBook(output);
				return true;
			}
			else if(cards.contains(roomHypothesis)) {
				output = roomHypothesis;
				System.out.println("refuted room: " + output);
				nb.updateNoteBook(output);
				return true;
			}
		}
		
		return false;
	}
	
}
