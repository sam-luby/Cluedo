package ie.ucd.cluedo;

import ie.ucd.cluedo.enums.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Distribute cards amongst players
 * @author Darren
 */
public class AllCards {
	
	private ArrayList<ArrayList<String>> playerCards = new ArrayList<ArrayList<String>>();
	private static ArrayList<String> solution = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	public AllCards() {
		solution.add(WeaponCards.random().getWeapon());
		solution.add(SuspectCards.random().getSuspect());
		solution.add(RoomCards.random().getRoom());
		
		for(WeaponCards w : WeaponCards.values()) {
			if(!solution.contains(w.getWeapon())) {
				remainingCards.add(w.getWeapon());
			}
		}
		for(SuspectCards s : SuspectCards.values()) {
			if(!solution.contains(s.getSuspect())) {
				remainingCards.add(s.getSuspect());
			}
		}
		for(RoomCards r : RoomCards.values()) {
			if(!solution.contains(r.getRoom())) {
				remainingCards.add(r.getRoom());
			}
		}
	};

	// returns the solution cards to be placed in the middle of the board
	public ArrayList<String> answerCards() {
		return solution;
	}
	
	public ArrayList<String> remainingCards(){
		return remainingCards;
	}
	
	// yet to be implemented
	public void setCards(int numPlayers) {
		ArrayList<String> rc = new ArrayList<String>(remainingCards);
		Collections.shuffle(rc);
		int k = numPlayers;
		for(int i=0;i<numPlayers;i++) {
			int x = (int) Math.floor(rc.size()/k);
			System.out.println(x);
			playerCards.add(new ArrayList<String>(rc.subList(0, x)));
			for(int j = 0;j<x;j++) {
				rc.remove(0);
			}
			k-=1;
		}
	}
	

	
	public ArrayList<ArrayList<String>> getPlayerCards(){
		return playerCards;
	}
	
	// main for testing the methods of this class
	public static void main(String[] args) {
		AllCards d = new AllCards();
		ArrayList<String> answer = d.answerCards();
		System.out.print("\nDisplaying the answer cards: \n");
		for(String a : answer) {
			System.out.println(a);
		}
		
		System.out.print("\nNow displaying the remaining cards: \n");
		ArrayList<String> remaining = d.remainingCards();
		for(String r : remaining) {
			System.out.println(r);
		}
		int numplayers = 3;
		d.setCards(numplayers);
		System.out.println("\nNow displaying distributed cards between "+numplayers+" players: \n");
		
		for(int i=0;i<numplayers;i++) {
			System.out.println("playerCards: " + d.getPlayerCards().get(i));
		}
		
	}
	
}
