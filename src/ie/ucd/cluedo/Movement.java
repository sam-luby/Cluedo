package ie.ucd.cluedo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles player movements around the board
 * 
 * @author Sam & Darren
 */
public class Movement {

	private CluedoBoard cluedoBoard;
	char[][] board;

	public Movement(Player p, CluedoBoard cluedoBoard, ArrayList<Player> players) throws IOException {
		this.cluedoBoard = cluedoBoard;
		board = cluedoBoard.getBoard();

		int[] location = p.getLocation();

		PlayerTurn turn = new PlayerTurn(p, location);
		int moves = turn.getMoves();

		Scanner newScan = new Scanner(System.in);

		while (moves > 0) {
			System.out.println(p.getName() + " " + playerRoomLocation(p));

			String direction = null;
			System.out.println(moves + " move(s) remaining...");
			System.out.println("Give a direction [W,A,S,D]:");
			direction = newScan.nextLine().toUpperCase();
			
			if (canMove(p, direction)) {
				move(p, direction, turn, players);
			}

			cluedoBoard.setBoard(board);
			cluedoBoard.printBoard();

			System.out.println(playerRoomLocation(p));
			moves = turn.getMoves();
		}
		System.out.println("--------------------------TURN OVER---------------------------\n\n");
	}

	@SuppressWarnings("unused")
	public void executeChoice(int choice, Player p, PlayerTurn turn, ArrayList<Player> players) throws IOException {
		if (choice == 1) {
			Accusation accusation = new Accusation(p, players);
		} else if (choice == 2) {
			Hypothesis hypothesis = new Hypothesis(p, players, playerRoomLocation(p));
		} else if (choice == 3) {
			useSecretPassage(p);
		}
		turn.endTurn();
	}

	public boolean canMove(Player p, String direction) {
		switch (direction) {
		case "S":
			if (p.getLocation()[0] == 23) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[p.getLocation()[0] + 1][p.getLocation()[1]] == ' '
					|| board[p.getLocation()[0] + 1][p.getLocation()[1]] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "D":
			if (p.getLocation()[1] == 23) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[p.getLocation()[0]][p.getLocation()[1] + 1] == ' '
					|| board[p.getLocation()[0]][p.getLocation()[1] + 1] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "A":
			if (p.getLocation()[1] == 0) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[p.getLocation()[0]][p.getLocation()[1] - 1] == ' '
					|| board[p.getLocation()[0]][p.getLocation()[1] - 1] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "W":
			if (p.getLocation()[0] == 0) {
				System.out.println("Cant move off the board");
				return false;
			}
			if (board[p.getLocation()[0] - 1][p.getLocation()[1]] == ' '
					|| board[p.getLocation()[0] - 1][p.getLocation()[1]] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		default:
			return false;
		}
	}

	void move(Player p, String direction, PlayerTurn turn, ArrayList<Player> players) throws IOException {
		int vertPos = p.getLocation()[0];
		int horizPos = p.getLocation()[1];
		int vertMove = vertPos;
		int horizMove = horizPos;
		int vertStep = 0; 
		int horizStep = 0;

		switch (direction) {
		case "S":
			vertMove = vertPos + 1;
			vertStep = 2;
			break;
		case "W":
			vertMove = vertPos - 1;
			vertStep = -2;
			break;
		case "A":
			horizMove = horizPos - 1;
			horizStep = -2;
			break;
		case "D":
			horizMove = horizPos + 1;
			horizStep = 2;
			break;
		default:
			vertMove = vertPos;
			horizMove = horizPos;
			break;
		}

		if (board[vertMove][horizMove] == ' ') {
			board[vertPos][horizPos] = ' ';
			p.setLocation(vertMove, horizMove);
			vertPos = p.getLocation()[0];
			horizPos = p.getLocation()[1];
			board[vertMove][horizMove] = Character.toUpperCase(p.getName().charAt(0));
			turn.decrememntMoves();
		} else if (board[vertMove][horizMove] == '#') {
			if (playerRoomLocation(p) == "Corridor") {
				board[vertPos][horizPos] = ' ';	
				p.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = p.getLocation()[0];
				horizPos = p.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(p.getName().charAt(0));
				executeChoice(getPlayerChoice(p), p, turn, players);
			} else {
				board[vertPos][horizPos] = ' ';
				p.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = p.getLocation()[0];
				horizPos = p.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(p.getName().charAt(0));
				turn.decrememntMoves();
			}
		}
	}

	// Returns room location of a player based on their 2D array location
	public String playerRoomLocation(Player p) {
		int[] loc = p.getLocation();

		if ((loc[1] > 0 && loc[1] < 6) && (loc[0] > 0 && loc[0] < 6)) {
			return "Kitchen";
		} else if ((loc[1] > 8 && loc[1] < 16) && (loc[0] > 0 && loc[0] < 6)) {
			return "Ballroom";
		} else if ((loc[1] > 18 && loc[1] < 24) && (loc[0] > 0 && loc[0] < 4)) {
			return "Conservatory";
		} else if ((loc[1] > 0 && loc[1] < 7) && (loc[0] > 8 && loc[0] < 14)) {
			return "Dining room";
		} else if ((loc[1] > 18 && loc[1] < 24) && (loc[0] > 7 && loc[0] < 11)) {
			return "Billiard room";
		} else if ((loc[1] > 17 && loc[1] < 24) && (loc[0] > 13 && loc[0] < 18)) {
			return "Library";
		} else if ((loc[1] > 0 && loc[1] < 6) && (loc[0] > 18 && loc[0] < 24)) {
			return "Lounge";
		} else if ((loc[1] > 9 && loc[1] < 14) && (loc[0] > 17 && loc[0] < 24)) {
			return "Hall";
		} else if ((loc[1] > 17 && loc[1] < 24) && (loc[0] > 20 && loc[0] < 24)) {
			return "Study";
		} else {
			return "Corridor";
		}
	}

	public void useSecretPassage(Player p) {
		String room = playerRoomLocation(p);
		switch (room) {
		case "Kitchen":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(22, 21);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			System.out.println(p.getName() + " travelled from " + room + " to the Study");
			break;
		case "Conservatory":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(22, 2);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			System.out.println(p.getName() + " travelled from " + room + " to the Lounge");
			break;
		case "Lounge":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(1, 21);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			System.out.println(p.getName() + " travelled from " + room + " to the Conservatory");
			break;
		case "Study":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(1, 2);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			System.out.println(p.getName() + " travelled from " + room + " to the Kitchen");
			break;
		}
	}

	// TODO Move this code to somewhere else (PlayerTurn class probably)
	public int getPlayerChoice(Player p) {
		String playerLocation = playerRoomLocation(p);
		if (playerLocation.equalsIgnoreCase("Kitchen") || playerLocation.equalsIgnoreCase("Conservatory")
				|| playerLocation.equalsIgnoreCase("Lounge") || playerLocation.equalsIgnoreCase("Study")) {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
			System.out.println("Make hypothesis [2]:");
			System.out.println("Use secret passage [3]:");
		} else if (!playerLocation.equalsIgnoreCase("Corridor")) {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
			System.out.println("Make hypothesis [2]:");

		} else {
			System.out.println("What do you want to do? \n");
			System.out.println("Do nothing [0]: ");
			System.out.println("Make accusation [1]: ");
		}

		Scanner newScan = new Scanner(System.in);
		while (!newScan.hasNextInt()) {
			System.out.println("Make a valid decision: ");
			newScan.next();
		}
		int choice = newScan.nextInt();
		return choice;
	}

}
