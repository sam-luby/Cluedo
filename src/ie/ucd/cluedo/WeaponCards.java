package ie.ucd.cluedo;

public class WeaponCards extends Cards{
	
	private static String[] weapons = {"Hammer", "Knife", "Gun", "Baseball Bat", "Suicide Bomber", "Chainsaw"};

	public WeaponCards() {}

	public String[] getCards() {
		return weapons;
	}
	
	public static String random() {
		String randomWeapon = weapons[(int)(Math.random() * weapons.length)];
		return randomWeapon;
	}
		
}
