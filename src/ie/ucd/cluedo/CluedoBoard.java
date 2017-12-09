package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Read in game board file, handles movement of players, printing board to console.
 * @author Sam & Darren
 */
public class CluedoBoard {
	private int boardWidth = 24;
	private int boardHeight = 24;
	private ArrayList<Player> players;
	private char[][] board = new char[boardHeight][boardWidth];
	File boardTextFile = new File("board.txt");

	public CluedoBoard(ArrayList<Player> players) throws FileNotFoundException {

		this.players = players;
		File file = new File("board.txt");
		Scanner scanner = new Scanner(file);
		int i = 0;
		while(scanner.hasNextLine()) {
			board[i] = scanner.nextLine().toCharArray();
			i++;
        }
        scanner.close();
        
        // Fixes error in first line by shifting to the left, works but has extra character in the [0][24] position
        System.arraycopy(board[0], 1, board[0], 0, 24);  
        board[0][24] = ' ';
        
	}

	public void initialiseBoard() {
		int x = 0;
		int numPlayers = players.size();
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && board[i][j] == 'S') {
					//TODO could give players numbers 1, 2, 3, 4, 5, 6 as icons instead of first letter of name 
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
		Movement move = new Movement(p, this, players);
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
