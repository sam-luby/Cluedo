package ie.ucd.cluedo;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import ie.ucd.cluedo.gui.AddPlayersGUI;
import ie.ucd.cluedo.gui.AddPlayersGUI.Players;

public class AddPlayers {
	private static Players x;
	private static int numberOfPlayers;
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		String[] players = getPlayersWindow();
		
		
	}
	

	private static String[] getPlayersWindow() throws InvocationTargetException, InterruptedException {
    	final AddPlayersGUI window = new AddPlayersGUI();
    	SwingUtilities.invokeAndWait(new Runnable() {
    		@Override
    		public void run() {
    			window.getPlayersGui();
    		}
    	});
    	return window.getPlayers();
    }
	
}
