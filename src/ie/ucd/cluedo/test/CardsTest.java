package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.Cards;
import ie.ucd.cluedo.enums.RoomCards;
import ie.ucd.cluedo.enums.SuspectCards;
import ie.ucd.cluedo.enums.WeaponCards;

public class CardsTest {
	Cards cards;
	WeaponCards weapon = WeaponCards.random();
	
	@Before
	public void setUp() {
		cards = Cards.getInstance();
	}
	
	@Test
	public void testGetWeaponCards() {
		ArrayList<String> weaponCards = cards.getWeaponCards();
		assertEquals(6, weaponCards.size());
		
		for(int i = 0; i < weaponCards.size(); i++) {
			String weapon = WeaponCards.random().getWeapon();
			assertTrue(weaponCards.contains(weapon.toString()));
		}
	}
	
	@Test
	public void testGetSuspectCards() {
		ArrayList<String> suspectCards = cards.getSuspectCards();
		assertEquals(6, suspectCards.size());
		
		for(int i = 0; i < suspectCards.size(); i++) {
			String suspect = SuspectCards.random().getSuspect();
			assertTrue(suspectCards.contains(suspect.toString()));
		}
	}
	
	@Test
	public void testGetRoomCards() {
		ArrayList<String> roomCards = cards.getRoomCards();
		assertEquals(9, roomCards.size());
		
		for(int i = 0; i < roomCards.size(); i++) {
			String room = RoomCards.random().getRoom();
			assertTrue(roomCards.contains(room.toString()));
		}
	}
	
	@Test
	public void testGetAllCards() {
		ArrayList<String> allCards = cards.getAllCards();
		assertEquals(21, allCards.size());
	}
	
	@Test
	public void testGetAnswerCards() {
		ArrayList<String> answerCards = cards.getAnswerCards();
		assertEquals(3, answerCards.size());
	}
	
	@After
    public void tearDown() {
    	cards = null;
    }
}
