package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CluedoBoard {
	private int boardWidth;
	private int boardHeight;
	private char[][] inputBoard;
	private char[][] board;
	File boardTextFile = new File("boardNew.txt");

	public CluedoBoard() throws FileNotFoundException {
		Scanner sc = new Scanner(boardTextFile);
		boardWidth = sc.nextLine().length() - 1;
		sc.close();
		Scanner scan = new Scanner(boardTextFile);
		while (scan.hasNextLine()) {
			boardHeight++;
			scan.nextLine();
		}
		scan.close();

		inputBoard = new char[boardWidth][boardHeight];
		board = new char[boardWidth][boardHeight];
		Scanner scanner = new Scanner(boardTextFile);
		for (int row = 0; scanner.hasNextLine() && row < boardWidth; row++) {
			inputBoard[row] = scanner.nextLine().toCharArray();
		}
		scanner.close();
	}

	private void initialiseBoard(ArrayList<Player> players) {
		int x = 0;
		int numPlayers = players.size();
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && inputBoard[i][j] == 'S') {
					board[i][j] = Character.toUpperCase(players.get(x).getName().charAt(0));
					System.out.println(i + " " + j);
					players.get(x).setLocation(i, j);
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

	private void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		PlayerSetup setup = new PlayerSetup();
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.initialiseBoard(players);
		
		myBoard.printBoard();
	}

}
