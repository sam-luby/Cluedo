package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CluedoBoard {

	private int boardWidth;
	private int boardHeight;
	private char[][] inputBoard;
	private char[][] initialiseBoard;
	File boardTextFile = new File("boardNew.txt");

	public CluedoBoard() throws FileNotFoundException {
		Scanner sc = new Scanner(boardTextFile);
		boardWidth = sc.nextLine().length() - 1;
		Scanner scan = new Scanner(boardTextFile);
		while (scan.hasNextLine()) {
			boardHeight++;
			scan.nextLine();
		}

		inputBoard = new char[boardWidth][boardHeight];
		initialiseBoard = new char[boardWidth][boardHeight];
		Scanner scanner = new Scanner(boardTextFile);
		for (int row = 0; scanner.hasNextLine() && row < boardWidth; row++) {
			inputBoard[row] = scanner.nextLine().toCharArray();
		}
		scanner.close();
	}

	private void initialiseBoard(int numPlayers, String[] names) {
		int x = 0;
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && inputBoard[i][j] == 'S') {
					initialiseBoard[i][j] = Character.toUpperCase(names[x].charAt(0));
					numPlayers--;
					x++;
				} else if (numPlayers == 0 && (inputBoard[i][j] == 'S'
						&& (i == 0 || i == boardWidth - 1 || j == 0 || j == boardHeight - 1))) {
					initialiseBoard[i][j] = ' ';
				} else {
					initialiseBoard[i][j] = inputBoard[i][j];
				}
			}
		}
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < initialiseBoard[i].length; j++) {
				System.out.print(initialiseBoard[i][j]);
			}
			System.out.println();
		}
	}

	private void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				System.out.print(inputBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		PlayerSetup setupPlayers = new PlayerSetup();
		ArrayList<Player> players = new ArrayList<Player>();
		players = setupPlayers.setupPlayers();
		
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.initialiseBoard(players.size(), setupPlayers.getPlayers());
//		 System.out.println();
//		 myBoard.printBoard();
	}

}
