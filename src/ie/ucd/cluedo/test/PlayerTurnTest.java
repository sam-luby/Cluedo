package ie.ucd.cluedo.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.Player;
import ie.ucd.cluedo.PlayerTurn;

public class PlayerTurnTest {
	ArrayList<String> cards;
	Player testPlayer;
	int[] location = {10,10};
	PlayerTurn testTurn;
		
	
	@Before
	public void setUp() {
		cards = new ArrayList<String>(Arrays.asList("Card1", "Card2", "Card3"));
		testPlayer = new Player("Sam", "Reverend Green", cards);
		testTurn = new PlayerTurn(testPlayer, location);
	}
	
	@Test
	public void movesTest() {
		int movesBeforeDecrement = testTurn.getMoves();
		testTurn.decrememntMoves();
		int movesAfterDecrement = testTurn.getMoves();
		assertTrue(movesAfterDecrement == movesBeforeDecrement - 1);
	}
	
	@Test
	public void getPlayerChoiceTest() {
		Player playerInCorridor = new Player("Darren", "Mrs. White", cards);
		Player playerInPassageRoom = new Player("Kevin", "Miss Scarlet", cards);
		Player playerInNormalRoom = new Player("Chris", "Colonel Mustard", cards);

		int choice = givePlayerChoice(playerInCorridor, "Corridor");
		assertEquals("Player in corridor given incorrect choices",choice, 2);
		
		choice = givePlayerChoice(playerInPassageRoom, "Study");
		assertEquals("Player in study given incorrect choices", choice, 4);
		
		choice = givePlayerChoice(playerInNormalRoom, "Ballroom");
		assertEquals("Player in lounge given incorrect choices", choice, 3);
	}

	@Test
	public void testEndTurn() {
		int moves = testTurn.getMoves();
		testTurn.endTurn();
		assertEquals(0, testTurn.getMoves());
	}
	
	// Refactored the "getPlayerChoice" in the PlayerTurn class method here since we use scanners in the PlayerTurn class.	
	public int givePlayerChoice(Player p, String playerLocation) {
		int numberOfChoices;
		if (playerLocation.equalsIgnoreCase("Kitchen") || playerLocation.equalsIgnoreCase("Conservatory") || playerLocation.equalsIgnoreCase("Lounge") || playerLocation.equalsIgnoreCase("Study")) {
			numberOfChoices = 4;
		} else if (!playerLocation.equalsIgnoreCase("Corridor")) {
			numberOfChoices = 3;
		} else {
			numberOfChoices = 2;
		}
		return numberOfChoices;
	}
	
	@After
	public void tearDown() {
		Player playerInCorridor = null;
		Player playerInPassageRoom = null;
		Player playerInNormalRoom = null;
		ArrayList<String> cards = null;
		Player testPlayer = null;
		int[] location = null;
		PlayerTurn testTurn = null;
		cards = null;
		testPlayer = null;
		testTurn = null;
	}
	
}
