package ie.ucd.cluedo;

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
