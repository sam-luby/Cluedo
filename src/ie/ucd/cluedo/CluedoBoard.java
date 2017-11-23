package ie.ucd.cluedo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Read in game board file, handles movement of players, printing board to
 * console.
 * 
 * @author Sam & Darren
 */
public class CluedoBoard {
	private int boardWidth = 24;
	private int boardHeight = 24;
	private char[][] board = new char[boardWidth][boardHeight];
	// private char[][] board;
	File boardTextFile = new File("board.txt");

	public CluedoBoard() {

		// TODO Find a nicer way to do this
		board[0] = "+----+ S+------+S +----+".toCharArray();
		board[1] = "|Kit |  |      |  |Con |".toCharArray();
		board[2] = "|    |  | Ball |  E    |".toCharArray();
		board[3] = "|    |  |      |  +----+".toCharArray();
		board[4] = "|    |  E      E       S".toCharArray();
		board[5] = "+---E+  |      |        ".toCharArray();
		board[6] = "        +E----E+        ".toCharArray();
		board[7] = "                  +----+".toCharArray();
		board[8] = "+------+          E    |".toCharArray();
		board[9] = "|      |  +---+   |    |".toCharArray();
		board[10] = "|      |  |   |   |Bill|".toCharArray();
		board[11] = "|      E  |   |   +---E+".toCharArray();
		board[12] = "|Dining|  |   |         ".toCharArray();
		board[13] = "|      |  |   |  +--E--+".toCharArray();
		board[14] = "+-----E+  |   |  |     |".toCharArray();
		board[15] = "          +---+  E     |".toCharArray();
		board[16] = "S                | Lib |".toCharArray();
		board[17] = "        +-EE-+   +-----+".toCharArray();
		board[18] = "+----+  |    |         S".toCharArray();
		board[19] = "|    E  |    E          ".toCharArray();
		board[20] = "|Loun|  |    |   +-----+".toCharArray();
		board[21] = "|    |  |Hall|   E     |".toCharArray();
		board[22] = "|    |  |    |   |Study|".toCharArray();
		board[23] = "+----+S +----+   +-----+".toCharArray();
	}

	void initialiseBoard(ArrayList<Player> players) {
		int x = 0;
		int numPlayers = players.size();
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (numPlayers != 0 && board[i][j] == 'S') {
					board[i][j] = (char) Character.toUpperCase(players.get(x).getName().charAt(0));
					players.get(x).setLocation(i, j);

					// Test
					//System.out.println(Arrays.toString(players.get(x).getLocation()));
					numPlayers--;
					x++;
				} else if (numPlayers == 0
						&& (board[i][j] == 'S' && (i == 0 || i == boardWidth - 1 || j == 0 || j == boardHeight - 1))) {
					board[i][j] = ' ';
				}
			}
		}
	}

	void printBoard() {
		System.out.println("\n\n--------------------------------------------------------------");
		for (int i = 0; i < boardWidth; i++) {
			System.out.print(board[i]);
			System.out.println();
		}
		System.out.println();
	}

	void movePlayer(Player p) {
		int[] location = p.getLocation();
		System.out.println(p.getName() + "'s location: [" + p.getLocation()[0] + "," + p.getLocation()[1] + "]");

		PlayerTurn turn = new PlayerTurn(p, location);
		int moves = turn.getMoves();

		Scanner newScan = new Scanner(System.in);

		while (moves > 0) {
			String direction = null;
			System.out.println(moves + " move(s) remaining...");
			System.out.println("Give a direction [W,A,S,D]:");
			direction = newScan.nextLine().toUpperCase();
			switch (direction) {

			// TODO Refactor code here for code reusability
			case "S":
				if (canMove(p, direction)) {
					if (board[p.getLocation()[0] + 1][p.getLocation()[1]] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] + 1, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					} else if (board[p.getLocation()[0] + 1][p.getLocation()[1]] == 'E') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] + 2, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					}
				}
				break;
			case "D":
				if (canMove(p, direction)) {
					if (board[p.getLocation()[0]][p.getLocation()[1] + 1] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] + 1);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					} else if (board[p.getLocation()[0]][p.getLocation()[1] + 1] == 'E') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] + 2);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					}
				}
				break;
			case "A":
				if (canMove(p, direction)) {
					if (board[p.getLocation()[0]][p.getLocation()[1] - 1] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] - 1);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					} else if (board[p.getLocation()[0]][p.getLocation()[1] - 1] == 'E') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0], p.getLocation()[1] - 2);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					}
				}
				break;
			case "W":
				if (canMove(p, direction)) {
					if (board[p.getLocation()[0] - 1][p.getLocation()[1]] == ' ') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] - 1, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					} else if (board[p.getLocation()[0] - 1][p.getLocation()[1]] == 'E') {
						board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
						p.setLocation(p.getLocation()[0] - 2, p.getLocation()[1]);
						board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
						turn.decrememntMoves();
					}
				}
				break;
			default:
				System.out.println("WARNNG: Enter a valid character [W,A,S,D]:");
			}

			printBoard();
			System.out.println(playerRoomLocation(p));
			moves = turn.getMoves();
		}
		System.out.println("--------------------------TURN OVER---------------------------\n\n");
	}

	boolean canMove(Player p, String direction) {
		switch (direction) {
		case "S":
			if (p.getLocation()[0]==23) {
				System.out.println("Cant move off the board");
				return false;
			}
			else if (board[p.getLocation()[0] + 1][p.getLocation()[1]] == ' '
					|| board[p.getLocation()[0] + 1][p.getLocation()[1]] == 'E') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "D":
			if (p.getLocation()[1]==23) {
				System.out.println("Cant move off the board");
				return false;
			}
			else if (board[p.getLocation()[0]][p.getLocation()[1] + 1] == ' '
					|| board[p.getLocation()[0]][p.getLocation()[1] + 1] == 'E') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "A":
			if (p.getLocation()[1]==0) {
				System.out.println("Cant move off the board");
				return false;
			}
			else if (board[p.getLocation()[0]][p.getLocation()[1] - 1] == ' '
					|| board[p.getLocation()[0]][p.getLocation()[1] - 1] == 'E') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "W":
			if (p.getLocation()[0]==0) {
				System.out.println("Cant move off the board");
				return false;
			}
			if (board[p.getLocation()[0] - 1][p.getLocation()[1]] == ' '
					|| board[p.getLocation()[0] - 1][p.getLocation()[1]] == 'E') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		default:
			return false;
		}
	}

	String playerRoomLocation(Player p) {
		int[] loc = p.getLocation();

		System.out.println(Arrays.toString(p.getLocation()));
		//TODO Fix these indexes
		
		if ((loc[1] > 0 && loc[1] < 5) && (loc[0] > 0 && loc[0] < 7)) {
			return "Kitchen";
		}

		else if ((loc[1] > 8 && loc[1] < 16) && (loc[0] > 0 && loc[0] < 6)) {
			return "Ballroom";
		}

		else if ((loc[1] > 18 && loc[1] < 24) && (loc[0] > 0 && loc[0] < 4)) {
			return "Conservatory";
		}

		else if ((loc[1] > 0 && loc[1] < 7) && (loc[0] > 0 && loc[0] < 6)) {
			return "Dining room";
		}

		else if ((loc[1] > 18 && loc[1] < 24) && (loc[0] > 7 && loc[0] < 11)) {
			return "Billiard room";
		}
		else if ((loc[1] > 17 && loc[1] < 24) && (loc[0] > 13 && loc[0] < 18)) {
			return "Library";
		}

		else if ((loc[1] > 0 && loc[1] < 6) && (loc[0] > 19 && loc[0] < 24)) {
			return "Lounge";
		}

		else if ((loc[1] > 9 && loc[1] < 14) && (loc[0] > 18 && loc[0] < 24)) {
			return "Hall";
		}

		else if ((loc[1] > 17 && loc[1] < 24) && (loc[0] > 21 && loc[0] < 24)) {
			return "Study";
		} else {
			return "not a room";
		}
	}

	// Temporary code to test CluedoBoard class
	public static void main(String[] args) throws IOException {
		PlayerSetup setup = new PlayerSetup();
		setup.setupPlayers();
		ArrayList<Player> players = setup.getPlayers();
		CluedoBoard myBoard = new CluedoBoard();
		myBoard.initialiseBoard(players);
		myBoard.printBoard();

		myBoard.movePlayer(players.get(0));

		// System.out.println(myBoard.playerRoomLocation(players.get(0)));
		myBoard.printBoard();
	}

}
