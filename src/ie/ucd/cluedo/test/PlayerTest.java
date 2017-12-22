package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.CluedoBoard;
import ie.ucd.cluedo.Player;

public class PlayerTest {
	
	private Player sam;
	private String samName;
	private String samPawn;
	private ArrayList<String> samCards;

	@Before
	public void setUp() {
		samName = "Sam";
		samPawn = "Mrs. Scarlet";
		samCards = new ArrayList<String>(Arrays.asList("Bomb", "Knife", "Mrs. Scarlet", "Library", "Study", "Kitchen"));
		
		sam = new Player(samName, samPawn, samCards); 
	}

	@Test
	public void testGetCards() {
		ArrayList<String> testCards = sam.getCards();
		assertEquals(testCards, samCards);
	}
	
	@Test
	public void testSetLocation() {
		sam.setLocation(0, 1);
		int[] loc = new int[2];
		loc[0] = 0;
		loc[1] = 1;
		assertEquals(loc[0], sam.getLocation()[0]);
		assertEquals(loc[1], sam.getLocation()[1]);
	}
	
	@After
    public void tearDown() {
		samName = null;
		samPawn = null;
		samCards = null;
		
		sam = null;
    }
	
}
