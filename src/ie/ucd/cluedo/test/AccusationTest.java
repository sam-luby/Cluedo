package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.Accusation;
import ie.ucd.cluedo.Cluedo;
import ie.ucd.cluedo.Hypothesis;
import ie.ucd.cluedo.Notebook;
import ie.ucd.cluedo.Player;

public class AccusationTest {
	ArrayList<String> samCards;
	ArrayList<String> darrenCards;
	ArrayList<String> kevinCards;
	Player sam;
	Player darren;
	Player kevin;
	ArrayList<Player> players;
	Accusation accusation;
	ArrayList<String> answerCards;
	
	@Before
	public void setUp() {
		samCards = new ArrayList<String>(Arrays.asList("Bomb", "Knife", "Mrs. Scarlet", "Library", "Study", "Kitchen"));
		sam = new Player("Sam", "Miss Scarlet", samCards);
	    darrenCards = new ArrayList<String>(Arrays.asList("Ballroom", "Colonel Mustard", "Chainsaw", "Drugs", "Professor Plum", "Dining room"));
	    darren = new Player("Darren", "Reverend Mr. Green", darrenCards);
	    kevinCards = new ArrayList<String>(Arrays.asList("Baseball bat", "Hammer", "Mrs. White", "Mrs. Peacock", "Lounge", "Conservatory", "Billiard room"));
	    kevin = new Player("Kevin", "Colonel Mustard", kevinCards);

	    players = new ArrayList<Player>(Arrays.asList(sam, darren, kevin));
	    accusation = new Accusation(sam, players);
	    answerCards = accusation.getAnswerCards();
	}
	    
    //Tests a correct accusation
    @Test
    public void testPositiveCheckAccusation() {
        String answerWeapon = answerCards.get(0);
        String answerSuspect = answerCards.get(1);
        String answerRoom = answerCards.get(2);

        accusation.setAccusationCards(answerWeapon, answerSuspect, answerRoom);
        boolean check = checkAccusationRefactored();
        assertTrue(check);
    }
    
    //Tests an incorrect accusation
    @Test
    public void testNegativeCheckAccusation() {
    	String accusationWeapon;
    	
    	if(answerCards.get(0) == "Knife" ) {
    		accusationWeapon = "Bomb";
    	} else {
    		accusationWeapon = "Knife";
    	}
    	
    	accusation.setAccusationCards(accusationWeapon, "Mrs. White", "Study");
    	boolean check = checkAccusationRefactored();
    	assertFalse(check);
    }
    
    @After
    public void tearDown() {
    	samCards = null;
		sam = null;
	    darrenCards = null;
	    darren = null;
	    kevinCards = null;
	    kevin = null;

	    players = null;
	    accusation = null;
	    answerCards = null;
    }
    
    //Refactored "checkAccusation" method from Accusation class to avoid FileNotFound etc errors
    public boolean checkAccusationRefactored() {
    	String weapon = Accusation.weaponAccusation;
    	String suspect = Accusation.suspectAccusation;
    	String room = Accusation.roomAccusation;
    	ArrayList<String> answerCards = accusation.getAnswerCards();
    	
		if(!weapon.equals(answerCards.get(0)) || !suspect.equals(answerCards.get(1)) || !room.equals(answerCards.get(2))) {
			return false;
		} else {
			return true;
		}
	}

}
