package ie.ucd.cluedo;

import ie.ucd.cluedo.enums.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Distribute cards amongst players
 * @author Darren
 */
public class AllCards {
	
	private ArrayList<ArrayList<String>> playerCards = new ArrayList<ArrayList<String>>();
	private static ArrayList<String> solutionCards = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	public AllCards() {
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

	// returns the solution cards to be placed in the middle of the board
	public ArrayList<String> answerCards() {
		return solutionCards;
	}
	
	public ArrayList<String> remainingCards(){
		return remainingCards;
	}
	
	//Distributed the cards among the players.
	public void distributeCards(int numPlayers) {
		ArrayList<String> rc = new ArrayList<String>(remainingCards);
		Collections.shuffle(rc);
		int k = numPlayers;
		for(int i=0; i<numPlayers; i++) {
			int x = (int) Math.floor(rc.size()/k);
			playerCards.add(new ArrayList<String>(rc.subList(0, x)));
			for(int j=0; j<x; j++) {
				rc.remove(0);
			}
			k-=1;
		}
	}
	
	public ArrayList<ArrayList<String>> getPlayerCards(){
		return playerCards;
	}
	
	//Temporary main method for testing AllCards class
	public static void main(String[] args) {
		
		System.out.println("How many players are going to play? [3-6]");
		Scanner numberOfPlayersScanner = new Scanner(System.in);
		int numPlayers = numberOfPlayersScanner.nextInt();
		numberOfPlayersScanner.close();
		
		AllCards cards = new AllCards();
		ArrayList<String> answerCards = cards.answerCards();
		System.out.print("\nDisplaying the answer cards: \n");
		for(String a : answerCards) {
			System.out.println(a);
		}
		
		System.out.print("\nNow displaying the remaining cards: \n");
		ArrayList<String> remainingCards = cards.remainingCards();
		for(String r : remainingCards) {
			System.out.println(r);
		}
		
		cards.distributeCards(numPlayers);
		System.out.println("\nNow displaying distributed cards between "+numPlayers+" players: \n");
		
		for(int i=0;i<numPlayers;i++) {
			System.out.println("Player " + (i+1) + " cards: "  + cards.getPlayerCards().get(i));
		}
		
	}
	
}
