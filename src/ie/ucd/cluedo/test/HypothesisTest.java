package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ie.ucd.cluedo.Hypothesis;
import ie.ucd.cluedo.Player;

public class HypothesisTest {

	String samName; 
	String darrenName;
	String kevinName;
	
	Player sam;
	Player darren;
	Player kevin;
	
	String room;
	
	Hypothesis hyp;
	String samPawn;
	String darrenPawn;
	String kevinPawn;
	ArrayList<String> samCards;
	ArrayList<String> darrenCards;
	ArrayList<String> kevinCards;
	ArrayList<Player> players;
	
	//Answer Cards
//	"Hammer"
//	"Reverend Mr. Green"
//	"Hall"
	
	public void setUp() throws IOException {
		samName = "Sam";
		samPawn = "Mrs. Scarlet";
		samCards = new ArrayList<String>(Arrays.asList("Bomb", "Knife", "Mrs. Scarlet", "Library", "Study", "Kitchen"));
		sam = new Player(samName, samPawn, samCards);
		
		darrenName = "Darren";
		darrenPawn = "Reverend Mr. Green";
		darrenCards = new ArrayList<String>(Arrays.asList("Ballroom", "Colonel Mustard", "Chainsaw", "Drugs", "Professor Plum", "Dining room"));
		darren = new Player(samName, darrenPawn, darrenCards);
		
		kevinName = "Kevin";
		kevinPawn = "Colonel Mustard";
		kevinCards = new ArrayList<String>(Arrays.asList("Baseball bat", "Hammer", "Mrs. White", "Mrs. Peacock", "Lounge", "Conservatory", "Billiard room"));
		kevin = new Player(samName, kevinPawn, kevinCards);
		
		players = new ArrayList<Player>(Arrays.asList(sam,darren,kevin));
		room = "Hall";
		
		hyp = new Hypothesis(sam, players, samPawn);
	}
}
	

