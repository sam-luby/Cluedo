package ie.ucd.cluedo.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ie.ucd.cluedo.AddPlayers;

public class AddPlayersGUI {
	public static class Players {
		private final String[] players;
		
		public Players(String[] players) {
			this.players = players;
		}
	}
	
		private int numberOfPlayers = 3;
		JTable contentPane;
		private String[] players;
		
		
		static class CloseableJFrame extends JFrame {
			private static final long serialVersionUID = 1L;
			public CloseableJFrame() {
				setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		}
		
		
		public void getPlayersGui() {
			JFrame addPlayersWindow = new CloseableJFrame();
			addPlayersWindow.setSize(new Dimension(400,280));
			addPlayersWindow.setLocationRelativeTo(null);
			addPlayersWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		    final String[] columns = new String[]{"Player #", "Player name"};	
		    String[][] data = new String[][]{new String[] {"Player 1"}, new String[]{"Player 2"},new String[] { "Player 3"}};
		   	    
		    contentPane = new JTable();
		 
		    contentPane.setModel(new DefaultTableModel(data, columns) {
				private static final long serialVersionUID = 1L;
				@Override
		    	public boolean isCellEditable(int row, int column) {
		    		if(column==1) {
		    			contentPane.setColumnSelectionAllowed(false);
		    			return true;
		    		} else {
		    			return false;
		    		}
		    	}
		    });
		    
		    contentPane.getColumnModel().getColumn(0).setMaxWidth(65);
		    contentPane.setRowHeight(30);
		    addPlayersWindow.add(new JScrollPane(contentPane),BorderLayout.CENTER);		
		    JPanel addPlayersPanel = new JPanel();
	
		    JButton addPlayerButton = new JButton("Add another player");
		    addPlayerButton.addActionListener(new ActionListener()
		    {
		        @Override
		        public void actionPerformed(ActionEvent e)
		        {
		        	if(numberOfPlayers==6) {
		        		System.out.println("Can't add any more players.");
		        	} else {
		        		System.out.println("'Add' button pressed.");
			            numberOfPlayers+=1;
			            DefaultTableModel model = (DefaultTableModel)contentPane.getModel();
			            model.addRow(new String[]{"Player "+numberOfPlayers,""});
		        	} 
		        }
		    });
		
		    JButton runButton = new JButton("Run");
		    runButton.addActionListener(new ActionListener()
		    {
		        @Override
		        public void actionPerformed(ActionEvent e)
		        {  	
		    		
//		        	String[] players = new String[numberOfPlayers];
//					List<String> playersList = new ArrayList<String>();
		        
//					for (int i = 0 ; i < numberOfPlayers ; i++) {
//						players[i] = contentPane.getValueAt(i, 1).toString();
//						playersList.add(contentPane.getValueAt(i, 1).toString());
//						players = playersList.toArray(players);
						setPlayers();
//					}
					
	        		addPlayersWindow.dispose();
		        }
		    });
			  
		    addPlayersPanel.add(addPlayerButton);
		    addPlayersPanel.add(runButton);
		    addPlayersWindow.add(addPlayersPanel,BorderLayout.SOUTH);
		    addPlayersWindow.setVisible(true);
		}
		
		
		public void setPlayers() {
			Component[] all_comp = contentPane.getComponents();  
			for(int i = 0; i < all_comp.length; i++) {
			    if (all_comp[i] instanceof Button) { 
			        String text = ((Button)all_comp[i]).toString();
			        System.out.println(text);
			        // this is the text. Do what you want with it....
			    }
			}  
		}
		
		public String[] getPlayers() {
			return players;
		}
}
