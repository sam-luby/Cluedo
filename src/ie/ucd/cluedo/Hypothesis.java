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
	private String room;
	private String murderer;
	private String weapon;
	private ArrayList<String> cards;
	private ArrayList<String> myCards;
	private ArrayList<String> allCards;
	private ArrayList<String> roomCards;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	public Hypothesis(Player p, ArrayList<Player> players, String room) {
		this.p = p;
		this.players = players;
		this.room = room;
		myCards = p.getCards();
		
		Cards deck = new Cards();
		allCards = deck.getAllCards();
		
		Scanner newScan = new Scanner(System.in);
				
		System.out.println("Please enter suspect: ");
		while(!suspectCards.contains(newScan.next()) || myCards.contains(newScan.next())) {        					//Keep asking for a number
			System.out.println("Please enter a valid suspect:");
			newScan.next();
		}
		murderer = newScan.next().toLowerCase();
		
		System.out.println("Please enter weapon: ");
		while(!weaponCards.contains(newScan.next()) || myCards.contains(newScan.next())) {        					//Keep asking for a number
			System.out.println("Please enter a valid suspect:");
			newScan.next();
		}
		weapon = newScan.next().toLowerCase();
	}
	
	public String refute(Player p) throws IOException {
		int num = 0;
		String output = null;
		for(Player player : players) {
			cards = player.getCards();
			Notebook nb = player.getNoteBook();
			if(cards.contains(weapon)) {
				output = weapon;
				nb.updateNoteBook(output);
				break;
			}
			else if(cards.contains(murderer)) {
				output = murderer;
				nb.updateNoteBook(output);
				break;
			}
			else if(cards.contains(room)) {
				output = room;
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
