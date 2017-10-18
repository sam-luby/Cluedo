package ie.ucd.cluedo;
import java.util.Random;

public class Cards {


	
	protected static String[] shuffleCards(String[] cards)
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
	
	
}
