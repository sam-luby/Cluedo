package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.ucd.cluedo.Dice;

public class DiceTest{

	private Dice d = new Dice();
	
	
	@Test
	public void testRoll() {
		int num = d.roll();
		assertTrue(num>2 && num<12);
	}

}
