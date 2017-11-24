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
	private String roomHypothsis;
	private String suspectHypothesis;
	private String weaponHypothesis;
	private ArrayList<String> cards;
	private ArrayList<String> myCards;
	private ArrayList<String> allCards;
	private ArrayList<String> roomCards;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	public Hypothesis(Player p, ArrayList<Player> players, String room) {
		this.p = p;
		this.players = players;
		this.roomHypothsis = room;
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
		
		
	}
	
	public String refute(Player p) throws IOException {
		int num = 0;
		String output = null;
		for(Player player : players) {
			cards = player.getCards();
			Notebook nb = player.getNoteBook();
			if(cards.contains(weaponHypothesis)) {
				output = weaponHypothesis;
				nb.updateNoteBook(output);
				break;
			}
			else if(cards.contains(suspectHypothesis)) {
				output = suspectHypothesis;
				nb.updateNoteBook(output);
				break;
			}
			else if(cards.contains(roomHypothsis)) {
				output = roomHypothsis;
				nb.updateNoteBook(output);
				break;
			}
			else {
				num += 1;
			}
		}
		if(num == 18) {
			output = "WINNER!!";
		}
		return output;
	}
	
}
