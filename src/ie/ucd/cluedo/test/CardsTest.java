package ie.ucd.cluedo.test;

import ie.ucd.cluedo.Cards;
import ie.ucd.cluedo.RoomCards;
import ie.ucd.cluedo.SuspectCards;
import ie.ucd.cluedo.WeaponCards;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CardsTest extends Cards{

	String[] suspects = SuspectCards.getCards();
	String[] rooms = RoomCards.getCards();
	String[] weapons = WeaponCards.getCards();
	
	
	@Test
	public void testShuffling() {
		String[] shuffledSuspects = shuffleCards(suspects);
		String[] shuffledWeapons = shuffleCards(weapons);
		String[] shuffledRooms = shuffleCards(rooms);
		
		if(Arrays.equals(shuffledSuspects, suspects)) {
			fail("Not shuffled");
		} else if(Arrays.equals(shuffledWeapons, weapons)) {
			fail("Not shuffled");
		} else if(Arrays.equals(shuffledRooms, rooms)) {
			fail("Not shuffled");
		}
	}
}
