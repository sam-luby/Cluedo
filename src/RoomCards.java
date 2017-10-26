import java.util.Random;

public enum RoomCards {
	BALLROOM("Ballroom"),
	KITCHEN("Kitchen"),
	CONSERVATORY("Conservatory"),
	DININGROOM("Dining room"),
	LOUNGE("Lounge"),
	HALL("Hall"),
	STUDY("Study"),
	BILLIARDROOM("Billiard room"),
	LIBRARY("Library");
	
	private final String room;
	
	RoomCards(String r){
		this.room = r;
	}
	
	public String getRoom() {
		return room;
	}
	
	public static RoomCards random() {
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
}
