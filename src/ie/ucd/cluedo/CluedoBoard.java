package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read in game board file, handles movement of players, printing board to console.
 * @author Sam & Darren
 */
public class CluedoBoard {
	private static int boardWidth = 24;
	private static int boardHeight = 24;
	private ArrayList<Player> players;
	public static char[][] board = new char[boardHeight][boardWidth];

	//Creates a Cluedoboard object by reading in from a text file
	public CluedoBoard(ArrayList<Player> players) {
		this.players = players;
		File file = new File("board.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

	//Puts the player icons (first letter of their name) on the board
	public void initialisePlayerLocations() {
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

	//Outputs the board to the console
	public void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			System.out.println(board[i]);
		}
		System.out.println();
	}

	
	public void playerMove(Player p) throws IOException {
		printBoard();
		Movement move = new Movement(p, this, players);
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public void setBoard(char[][] inputboard){
		board = inputboard;
	}
	
}
