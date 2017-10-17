package ie.ucd.cluedo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SuspectCards extends Cards {
	private static String[] names = {"Miss Scarlett", "Professor Plum", "Mrs. Peacock", "Reverend Mr Green", "Colonel Mustard", "Mrs White"};
	
	public SuspectCards() {
	}
	
	
	private static String[] shuffleCards(String[] cards)
	{
	    int index;
		String temp;
	    Random random = new Random();
	    for (int i = cards.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = cards[index];
	        cards[index] = cards[i];
	        cards[i] = temp;
	    }
	    return cards;
	}
	
	public static void main(String[] args) {
		
		SuspectCards x = new SuspectCards();
		String[] y = x.names;
		
		y = shuffleCards(y);
		for(int i = 0; i < names.length; i++) {
			System.out.println(y[i]);
		}
	}
	
}
