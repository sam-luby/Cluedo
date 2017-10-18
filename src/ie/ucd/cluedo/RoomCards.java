package ie.ucd.cluedo;

public class RoomCards extends Cards {
	private String[] rooms = {"Kitchen", "Ballroom", "Conservatory", "Dining Room", "Lounge",
			"Hall", "Study", "Billiard Room", "Library"};
	
	public RoomCards() {}

	public String[] getCards() {
		return rooms;
	}
	
}
