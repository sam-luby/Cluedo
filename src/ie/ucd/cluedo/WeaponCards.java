package ie.ucd.cluedo;

import java.util.Random;

public enum WeaponCards {
	HAMMER("Hammer"),
	KNIFE("Knife"),
	BASEBALLBAT("Baseball bat"),
	BOMB("Bomb"),
	CHAINSAW("Chainsaw");
	
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
	
	// testing the random return function
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
            System.out.printf("weapon[%d] = %s%n", i, WeaponCards.random());
        }
	}
}
