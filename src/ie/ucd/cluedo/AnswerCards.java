package ie.ucd.cluedo;

public class AnswerCards extends Cards {
	private String[] solution = new String[3]; 
	
	public AnswerCards() {
		solution[0] = SuspectCards.random();
		solution[1] = RoomCards.random();
		solution[2] = RoomCards.random();
	}
		
	//code to test random picking of cards
		public static void main(String[] args){
			String[] answer = new AnswerCards().solution;
			for(int i = 0;i < answer.length; i++) {
				System.out.println(answer[i]);
			}
		}
}
