package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.Collections;

public class DistributeCards {
	
	private ArrayList<String> player1 = new ArrayList<String>();
	private ArrayList<String> player2 = new ArrayList<String>();
	private ArrayList<String> player3 = new ArrayList<String>();
	private ArrayList<String> player4 = new ArrayList<String>();
	private ArrayList<String> player5 = new ArrayList<String>();
	private ArrayList<String> player6 = new ArrayList<String>();
	private static ArrayList<String> solution = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	public DistributeCards() {
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
	
	// yet to be implemented, may not be needed
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
				player1.add(remainingCards.get(i));
				player2.add(remainingCards.get(i+6));
				player3.add(remainingCards.get(i+12));
			}
		}
		if(numPlayers==4) {
			for(int i=0;i<4;i++) {
				player1.add(remainingCards.get(i));
				player2.add(remainingCards.get(i+4));
				player3.add(remainingCards.get(i+8));
				player4.add(remainingCards.get(i+12));
			}
			player1.add(remainingCards.get(16));
			player2.add(remainingCards.get(17));
		}
		if(numPlayers==5) {
			for(int i=0;i<3;i++) {
				player1.add(remainingCards.get(i));
				player2.add(remainingCards.get(i+3));
				player3.add(remainingCards.get(i+6));
				player4.add(remainingCards.get(i+9));
				player5.add(remainingCards.get(i+12));
			}
			player1.add(remainingCards.get(15));
			player2.add(remainingCards.get(16));
			player3.add(remainingCards.get(17));
		}
		if(numPlayers==6) {
			for(int i=0;i<3;i++) {
				player1.add(remainingCards.get(i));
				player2.add(remainingCards.get(i+3));
				player3.add(remainingCards.get(i+6));
				player4.add(remainingCards.get(i+9));
				player5.add(remainingCards.get(i+12));
				player6.add(remainingCards.get(i+15));
			}
		}
	}
	
	public ArrayList<String> getPlayer1(){
		return player1;
	}
	
	public ArrayList<String> getPlayer2(){
		return player2;
	}
	
	public ArrayList<String> getPlayer3(){
		return player3;
	}
	
	public ArrayList<String> getPlayer4(){
		return player4;
	}
	
	public ArrayList<String> getPlayer5(){
		return player5;
	}
	
	public ArrayList<String> getPlayer6(){
		return player6;
	}
	
	
	// main for testing the methods of this class
	public static void main(String[] args) {
		DistributeCards d = new DistributeCards();
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
		System.out.println("Player1: " + d.getPlayer1());
		System.out.println("Player2: " + d.getPlayer2());
		System.out.println("Player3: " + d.getPlayer3());
		System.out.println("Player4: " + d.getPlayer4());
		System.out.println("Player5: " + d.getPlayer5());
	}
	
}
