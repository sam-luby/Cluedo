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

	public Movement(Player player, CluedoBoard cluedoBoard, ArrayList<Player> players) throws IOException {
		this.cluedoBoard = cluedoBoard;
		board = cluedoBoard.getBoard();

		int[] location = player.getLocation();

		PlayerTurn turn = new PlayerTurn(player, location);
		int moves = turn.getMoves();

		Scanner newScan = new Scanner(System.in);

		while (moves > 0) {
			System.out.println(player.getName() + " " + playerRoomLocation(player));

			String direction = null;
			System.out.println(moves + " move(s) remaining...");
			System.out.println("Give a direction [W,A,S,D]:");
			direction = newScan.nextLine().toUpperCase();
			
			// Checks if the direction the player wants to move is valid, and moves the player
			if (canMove(player, direction)) {
				move(player, direction, turn, players);
			}

			cluedoBoard.setBoard(board);
			cluedoBoard.printBoard();
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

	public boolean canMove(Player player, String direction) {
		switch (direction) {
		case "S":
			if (player.getLocation()[0] == 23) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[player.getLocation()[0] + 1][player.getLocation()[1]] == ' '
					|| board[player.getLocation()[0] + 1][player.getLocation()[1]] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "D":
			if (player.getLocation()[1] == 23) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[player.getLocation()[0]][player.getLocation()[1] + 1] == ' '
					|| board[player.getLocation()[0]][player.getLocation()[1] + 1] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "A":
			if (player.getLocation()[1] == 0) {
				System.out.println("Cant move off the board");
				return false;
			} else if (board[player.getLocation()[0]][player.getLocation()[1] - 1] == ' '
					|| board[player.getLocation()[0]][player.getLocation()[1] - 1] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		case "W":
			if (player.getLocation()[0] == 0) {
				System.out.println("Cant move off the board");
				return false;
			}
			if (board[player.getLocation()[0] - 1][player.getLocation()[1]] == ' '
					|| board[player.getLocation()[0] - 1][player.getLocation()[1]] == '#') {
				return true;
			} else {
				System.out.println("Cant move through walls");
				return false;
			}
		default:
			return false;
		}
	}

	void move(Player player, String direction, PlayerTurn turn, ArrayList<Player> players) throws IOException  {
		int vertPos = player.getLocation()[0];
		int horizPos = player.getLocation()[1];
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
			player.setLocation(vertMove, horizMove);
			vertPos = player.getLocation()[0];
			horizPos = player.getLocation()[1];
			board[vertMove][horizMove] = Character.toUpperCase(player.getName().charAt(0));
			turn.decrememntMoves();
		} else if (board[vertMove][horizMove] == '#') {
			if (playerRoomLocation(player) == "Corridor") {
				board[vertPos][horizPos] = ' ';	
				player.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = player.getLocation()[0];
				horizPos = player.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(player.getName().charAt(0));
				executeChoice(PlayerTurn.getPlayerChoice(player, playerRoomLocation(player)), player, turn, players);
			} else {
				board[vertPos][horizPos] = ' ';
				player.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = player.getLocation()[0];
				horizPos = player.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(player.getName().charAt(0));
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

}
