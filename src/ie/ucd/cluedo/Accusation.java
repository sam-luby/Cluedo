package ie.ucd.cluedo;

import java.io.IOException;
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
	private ArrayList<String> roomCards;
	private ArrayList<String> myCards;
	private ArrayList<Player> players;
	
	public Accusation(Player player, ArrayList<Player> players) throws IOException {
		this.player = player;
		this.players = players;
		suspectCards = deck.getSuspectCards();
		weaponCards = deck.getWeaponCards();
		roomCards = deck.getRoomCards();
		myCards = player.getCards();
		
		Scanner myScanner = new Scanner(System.in);
		String input;
		
		System.out.println("Please enter a weapon: ");
		input = myScanner.nextLine().trim();
		while(!weaponCards.contains(input) || myCards.contains(input)) {
			System.out.println("Enter a valid weapon [can not be one of your own cards]: ");
			input = myScanner.nextLine().trim();
		} 
		weaponAccusation = input;
		
		System.out.println("Please enter a suspect: ");
		input = myScanner.nextLine().trim();
		while(!suspectCards.contains(input) || myCards.contains(input)) {
			System.out.println("Enter a valid suspect [can not be one of your own cards]: ");
			input = myScanner.nextLine().trim();
		} 
		suspectAccusation = input;
		
		System.out.println("Please enter a room: ");
		input = myScanner.nextLine().trim();
		while(!roomCards.contains(input) || myCards.contains(input)) {
			System.out.println("Enter a valid room [can not be one of your own cards]: ");
			input = myScanner.nextLine().trim();
		} 
		roomAccusation = input;
		
		this.accusationCheck = checkAccusation(weaponAccusation, suspectAccusation, roomAccusation);
		
		if(accusationCheck) {
			//Winner
			System.out.println("Winner.");
			Cluedo.endGame = true;
			System.exit(0);
		} else {
			//Loser
			Cluedo.deletePlayerName = player;
			Cluedo.deletePlayerFlag = true;
//			PlayerSetup.deletePlayer(player);
			System.out.println("Loser, you are removed from the game.");
		}
	}
	
//	If any part of the accusation is wrong, the whole accusation is wrong so delete the player
//	TODO Fix kicking player bug.
	public boolean checkAccusation(String weapon, String suspect, String room) throws IOException {
		System.out.println(weapon + " " + suspect + " " + room);
		System.out.println(answerCards);
		if(!weapon.equals(answerCards.get(0))) {
			for(Player p : players) {
				Notebook nb = p.getNoteBook();
				nb.updateNotebookWithAccusation(weapon, suspect, room);
			}
			return false;
		} else if(!suspect.equals(answerCards.get(1))) {
			for(Player p : players) {
				Notebook nb = p.getNoteBook();
				nb.updateNotebookWithAccusation(weapon, suspect, room);
			}
			return false;
		} else if(!room.equals(answerCards.get(2))) {
			for(Player p : players) {
				Notebook nb = p.getNoteBook();
				nb.updateNotebookWithAccusation(weapon, suspect, room);
			}
			return false;
		} else {
			return true;
		}
	}
	
}
