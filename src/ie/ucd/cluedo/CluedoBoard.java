package ie.ucd.cluedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CluedoBoard {

	// Board size is 26 x 27
	String[][] inputBoard = new String[26][27];
	String[][] outputBoard = new String[26][27];

	public CluedoBoard() throws FileNotFoundException {
		Scanner scanner = null;
		scanner = new Scanner(new File("./board.csv"));
		scanner.useDelimiter(",");
		for (int j = 0; j < 27; j++) {
			for (int i = 0; i < 26; i++) {
				inputBoard[i][j] = scanner.next();
//				System.out.print(inputBoard[i][j]);
			}
		}
		scanner.close();
	}
	
//	public void printBoard() {
//		outputBoard = inputBoard;
//		for (int j = 0; j < 27; j++) {
//			for (int i = 0; i < 26; i++) {
//				if(inputBoard[i][j].equalsIgnoreCase("W")) {
//					outputBoard[i][j] = "*";
//				}
//				System.out.print(outputBoard[i][j]);
//			}
//		}
//	}
	
	
	public boolean canWalkOn(String s) {
		if(s == "#" || s.startsWith("e")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		CluedoBoard myBoard = new CluedoBoard();
//		myBoard.printBoard();
	}

}
