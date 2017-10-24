package ie.ucd.cluedo;
/**
 * Weapon cards class
 * @author Sam
 */
public class WeaponCards extends Cards{
	
	private static String[] weapons = {"Hammer", "Knife", "Gun", "Baseball Bat", "Suicide Bomber", "Chainsaw"};

	public WeaponCards() {}

	public static String[] getCards() {
		return weapons;
	}
	
	public static String random() {
		String randomWeapon = weapons[(int)(Math.random() * weapons.length)];
		return randomWeapon;
	}
		
}
