package ie.ucd.cluedo;
import java.util.Random;

public class Cards {

	public static String[] shuffleCards(String[] cards)
	{
	    int index;
		String temp;
		String[] shuffledCards = cards.clone();
	    Random random = new Random();
	    for (int i = shuffledCards.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = shuffledCards[index];
	        shuffledCards[index] = shuffledCards[i];
	        shuffledCards[i] = temp;
	    }
	    return shuffledCards;
	}

}
