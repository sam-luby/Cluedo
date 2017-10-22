package ie.ucd.cluedo;

public class RoomCards extends Cards {
	private static String[] rooms = {"Kitchen", "Ballroom", "Conservatory", "Dining Room", "Lounge",
			"Hall", "Study", "Billiard Room", "Library"};
	
	public RoomCards() {}

	public static String[] getCards() {
		return rooms;
	}
	
	public static String random() {
		String randomRoom = rooms[(int)(Math.random() * rooms.length)];
		return randomRoom;
	}
	
}
