package ie.ucd.cluedo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read in game board file, handles movement of players, printing board to console.
 * @author Sam & Darren
 */
public class CluedoBoard {
	private int boardWidth = 24;
	private int boardHeight = 24;
	private ArrayList<Player> players;
	private char[][] board = new char[boardWidth][boardHeight];
	File boardTextFile = new File("board.txt");

	public CluedoBoard(ArrayList<Player> players) {

		this.players = players;
		
		// TODO Find a nicer way to do this
		board[0]  = "┌----┐ S┌------┐S ┌----┐".toCharArray();
		board[1]  = "|=   |  |      |  |   =|".toCharArray();
		board[2]  = "|    |  | Ball |  E Con|".toCharArray();
		board[3]  = "|Kit |  |      |  └----┘".toCharArray();
		board[4]  = "|    |  E      E       S".toCharArray();
		board[5]  = "└---E┘  |      |        ".toCharArray();
		board[6]  = "        └E----E┘        ".toCharArray();
		board[7]  = "                  ┌----┐".toCharArray();
		board[8]  = "┌------┐          E    |".toCharArray();
		board[9]  = "|      |  ┌---┐   |    |".toCharArray();
		board[10] = "|      |  |   |   |Bill|".toCharArray();
		board[11] = "|      E  |   |   └---E┘".toCharArray();
		board[12] = "|Dining|  |   |         ".toCharArray();
		board[13] = "|      |  |   |  ┌--E--┐".toCharArray();
		board[14] = "└-----E┘  |   |  |     |".toCharArray();
		board[15] = "          └---┘  E     |".toCharArray();
		board[16] = "S                | Lib |".toCharArray();
		board[17] = "        ┌-EE-┐   └-----┘".toCharArray();
		board[18] = "┌----┐  |    |         S".toCharArray();
		board[19] = "|    E  |    E          ".toCharArray();
		board[20] = "|Loun|  |    |   ┌-----┐".toCharArray();
		board[21] = "|    |  |Hall|   E  Stu|".toCharArray();
		board[22] = "|=   |  |    |   |    =|".toCharArray();
		board[23] = "└----┘S └----┘   └-----┘".toCharArray();
	}

	public void initialiseBoard() {
		int x = 0;
		int numPlayers = players.size();
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && board[i][j] == 'S') {
					board[i][j] = (char) Character.toUpperCase(players.get(x).getName().charAt(0));
					players.get(x).setLocation(i, j);

					numPlayers--;
					x++;
				} else if (numPlayers == 0
						&& (board[i][j] == 'S' && (i == 0 || i == boardWidth - 1 || j == 0 || j == boardHeight - 1))) {
					board[i][j] = ' ';
				}
			}
		}
	}

	public void printBoard() {
		System.out.println("\n\n--------------------------------------------------------------");
		for (int i = 0; i < boardWidth; i++) {
			System.out.print(board[i]);
			System.out.println();
		}
		System.out.println();
	}

	public void playerMove(Player p) throws IOException {
//		System.out.println(p.getName() + "'s location: [" + p.getLocation()[0] + "," + p.getLocation()[1] + "]");
		printBoard();
		Turn move = new Turn(p, this, players);
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public void setBoard(char[][] inputboard){
		board = inputboard;
	}
	
	
	// Temporary code to test CluedoBoard class
//	public static void main(String[] args) throws IOException {
//		PlayerSetup setup = new PlayerSetup();
//		setup.setupPlayers();
//		ArrayList<Player> players = setup.getPlayers();
//		CluedoBoard myBoard = new CluedoBoard();
//		myBoard.initialiseBoard(players);
//		myBoard.printBoard();
//		myBoard.playerMove(players.get(0));
//		myBoard.printBoard();
//	}

}
