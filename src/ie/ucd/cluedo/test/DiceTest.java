package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.Dice;

public class DiceTest{

	private Dice d;
	
	@Before
	public void setUp() {
		d = new Dice();
	}
	
	@Test
	public void testRoll() {
		int num = d.roll();
		assertTrue(num>1 && num<13);
	}

}
