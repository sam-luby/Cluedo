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
		
//		int numberOfPlayers = getNumberOfPlayersWindow(numberOfPlayers);
		String players = getPlayersWindow(x).toString();
		
	}
	
	
	private static int getNumberOfPlayersWindow(int numberOfPlayers) throws InvocationTargetException, InterruptedException {
		final AddPlayersGUI window = new AddPlayersGUI();
		SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					window.getNumberOfPlayersGui(numberOfPlayers);
				}
		});
		return window.getNumberOfPlayers();		
	}
	
	private static String getPlayersWindow(Players players) throws InvocationTargetException, InterruptedException {
    	final AddPlayersGUI window = new AddPlayersGUI();
    	SwingUtilities.invokeAndWait(new Runnable() {
    		@Override
    		public void run() {
    			window.getPlayersGui(players);
    		}
    	});
    	return window.getPlayers().toString();
    }
	
}
