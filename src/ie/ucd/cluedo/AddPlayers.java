package ie.ucd.cluedo;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ie.ucd.cluedo.gui.AddPlayersGUI;
import ie.ucd.cluedo.gui.AddPlayersGUI.Players;

public class AddPlayers {
	private static Players x;
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		String players = launchWindow(x).toString();
	}
	
	private static String launchWindow(Players players) throws InvocationTargetException, InterruptedException {
    	final AddPlayersGUI window = new AddPlayersGUI();
    	SwingUtilities.invokeAndWait(new Runnable() {
    		@Override
    		public void run() {
    			window.showGui(players);
    		}
    	});
    	return window.getPlayers().toString();
    }
	
}
