package ie.ucd.cluedo.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddPlayersTest {

	String[] playerList = {"Anthony", "Bob", "Chris", "Declan", "Eoin"};
	
	@Test
	public void test() {
		
		if(playerList.length != 5) {
			fail("Expented number of players incorrect.");
		} else if(!playerList[0].equalsIgnoreCase("anthony")) {
			fail("Expected players not present");
		} 
	}
}
