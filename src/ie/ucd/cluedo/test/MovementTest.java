package ie.ucd.cluedo.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.ucd.cluedo.CluedoBoard;
import ie.ucd.cluedo.Movement;
import ie.ucd.cluedo.Player;
import ie.ucd.cluedo.PlayerTurn;

public class MovementTest {

	ArrayList<String> samCards;
	ArrayList<String> darrenCards;
	ArrayList<String> kevinCards;
	Player sam;
	Player darren;
	Player kevin;
	ArrayList<Player> players;
	int boardWidth = 24;
	int boardHeight = 24;
	char[][] board = new char[24][24];
	
	@Before
	public void setUp() {
		samCards = new ArrayList<String>(Arrays.asList("Bomb", "Knife", "Mrs. Scarlet", "Library", "Study", "Kitchen"));
		sam = new Player("Sam", "Miss Scarlet", samCards);
	    darrenCards = new ArrayList<String>(Arrays.asList("Ballroom", "Colonel Mustard", "Chainsaw", "Drugs", "Professor Plum", "Dining room"));
	    darren = new Player("Darren", "Reverend Mr. Green", darrenCards);
	    kevinCards = new ArrayList<String>(Arrays.asList("Baseball bat", "Hammer", "Mrs. White", "Mrs. Peacock", "Lounge", "Conservatory", "Billiard room"));
	    kevin = new Player("Kevin", "Colonel Mustard", kevinCards);

	    players = new ArrayList<Player>(Arrays.asList(sam, darren, kevin));
	    
	    CluedoBoard myBoard = new CluedoBoard(players);
		myBoard.initialisePlayerLocations();
		board = myBoard.getBoard();
	    
	}
	
	@Test
	public void testCanMove() {
		boolean checkMovement;

		//Player is at 0,7 initially
		checkMovement = canMove(sam, players, "D");
		assertFalse("Player should not be able to move right ", checkMovement);
		
		checkMovement = canMove(sam, players, "W");
		assertFalse("Player should not be able to move up", checkMovement);
		
		checkMovement = canMove(sam, players, "A");
		assertTrue("Player should be able to move left", checkMovement);
		
		checkMovement = canMove(sam, players, "S");
		assertTrue("Player should be able to move down", checkMovement);
		
		
		//Puts player at bottom of board with a wall to the left
		sam.setLocation(23, 6);
		checkMovement = canMove(sam, players, "A");
		assertFalse("Player should not be able to move left", checkMovement);
		
		checkMovement = canMove(sam, players, "D");
		assertTrue("Player should be able to move right", checkMovement);
		
		checkMovement = canMove(sam, players, "W");
		assertTrue("Player should be able to move up", checkMovement);
		
		checkMovement = canMove(sam, players, "S");
		assertFalse("Players should not be able to move down", checkMovement);
		
		//Puts player at left of board with a wall above
		sam.setLocation(15, 0);
		checkMovement = canMove(sam, players, "A");
		assertFalse("Player should not be able to move left", checkMovement);
		
		checkMovement = canMove(sam, players, "D");
		assertTrue("Player should be able to move right", checkMovement);
		
		checkMovement = canMove(sam, players, "W");
		assertFalse("Player should not be able to move up", checkMovement);
		
		checkMovement = canMove(sam, players, "S");
		assertTrue("Players should be able to move down", checkMovement);
		
		//Puts player at right of board with a wall below
		sam.setLocation(6, 23);
		checkMovement = canMove(sam, players, "A");
		assertTrue("Player should be able to move left", checkMovement);
		
		checkMovement = canMove(sam, players, "D");
		assertFalse("Player should not be able to move right", checkMovement);
		
		checkMovement = canMove(sam, players, "W");
		assertTrue("Player should be able to move up", checkMovement);
		
		checkMovement = canMove(sam, players, "S");
		assertFalse("Players should not be able to move down", checkMovement);
	}
	
	@Test 
	public void testUseSecretPassage() {
		String newRoomLocation;
		
		newRoomLocation = useSecretPassage(sam, "Study");
		assertEquals("Secret passage method failed", "Kitchen", newRoomLocation);
		
		newRoomLocation = useSecretPassage(sam, "Conservatory");
		assertEquals("Secret passage method failed", "Lounge", newRoomLocation);
		
		newRoomLocation = useSecretPassage(sam, "Kitchen");
		assertEquals("Secret passage method failed", "Study", newRoomLocation);
		
		newRoomLocation = useSecretPassage(sam, "Lounge");
		assertEquals("Secret passage method failed", "Conservatory", newRoomLocation);
	}
	
	@Test
	public void testMove() throws IOException {
		sam.setLocation(5, 22);
		int[] location = sam.getLocation();
		PlayerTurn turn = new PlayerTurn(sam, location);
		
		//Test moving up
		int locationBeforeMoving = sam.getLocation()[0];
		move(sam, "W", turn, players);
		int locationAfterMoving = sam.getLocation()[0];
		assertTrue("Moving up didnt work", locationAfterMoving == locationBeforeMoving - 1);
		
		//Test moving down
		locationBeforeMoving = sam.getLocation()[0];
		move(sam, "S", turn, players);
		locationAfterMoving = sam.getLocation()[0];
		assertTrue("Moving up didnt work", locationAfterMoving == locationBeforeMoving + 1);
		
		//Test moving left
		locationBeforeMoving = sam.getLocation()[1];
		move(sam, "A", turn, players);
		locationAfterMoving = sam.getLocation()[1];
		assertTrue("Moving up didnt work", locationAfterMoving == locationBeforeMoving - 1);
		
		//Test moving right
		locationBeforeMoving = sam.getLocation()[1];
		move(sam, "D", turn, players);
		locationAfterMoving = sam.getLocation()[1];
		assertTrue("Moving up didnt work", locationAfterMoving == locationBeforeMoving + 1);
		
		//Test entering a room
		sam.setLocation(4, 7);
		locationBeforeMoving = sam.getLocation()[1];
		move(sam, "D", turn, players);
		locationAfterMoving = sam.getLocation()[1];
		assertTrue("Moving into room didnt work", locationAfterMoving == locationBeforeMoving +2);
		
		//Test moves decrement when in corridor
		sam.setLocation(4, 7);
		int movesBeforeMoving = turn.getMoves();
		move(sam, "S", turn, players);
		int movesAfterMoving = turn.getMoves();
		assertTrue("Moving in corridoor didnt decrement moves", movesBeforeMoving > movesAfterMoving);
		
		//Test moves don't decrement when in a room
		sam.setLocation(4, 10);
		movesBeforeMoving = turn.getMoves();
		move(sam, "D", turn, players);
		movesAfterMoving = turn.getMoves();
		assertTrue("Moving in a room decremented moves", movesBeforeMoving == movesAfterMoving);
		
	}
	
	@After
    public void tearDown() {
		samCards = null;
		sam = null;
	    darrenCards = null;
	    darren = null;
	    kevinCards = null;
	    kevin = null;
	    players = null;
	    
	    CluedoBoard myBoard = null;
    }
	
    //Can't initialise Movement object so re-implemented some methods here
	public boolean canMove(Player player, ArrayList<Player> players, String direction) {
		int outOfBoundsDir = 0;
		int outOfBoundsLoc = 0;
		
		int vertMove = 0;
		int horizMove = 0;
		
		switch(direction) {
		case "S":
			outOfBoundsLoc = 23;
			outOfBoundsDir = 0;
			vertMove = 1;
			horizMove = 0;
			break;
		case "W":
			outOfBoundsLoc = 0;
			outOfBoundsDir = 0;
			vertMove = -1;
			horizMove = 0;
			break;
		case "A":
			outOfBoundsLoc = 0;
			outOfBoundsDir = 1;
			vertMove = 0;
			horizMove = -1;
			break;
		case "D":
			outOfBoundsLoc = 23;
			outOfBoundsDir = 1;
			vertMove = 0;
			horizMove = 1;
			break;
		default:
			break;
		}
		
		if (player.getLocation()[outOfBoundsDir] == outOfBoundsLoc) {
			return false;
		} else if (board[player.getLocation()[0] + vertMove][player.getLocation()[1] + horizMove] == ' '
				|| board[player.getLocation()[0] + vertMove][player.getLocation()[1] + horizMove] == '#') {
			return true;
		} else if (isPlayerAtLocation(player, players, direction)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	boolean isPlayerAtLocation(Player player, ArrayList<Player> players, String direction) {
		int vertPos = player.getLocation()[0];
		int horizPos = player.getLocation()[1];
		int vertMove = vertPos;
		int horizMove = horizPos;
		
		switch (direction) {
		case "S":
			vertMove = vertPos + 1;
			break;
		case "W":
			vertMove = vertPos - 1;
			break;
		case "A":
			horizMove = horizPos - 1;
			break;
		case "D":
			horizMove = horizPos + 1;
			break;
		default:
			vertMove = vertPos;
			horizMove = horizPos;
		}
		
		for (Player p : players) {
			char c = p.getName().charAt(0);
			if (board[vertMove][horizMove] == c) {
				return true;
			}
		}
		return false;
	}
	
	void move(Player player, String direction, PlayerTurn turn, ArrayList<Player> players) throws IOException {
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
		
		//If there is already a player in the desired location
		for(Player p : players) {
			char initial = p.getName().charAt(0);
			if(board[vertMove][horizMove] == initial) {
				board[vertPos][horizPos] = ' ';
				player.setLocation(vertMove, horizMove);
				vertPos = player.getLocation()[0];
				horizPos = player.getLocation()[1];
				board[vertMove][horizMove] = '2';
				if(playerRoomLocation(player) == "Corridor") {
					turn.decrememntMoves();	
				}
			}
		}
		
		//Moves player in the desired location, though an entrance if necessary
		if (board[vertMove][horizMove] == ' ') {
			board[vertPos][horizPos] = ' ';
			player.setLocation(vertMove, horizMove);
			vertPos = player.getLocation()[0];
			horizPos = player.getLocation()[1];
			board[vertMove][horizMove] = Character.toUpperCase(player.getName().charAt(0));
			if(playerRoomLocation(player) == "Corridor") {
				turn.decrememntMoves();	
			}
		} else if (board[vertMove][horizMove] == '#') {
			//Checks if player is coming INTO or OUT OF the room [if coming into room, player must make a choice]
			if (playerRoomLocation(player) == "Corridor") {
				board[vertPos][horizPos] = ' ';
				player.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = player.getLocation()[0];
				horizPos = player.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(player.getName().charAt(0));
			} else {
				board[vertPos][horizPos] = ' ';
				player.setLocation(vertPos + vertStep, horizPos + horizStep);
				vertPos = player.getLocation()[0];
				horizPos = player.getLocation()[1];
				board[vertPos][horizPos] = Character.toUpperCase(player.getName().charAt(0));
				if(playerRoomLocation(player) == "Corridor") {
					turn.decrememntMoves();	
				}
			}
		}
	}

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
	
	public String useSecretPassage(Player p, String room) {
		switch (room) {
		case "Kitchen":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(22, 21);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			return "Study";
		case "Conservatory":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(22, 2);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			return "Lounge";
		case "Lounge":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(1, 21);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			return "Conservatory";
		case "Study":
			board[p.getLocation()[0]][p.getLocation()[1]] = ' ';
			p.setLocation(1, 2);
			board[p.getLocation()[0]][p.getLocation()[1]] = Character.toUpperCase(p.getName().charAt(0));
			return "Kitchen";
		}
		return "Didnt work";
	}
	
	
}
