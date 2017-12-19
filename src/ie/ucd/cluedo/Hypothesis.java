package ie.ucd.cluedo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ie.ucd.cluedo.enums.RoomCards;
import ie.ucd.cluedo.enums.SuspectCards;
import ie.ucd.cluedo.enums.WeaponCards;

/**
 * Handles a player hypothesis. Creates a new instance of Accusation and gets the user's guess from console.
 * @author Sam & Darren
 */
public class Hypothesis {
	private Player player;
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
	
	public Hypothesis(Player player, ArrayList<Player> players, String room) throws IOException {
		this.player = player;
		this.players = players;
		this.roomHypothesis = room;
		myCards = player.getCards();
		Cards deck = Cards.getInstance();
		allCards = deck.getAllCards();
		suspectCards = deck.getSuspectCards();
		weaponCards = deck.getWeaponCards();
		roomCards = deck.getRoomCards();

		Scanner myScanner = new Scanner(System.in);
		String weapon;
		String suspect;
				
		// TODO need to check if the room is one of the player's cards and tell them they probably don't want to make a hypothesis in this room, give option to change decision or continue
		
		System.out.println("Please enter a weapon: ");
		weapon = myScanner.nextLine().trim();
		while(!weaponCards.contains(weapon) || myCards.contains(weapon)) {
			System.out.println("Enter a valid weapon [can not be one of your own cards]: ");
			weapon = myScanner.nextLine().trim();
		}
		weaponHypothesis = weapon;
		
		System.out.println("Please enter a suspect: ");
		suspect = myScanner.nextLine().trim();
		while(!suspectCards.contains(suspect)  || myCards.contains(suspect)) {
			System.out.println("Enter a valid suspect [can not be one of your own cards]: ");
			suspect = myScanner.nextLine().trim();
		} 
		suspectHypothesis = suspect;
		
		this.hypothesisCheck = checkHypothesis(player);
		
		if(hypothesisCheck) {
		//Refuted
			System.out.println("Refuted, Notebook updated");
		} else {
			System.out.println("Winner!");
			Cluedo.endGame = true;
			System.exit(0);
		}
	}
	
	//TODO Refactor this
	public boolean checkHypothesis(Player p) throws IOException {
		String output = null;
		Notebook nb = p.getNoteBook();
		for(Player player : players) {
			cards = player.getCards();
			
			if(cards.contains(weaponHypothesis)) {
				output = weaponHypothesis;
				System.out.println("\nRefuted weapon: " + output);
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				return true;
			}
			else if(cards.contains(suspectHypothesis)) {
				output = suspectHypothesis;
				System.out.println("\nRefuted suspect: " + output);
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				return true;
			}
			else if(cards.contains(roomHypothesis)) {
				output = roomHypothesis;
				System.out.println("\nRefuted room: " + output);
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				return true;
			}
		}
		
		return false;
	}
	
}
