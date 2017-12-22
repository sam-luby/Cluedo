package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.Cluedo;
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
		if(!Cluedo.demoMode) {
			assertTrue(num>1 && num<13);
		} 
	}

	@After
    public void tearDown() {
    	d = null;
    }
}
