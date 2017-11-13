package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CluedoBoard {

	// Board size is 26 x 27
	final int boardWidth = 24;
	final int boardHeight = 24;
	char[][] inputBoard = new char[boardWidth][boardHeight];
	char[][] outputBoard = new char[boardWidth][boardHeight];

	File boardTextFile = new File("board.txt");

	public CluedoBoard() throws FileNotFoundException {
		Scanner scanner = new Scanner(boardTextFile);
		for (int row = 0; scanner.hasNextLine() && row < boardWidth; row++) {
			inputBoard[row] = scanner.nextLine().toCharArray();
		}
		scanner.close();
	}

	public void makeBoardNice() {
		outputBoard = inputBoard;
		HashMap<Integer, Integer> locations = new HashMap<Integer, Integer>();

		for (int i = 1; i < boardWidth; i++) {
			for (int j = 1; j < boardHeight; j++) {
				// above
				if ((((outputBoard[i][j] != outputBoard[i - 1][j]   && outputBoard[i-1][j] != '-') || outputBoard[i][j] != outputBoard[i + 1][j]))
						|| (i == 0) || (i == boardHeight)) {
					outputBoard[i][j] = '-';
//					locations.put(i, j);
				}
			}
		}
		
//		 /* Display content using Iterator*/
//	      Set set = locations.entrySet();
//	      Iterator iterator = set.iterator();
//	      while(iterator.hasNext()) {
//	         Map.Entry mentry = (Map.Entry)iterator.next();
//	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//	         System.out.println(mentry.getValue());
//	      }


	}

	public void printBoard() {
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < outputBoard[i].length; j++) {
				System.out.print(outputBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.makeBoardNice();
		myBoard.printBoard();
	}

}
