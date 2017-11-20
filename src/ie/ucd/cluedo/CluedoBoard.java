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
	private int boardWidth;
	private int boardHeight;
	private char[][] inputBoard;
	private char[][] board;
	File boardTextFile = new File("board.txt");

	public CluedoBoard() throws FileNotFoundException {
		Scanner sc = new Scanner(boardTextFile);
		boardWidth = sc.nextLine().length() -1;
		
		Scanner scan = new Scanner(boardTextFile);
		while (scan.hasNextLine()) {
			boardHeight++;
			scan.nextLine();
		}

		inputBoard = new char[boardWidth][boardHeight];
		board = new char[boardWidth][boardHeight];
		Scanner scanner = new Scanner(boardTextFile);
		for (int row = 0; scanner.hasNextLine() && row < boardWidth; row++) {
			inputBoard[row] = scanner.nextLine().toCharArray();
		}
		sc.close();
		scan.close();
		scanner.close();
	}

	void initialiseBoard(ArrayList<Player> players) {
		int x = 0;
		int numPlayers = players.size();
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && inputBoard[i][j] == 'S') {
					board[i][j] = Character.toUpperCase(players.get(x).getName().charAt(0));
					players.get(x).setLocation(i, j);
					
					//Test
					System.out.println(Arrays.toString(players.get(x).getLocation()));
					numPlayers--;
					x++;
				} else if (numPlayers == 0 && (inputBoard[i][j] == 'S'
						&& (i == 0 || i == boardWidth - 1 || j == 0 || j == boardHeight - 1))) {
					board[i][j] = ' ';
				} else {
					board[i][j] = inputBoard[i][j];
				}
			}
		}
	}

	void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void movePlayer(Player p) {
		int[] location = p.getLocation();
		System.out.println(p.getName() +"'s location: [" + p.getLocation()[0] + "," + p.getLocation()[1] + "]");
		
		PlayerTurn turn = new PlayerTurn(p, location);
		int moves = turn.getMoves();
		Scanner newScan = new Scanner(System.in);
		
		while(moves > 0) {
			String move = null;
			System.out.println(moves + " move(s) remaining...");
			System.out.println("Give a direction [W,A,S,D]:");
			move = newScan.nextLine();
			
			
			switch(move) {
				case "S" :
					//TODO Fix this bug
//					if(board[p.getLocation()[0]+1][p.getLocation()[1]] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] + 1, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
//					}
					break;
				case "D" :
					if(board[p.getLocation()[0]][p.getLocation()[1]+1] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] + 1);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
					}
					break;
				case "A" :
					if(board[p.getLocation()[0]][p.getLocation()[1]-1] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] - 1);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
					}
					break;
				case "W" :
					if(board[p.getLocation()[0]-1][p.getLocation()[1]] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] - 1, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
					}
					break;
				default :
					System.out.println("Enter a valid character [W,A,S,D]:");
			}

			printBoard();
			turn.decrememntMoves();	
			moves = turn.getMoves();
		}
		newScan.close();
		System.out.println("TURN OVER\n\n");
	}
	
	
	//Temporary code to test CluedoBoard class
	public static void main(String[] args) throws IOException {
		PlayerSetup setup = new PlayerSetup();
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.initialiseBoard(players);
		myBoard.printBoard();
		
		myBoard.movePlayer(players.get(0));
		myBoard.printBoard();
	}

}
