package ie.ucd.cluedo;

import java.util.ArrayList;

public class DistributeCards {
	
	private ArrayList<String> player1;
	private ArrayList<String> player2;
	private ArrayList<String> player3;
	private ArrayList<String> player4;
	private ArrayList<String> player5;
	private ArrayList<String> player6;
	private static ArrayList<String> solution = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	public DistributeCards() {
		solution.add(WeaponCards.random().getWeapon());
		solution.add(SuspectCards.random().getSuspect());
		solution.add(RoomCards.random().getRoom());
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
		return remainingCards;
	}
	
	// yet to be implemented
//	public void setCards(int numPlayers) {
//		
//	}
	
	
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
	}
	
}
