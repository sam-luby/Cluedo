package ie.ucd.cluedo;

import java.util.ArrayList;

public class Accusation {
	
	private Player player;
	private ArrayList<Player> players;
	private static ArrayList<String> answerCards;
	
	
	public Accusation(Player p, ArrayList<Player> players) {
		this.player = p;
		this.players = players;
	}
	

	public static void main(String[] args) {
		Cards cards = new Cards();
		answerCards = cards.getAnswerCards();
		
		for(String s : answerCards) {
			System.out.println(s);
		}
	}
	
}
