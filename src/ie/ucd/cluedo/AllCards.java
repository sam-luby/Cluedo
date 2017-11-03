package ie.ucd.cluedo;

import ie.ucd.cluedo.enums.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Distribute cards amongst players
 * @author Darren
 */
public class AllCards {
	
	//TODO Probably a better way to implement some of the replicated code in this class
	//TODO Create arraylist of arrayList
	private ArrayList<String> player1Cards = new ArrayList<String>();
	private ArrayList<String> player2Cards = new ArrayList<String>();
	private ArrayList<String> player3Cards = new ArrayList<String>();
	private ArrayList<String> player4Cards = new ArrayList<String>();
	private ArrayList<String> player5Cards = new ArrayList<String>();
	private ArrayList<String> player6Cards = new ArrayList<String>();
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
	
	//TODO yet to be implemented, may not be needed
//	public ArrayList<String> allCards(){
//		return allCards;
//	}

	// returns the solution cards to be placed in the middle of the board
	public ArrayList<String> answerCards() {
		return solution;
	}
	
	public ArrayList<String> remainingCards(){
		return remainingCards;
	}
	
	// yet to be implemented
	public void setCards(int numPlayers) {
		Collections.shuffle(remainingCards);
		if(numPlayers==3) {
			for(int i=0;i<6;i++) {
				player1Cards.add(remainingCards.get(i));
				player2Cards.add(remainingCards.get(i+6));
				player3Cards.add(remainingCards.get(i+12));
			}
		}
		if(numPlayers==4) {
			for(int i=0;i<4;i++) {
				player1Cards.add(remainingCards.get(i));
				player2Cards.add(remainingCards.get(i+4));
				player3Cards.add(remainingCards.get(i+8));
				player4Cards.add(remainingCards.get(i+12));
			}
			player1Cards.add(remainingCards.get(16));
			player2Cards.add(remainingCards.get(17));
		}
		if(numPlayers==5) {
			for(int i=0;i<3;i++) {
				player1Cards.add(remainingCards.get(i));
				player2Cards.add(remainingCards.get(i+3));
				player3Cards.add(remainingCards.get(i+6));
				player4Cards.add(remainingCards.get(i+9));
				player5Cards.add(remainingCards.get(i+12));
			}
			player1Cards.add(remainingCards.get(15));
			player2Cards.add(remainingCards.get(16));
			player3Cards.add(remainingCards.get(17));
		}
		if(numPlayers==6) {
			for(int i=0;i<3;i++) {
				player1Cards.add(remainingCards.get(i));
				player2Cards.add(remainingCards.get(i+3));
				player3Cards.add(remainingCards.get(i+6));
				player4Cards.add(remainingCards.get(i+9));
				player5Cards.add(remainingCards.get(i+12));
				player6Cards.add(remainingCards.get(i+15));
			}
		}
	}
	
	public ArrayList<String> getplayer1Cards(){
		return player1Cards;
	}
	
	public ArrayList<String> getplayer2Cards(){
		return player2Cards;
	}
	
	public ArrayList<String> getplayer3Cards(){
		return player3Cards;
	}
	
	public ArrayList<String> getplayer4Cards(){
		return player4Cards;
	}
	
	public ArrayList<String> getplayer5Cards(){
		return player5Cards;
	}
	
	public ArrayList<String> getplayer6Cards(){
		return player6Cards;
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
		int numplayers = 5;
		d.setCards(numplayers);
		System.out.println("\nNow displaying distributed cards between "+numplayers+" players: \n");
		System.out.println("player1Cards: " + d.getplayer1Cards());
		System.out.println("player2Cards: " + d.getplayer2Cards());
		System.out.println("player3Cards: " + d.getplayer3Cards());
		System.out.println("player4Cards: " + d.getplayer4Cards());
		System.out.println("player5Cards: " + d.getplayer5Cards());
	}
	
}
