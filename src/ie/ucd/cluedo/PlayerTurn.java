package ie.ucd.cluedo;

import java.util.Scanner;

/**
 * While game is in motion, each player will keep being assigned a new turn in which they can move around the board.
 * A random dice roll determines how many moves the player gets for the turn
 * @author Sam
 */
public class PlayerTurn {
	Player player;
	int[] location;
	private Dice dice;
	private int moves;
	
	public PlayerTurn(Player player, int[] location) {
		this.player = player;
		this.location = location;
		dice = new Dice();
		this.moves = dice.roll();
	}
	
	public int getMoves() {
		return moves;
	}
	
	public void decrememntMoves() {
		moves--;
	}
	
	//Gives player a number of choices based on where they are on the board
	public static int getPlayerChoice(Player p, String playerLocation) {
		if (playerLocation.equalsIgnoreCase("Kitchen") || playerLocation.equalsIgnoreCase("Conservatory") || playerLocation.equalsIgnoreCase("Lounge") || playerLocation.equalsIgnoreCase("Study")) {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
			System.out.println("Make hypothesis [2]:");
			System.out.println("Use secret passage [3]:");
		} else if (!playerLocation.equalsIgnoreCase("Corridor")) {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
			System.out.println("Make hypothesis [2]:");
		} else {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
		}

		Scanner newScan = new Scanner(System.in);
		while (!newScan.hasNextInt()) {
			System.out.println("Make a valid decision: ");
			newScan.next();
		}
		int choice = newScan.nextInt();
		return choice;
	}
	
	// Simple way to end their turn is just set the turns to 0 
	public void endTurn() {
		moves = 0;
	}
	
}
