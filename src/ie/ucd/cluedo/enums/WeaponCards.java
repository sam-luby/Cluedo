package ie.ucd.cluedo.enums;

import java.util.Random;

public enum WeaponCards {
	HAMMER("Hammer"),
	KNIFE("Knife"),
	BASEBALLBAT("Baseball bat"),
	BOMB("Bomb"),
	CHAINSAW("Chainsaw"),
	DRUGS("Drugs");
	
	
	private final String weapon;
	
	WeaponCards(String w){
		this.weapon = w;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public static WeaponCards random() {
		Random random = new Random();
        return values()[random.nextInt(values().length)];
	}
	
}
