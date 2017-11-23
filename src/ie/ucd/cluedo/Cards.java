package ie.ucd.cluedo;

import ie.ucd.cluedo.enums.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Distribute cards amongst players
 * @author Darren
 */
public class Cards {
	
	// playerCards is an arraylist of string arraylists which consist of each player's cards
	private static ArrayList<String> solutionCards = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	// Constructor calculates the solution cards and the remaining cards 
	public Cards() {
		solutionCards.add(WeaponCards.random().getWeapon());
		solutionCards.add(SuspectCards.random().getSuspect());
		solutionCards.add(RoomCards.random().getRoom());
		
		for(WeaponCards w : WeaponCards.values()) {
			if(!solutionCards.contains(w.getWeapon())) {
				remainingCards.add(w.getWeapon());
			}
		}
		for(SuspectCards s : SuspectCards.values()) {
			if(!solutionCards.contains(s.getSuspect())) {
				remainingCards.add(s.getSuspect());
			}
		}
		for(RoomCards r : RoomCards.values()) {
			if(!solutionCards.contains(r.getRoom())) {
				remainingCards.add(r.getRoom());
			}
		}
	};
	
	public ArrayList<String> getWeaponCards(){
		ArrayList<String> weaponCards = new ArrayList<String>();
		for(WeaponCards w : WeaponCards.values()) {
			weaponCards.add(w.getWeapon());
		}
		return weaponCards;
	}
	
	public ArrayList<String> getSuspectCards(){
		ArrayList<String> suspectCards = new ArrayList<String>();
		for(SuspectCards w : SuspectCards.values()) {
			suspectCards.add(w.getSuspect());
		}
		return suspectCards;
	}
	
	public ArrayList<String> getRoomCards(){
		ArrayList<String> roomCards = new ArrayList<String>();
		for(RoomCards w : RoomCards.values()) {
			roomCards.add(w.getRoom());
		}
		return roomCards;
	}

	public ArrayList<String> getAllCards(){
		ArrayList<String> allCards = new ArrayList<String>();
		
		for(WeaponCards w : WeaponCards.values()) {
			allCards.add(w.getWeapon());
		}
		for(SuspectCards s : SuspectCards.values()) {
			allCards.add(s.getSuspect());
		}
		for(RoomCards r : RoomCards.values()) {
			allCards.add(r.getRoom());
		}
		return allCards;
	}
	
	// returns the solution cards to be placed in the middle of the board
	public ArrayList<String> getAnswerCards() {
		return solutionCards;
	}
	
	public ArrayList<String> getRemainingCards(){
		return remainingCards;
	}
	
	//Temporary main method for testing AllCards class
//	public static void main(String[] args) {
//		
//		System.out.println("How many players are going to play? [3-6]");
//		Scanner numberOfPlayersScanner = new Scanner(System.in);
//		int numPlayers = numberOfPlayersScanner.nextInt();
//		numberOfPlayersScanner.close();
//		
//		AllCards cards = new AllCards();
//		ArrayList<String> answerCards = cards.answerCards();
//		System.out.print("\nDisplaying the answer cards: \n");
//		for(String a : answerCards) {
//			System.out.println(a);
//		}
//		
//		System.out.print("\nNow displaying the remaining cards: \n");
//		ArrayList<String> remainingCards = cards.remainingCards();
//		for(String r : remainingCards) {
//			System.out.println(r);
//		}
//		
//		cards.distributeCards(numPlayers);
//		System.out.println("\nNow displaying distributed cards between "+numPlayers+" players: \n");
//		
//		for(int i=0;i<numPlayers;i++) {
//			System.out.println("Player " + (i+1) + " cards: "  + cards.getPlayerCards().get(i));
//		}
//		
//	}
	
}
