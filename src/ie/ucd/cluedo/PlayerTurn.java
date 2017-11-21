package ie.ucd.cluedo;

/**
 * While game is in motion, each player will keep being assigned a new turn in which they can move around the board.
 * A random dice roll determines how many moves the player gets for the turn
 * @author Sam
 */
public class PlayerTurn {
	private Player player;
	private int[] location;
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
}
