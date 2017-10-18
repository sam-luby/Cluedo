package ie.ucd.cluedo;

public class AnswerCards extends Cards {
	
	private String suspect;
	private String room;
	private String weapon;
	
	private String[] solution = new String[3]; 
	
	public AnswerCards() {
		suspect = SuspectCards.random();
		room = RoomCards.random();
		weapon = WeaponCards.random();
		solution[0] = suspect;
		solution[1] = room;
		solution[2] = weapon;
	}
		
	
	
	//code to test random picking of cards
		public static void main(String[] args){
			String[] answer = new AnswerCards().solution;
			for(int i = 0;i < answer.length; i++) {
				System.out.println(answer[i]);
			}
		}

}
