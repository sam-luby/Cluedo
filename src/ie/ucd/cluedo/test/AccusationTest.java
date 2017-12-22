package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ie.ucd.cluedo.Accusation;
import ie.ucd.cluedo.Cluedo;
import ie.ucd.cluedo.Hypothesis;
import ie.ucd.cluedo.Player;

public class AccusationTest {
	ArrayList<String> samCards = new ArrayList<String>(Arrays.asList("Bomb", "Knife", "Mrs. Scarlet", "Library", "Study", "Kitchen"));
	Player sam = new Player("Sam", "Miss Scarlet", samCards);

    ArrayList<String> darrenCards = new ArrayList<String>(Arrays.asList("Ballroom", "Colonel Mustard", "Chainsaw", "Drugs", "Professor Plum", "Dining room"));
    Player darren = new Player("Darren", "Reverend Mr. Green", darrenCards);

    ArrayList<String> kevinCards = new ArrayList<String>(Arrays.asList("Baseball bat", "Hammer", "Mrs. White", "Mrs. Peacock", "Lounge", "Conservatory", "Billiard room"));
    Player kevin = new Player("Kevin", "Colonel Mustard", kevinCards);
    
    ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(sam, darren, kevin));

    Accusation accusation = new Accusation(sam, players);
    accusation.setAccusationCards("Knife", "Mrs. White", "Study");

}
