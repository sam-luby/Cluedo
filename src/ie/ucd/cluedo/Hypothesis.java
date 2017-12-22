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
	private Player p;
	private ArrayList<Player> players;
	private String roomHypothesis;
	private String suspectHypothesis;
	private String weaponHypothesis;
	private ArrayList<String> cards;
	private ArrayList<String> myCards;
	private ArrayList<String> suspectCards;
	private ArrayList<String> weaponCards;
	
	public Hypothesis(Player p, ArrayList<Player> players, String room) throws IOException {
		this.p = p;
		this.players = players;
		this.roomHypothesis = room;
		myCards = p.getCards();
		Cards deck = Cards.getInstance();
		suspectCards = deck.getSuspectCards();
		weaponCards = deck.getWeaponCards();
	}
	
    //Checks the players hypothesis, updates notebook accordingly
	public void checkHypothesis() throws IOException {
		String output = null;
		Notebook nb = p.getNoteBook();
		for(Player player : players) {
			cards = player.getCards();
			
			if(cards.contains(weaponHypothesis)) {
				output = weaponHypothesis;
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				System.out.println("Refuted, Notebook updated");
				return;
			}
			else if(cards.contains(suspectHypothesis)) {
				output = suspectHypothesis;
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				System.out.println("Refuted, Notebook updated");
				return;
			}
			else if(cards.contains(roomHypothesis)) {
				output = roomHypothesis;
				nb.updateNotebookWithRefute(output);
				for(Player pl : players) {
					Notebook note = pl.getNoteBook();
					note.updateNotebookWithHypothesis(weaponHypothesis, suspectHypothesis, roomHypothesis);
				}
				System.out.println("Refuted, Notebook updated");
				return;
			}
		}
		System.out.println("Winner!");
		Cluedo.endGame = true;
	}

	//Gets the players hypothesis input from console
	public void getHypothesis() {
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
				
	}
	
	
	// For jUnit testing purposes only (Testing could not be inplemented on the original method due to scanners and file read errors)
	public void setHypothesisCards(String r, String w, String s) {
		weaponHypothesis = w;
		suspectHypothesis = s;
		roomHypothesis = r;
	}
	
	// For jUnit testing purposes only (Testing could not be inplemented on the original method due to scanners and file read errors)
	public boolean checkHypothesisRefactored(){
		for(Player player : players) {
			cards = player.getCards();
			
			if(cards.contains(weaponHypothesis)) {
				return false;
			}
			else if(cards.contains(suspectHypothesis)) {
				return false;
			}
			else if(cards.contains(roomHypothesis)) {
				return false;
			}
		}
		return true;
	}
}
