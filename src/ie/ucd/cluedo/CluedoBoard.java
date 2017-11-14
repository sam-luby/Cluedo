package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CluedoBoard {

	final int boardWidth = 24;
	final int boardHeight = 24;
	char[][] inputBoard = new char[boardWidth][boardHeight];
	File boardTextFile = new File("boardNew.txt");

	public CluedoBoard() throws FileNotFoundException {
		Scanner scanner = new Scanner(boardTextFile);
		for (int row = 0; scanner.hasNextLine() && row < boardWidth; row++) {
			inputBoard[row] = scanner.nextLine().toCharArray();
		}
		scanner.close();
	}

	private void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < inputBoard[i].length; j++) {
				System.out.print(inputBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.printBoard();
	}

}
