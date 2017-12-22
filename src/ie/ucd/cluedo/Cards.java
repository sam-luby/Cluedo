package ie.ucd.cluedo;

import ie.ucd.cluedo.enums.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Distribute cards amongst players.
 * Cards is a singleton class (only one instance can be created!)
 * @author Darren & Sam
 */
public class Cards {
	
	//Remaining cards = all cards - solutionCards
	private static ArrayList<String> solutionCards = new ArrayList<String>();
	private static ArrayList<String> remainingCards = new ArrayList<String>();
	
	private static Cards uniqueInstance = null;
	
	// Constructor randomises the solution cards and the remaining cards 
	private Cards() {
		solutionCards.add(WeaponCards.random().getWeapon());
		solutionCards.add(SuspectCards.random().getSuspect());
		solutionCards.add(RoomCards.random().getRoom());
		
		for(WeaponCards w : WeaponCards.values()) {
			if(!solutionCards.contains(w.getWeapon())) {
				remainingCards.add(w.getWeapon());
			}
		}
		for(SuspectCards s : SuspectCards.values()) {
			if(!solutionCards.contains(s.getSuspect())) {
				remainingCards.add(s.getSuspect());
			}
		}
		for(RoomCards r : RoomCards.values()) {
			if(!solutionCards.contains(r.getRoom())) {
				remainingCards.add(r.getRoom());
			}
		}
	};
	
	//Singleton class
	public static Cards getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Cards();
		} 
			return uniqueInstance;
	}
	
	public ArrayList<String> getWeaponCards(){
		ArrayList<String> weaponCards = new ArrayList<String>();
		for(WeaponCards w : WeaponCards.values()) {
			weaponCards.add(w.getWeapon());
		}
		return weaponCards;
	}
	
	public ArrayList<String> getSuspectCards(){
		ArrayList<String> suspectCards = new ArrayList<String>();
		for(SuspectCards w : SuspectCards.values()) {
			suspectCards.add(w.getSuspect());
		}
		return suspectCards;
	}
	
	public ArrayList<String> getRoomCards(){
		ArrayList<String> roomCards = new ArrayList<String>();
		for(RoomCards w : RoomCards.values()) {
			roomCards.add(w.getRoom());
		}
		return roomCards;
	}

	public ArrayList<String> getAllCards(){
		ArrayList<String> allCards = new ArrayList<String>();
		
		for(WeaponCards w : WeaponCards.values()) {
			allCards.add(w.getWeapon());
		}
		for(SuspectCards s : SuspectCards.values()) {
			allCards.add(s.getSuspect());
		}
		for(RoomCards r : RoomCards.values()) {
			allCards.add(r.getRoom());
		}
		return allCards;
	}
	
	// Returns the solution (answer) cards
	public ArrayList<String> getAnswerCards() {
		return solutionCards;
	}
	
	//Returns the remaining cards (all cards minus answer cards)
	public ArrayList<String> getRemainingCards(){
		return remainingCards;
	}
	
}
