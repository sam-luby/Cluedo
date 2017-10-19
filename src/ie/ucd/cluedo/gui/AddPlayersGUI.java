package ie.ucd.cluedo.gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import ie.ucd.cluedo.AddPlayers;

public class AddPlayersGUI {
	public static class Players {
		public String players;
		
		public Players(String players) {
			this.players = players;
		}
	}
	
	//New class CloseableJDialog
		static class CloseableJDialog extends JDialog {
			private static final long serialVersionUID = 1L;
			public CloseableJDialog() {
				setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		}
		
		
		
		//dimensions
		private CloseableJDialog dialog;
		private final int windowWidth = 600;
		private final int windowHeight = 200;
		private final int fieldWidth = 300;
		private final int fieldHeight = 25;
		private final int row0 = 10;
		private final int row1 = 40;
		private final int row2 = 120;
		private final int col0 = 10;
		private final int col1 = 140;
		private final int col2 = 450;
		private JLabel playerLabel;
		private JTextField playerField;
		
		
		public void showGui(Players players) {
			dialog = new CloseableJDialog();
			dialog.setModal(true);
			dialog.setBounds(100, 100, windowWidth, windowHeight);
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			Container contentPane = dialog.getContentPane();
			contentPane.setLayout(null);
			dialog.setResizable(false);
			dialog.setTitle("Add Players");
			Font textFont = new Font("SansSerif", Font.PLAIN, 14);
			
			
			playerLabel = new JLabel("Add Player:");
			playerLabel.setBounds(col0,row0, fieldWidth, fieldHeight);
			playerLabel.setFont(textFont);
			contentPane.add(playerLabel);
			
			playerField = new JTextField();
			playerField.setBounds(col1, row0, fieldWidth, fieldHeight);
			playerField.setFont(textFont);
			contentPane.add(playerField);
			
			contentPane.setBackground(Color.LIGHT_GRAY);
			contentPane.setFont(textFont);
			dialog.setVisible(true);
			
		}

		public Players getPlayers() {
			return new Players(playerField.getText());
		}
}
