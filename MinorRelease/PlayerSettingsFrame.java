import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Hue {

	Cyan(Color.cyan), Magenta(Color.magenta), Yellow(Color.yellow), Red(Color.red), Green(
		Color.green), Blue(Color.blue);

		private final Color color;

		private Hue(Color color) 
		{
		  this.color = color;
		}

		public Color getColor() 
		{
		  return color;
		}
}

public class PlayerSettingsFrame extends GameFrame
{
	private FrameManager frameManager;
	private int AIplayers;
	private int totalPlayers;
	private int humanPlayers;
	private int difficulty;
	private JTextField player1Name, player2Name, player3Name, player4Name;
	private JComboBox<Hue> colorBox1, colorBox2, colorBox3, colorBox4;
	
	public PlayerSettingsFrame(FrameManager frameManager) 
	{
		super();
		this.frameManager = frameManager;
		makeFrame();
		
		AIplayers=0;
		totalPlayers=0;
		humanPlayers=0;
		difficulty=0;
	}
	
	public void makeFrame()
    {
		JPanel playerSelectPanel= new JPanel();
		playerSelectPanel.setLayout( new FlowLayout());
		JLabel topLabel= new JLabel("Select number of players");
		
		JPanel humanPlayerPanel=new JPanel();
		JLabel humanPlayerLabel= new JLabel("Select number of human players");
		
		JPanel bottomPanel=new JPanel();
		
		JPanel inputPanel1=new JPanel();
		JPanel inputPanel2=new JPanel();
		
		JPanel playerPanel=new JPanel();
		
		JPanel AIinfoPanel=new JPanel();
		JLabel AIinfo =new JLabel("");
		JButton easyAI=new JButton("Easy");
		easyAI.addActionListener(e->difficulty=0);
		JButton hardAI=new JButton("Hard");
		easyAI.addActionListener(e->difficulty=1);
		
		JPanel playerInfoPanel=new JPanel();
		JLabel playerInfoLabel=new JLabel("");
		
		JPanel humanPlayerInfoPanel=new JPanel();
		JLabel humanPlayerInfoLabel=new JLabel("");
		
		JPanel AIselectionPanel = new JPanel();
		JLabel AIselectionLabel = new JLabel("Please select AI difficulty (Easy by default): ");
		
		/*
		 *  Buttons for selecting total number of players
		 */
		JButton playerSelect1= new JButton("2");
		playerSelect1.addActionListener(e->{totalPlayers=2;
		playerInfoLabel.setText("There will be "+ totalPlayers +" total players");
		humanPlayers=0;
		AIplayers=0;
		AIinfo.setText("");
		humanPlayerInfoLabel.setText("");
		});

		JButton playerSelect3= new JButton("4");
		playerSelect3.addActionListener(e->{totalPlayers = 4;
		playerInfoLabel.setText("There will be "+ totalPlayers +" total players");
		humanPlayers=0;
		AIplayers=0;
		AIinfo.setText("");
		humanPlayerInfoLabel.setText("");
		});
		
		/*
		 *  Buttons for selecting total number of human players
		 *  Cannot be more than total number of players
		 *  Also sets number of AI players
		 */
		JButton humanSelect1= new JButton("1");
		humanSelect1.addActionListener(e->{
		if(totalPlayers>=1) {
			humanPlayers=1;
			humanPlayerInfoLabel.setText("There will be "+ humanPlayers +" human players");
			AIplayers= totalPlayers-humanPlayers;
			AIinfo.setText("There will be "+ AIplayers +" AI players");
			AIselectionPanel.add(AIselectionLabel);
			AIselectionPanel.add(easyAI);
			AIselectionPanel.add(hardAI);
		} else {
			JOptionPane.showMessageDialog(null, "Number of human players cannot be more than the total number of players!.", null, JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		JButton humanSelect2= new JButton("2");
		humanSelect2.addActionListener(e->{
		if(totalPlayers>=2) {
			humanPlayers=2;
			humanPlayerInfoLabel.setText("There will be "+ humanPlayers +" human players");
			AIplayers= totalPlayers-humanPlayers;
			AIinfo.setText("There will be "+ AIplayers +" AI players");
			AIselectionPanel.add(AIselectionLabel);
			AIselectionPanel.add(easyAI);
			AIselectionPanel.add(hardAI);
		} else {
			JOptionPane.showMessageDialog(null, "Number of human players cannot be more than the total number of players!.", null, JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		JButton humanSelect3= new JButton("3");
		humanSelect3.addActionListener(e->{
		if(totalPlayers>=3) {
			humanPlayers=3;
			humanPlayerInfoLabel.setText("There will be "+ humanPlayers +" human players");
			AIplayers= totalPlayers-humanPlayers;
			AIinfo.setText("There will be "+ AIplayers +" AI players");
			AIselectionPanel.add(AIselectionLabel);
			AIselectionPanel.add(easyAI);
			AIselectionPanel.add(hardAI);
		} else {
			JOptionPane.showMessageDialog(null, "Number of human players cannot be more than the total number of players!.", null, JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		JButton humanSelect4= new JButton("4");
		humanSelect4.addActionListener(e->{
		if(totalPlayers>=4) {
			humanPlayers=4;
			humanPlayerInfoLabel.setText("There will be "+ humanPlayers +" human players");
			AIplayers= totalPlayers-humanPlayers;
			AIinfo.setText("There will be "+ AIplayers +" AI players");
			AIselectionPanel.add(AIselectionLabel);
			AIselectionPanel.add(easyAI);
			AIselectionPanel.add(hardAI);
		} else {
			JOptionPane.showMessageDialog(null, "Number of human players cannot be more than the total number of players!.", null, JOptionPane.PLAIN_MESSAGE);
		}
		});
		
		
		
		JLabel info= new JLabel("Enter player name and select colours");
		
		player1Name = new JTextField("Player 1");
		player1Name.setPreferredSize(new Dimension(80,30));
		player2Name = new JTextField("Player 2");
		player2Name.setPreferredSize(new Dimension(80,30));
     	player3Name = new JTextField("Player 3");
     	player3Name.setPreferredSize(new Dimension(80,30));
     	player4Name = new JTextField("Player 4");
     	player4Name.setPreferredSize(new Dimension(80,30));

		colorBox1 = new JComboBox<Hue>();
		for (Hue h : Hue.values()) {
		  colorBox1.addItem(h);
		}

		colorBox2 = new JComboBox<Hue>();
    	for (Hue h : Hue.values()) {
      		colorBox2.addItem(h);
    	}

		colorBox3 = new JComboBox<Hue>();
    	for (Hue h : Hue.values()) {
      		colorBox3.addItem(h);
    	}

		colorBox4 = new JComboBox<Hue>();
    	for (Hue h : Hue.values()) {
      		colorBox4.addItem(h);
    	}

     	JButton backButton= new JButton("back");
		backButton.addActionListener(e->back());
		
		JButton startButton= new JButton("start game");
		startButton.addActionListener(e->next());
     
     	playerSelectPanel.add(topLabel);
     	playerSelectPanel.add(playerSelect1);
     	playerSelectPanel.add(playerSelect3);
     	
     	playerInfoPanel.add(playerInfoLabel);
     	
     	humanPlayerPanel.add(humanPlayerLabel);
     	humanPlayerPanel.add(humanSelect1);
     	humanPlayerPanel.add(humanSelect2);
     	humanPlayerPanel.add(humanSelect3);
     	humanPlayerPanel.add(humanSelect4);
     	
     	humanPlayerInfoPanel.add(humanPlayerInfoLabel);
     	
     	AIinfoPanel.add(AIinfo);
     	
     	

     	playerPanel.add(info);
     	
     	inputPanel1.add(player1Name);
     	inputPanel1.add(colorBox1);
     	inputPanel1.add(player2Name);
     	inputPanel1.add(colorBox2);
     	
     	inputPanel2.add(player3Name);
     	inputPanel2.add(colorBox3);
     	inputPanel2.add(player4Name);
     	inputPanel2.add(colorBox4);
    
     	bottomPanel.add(backButton);
     	bottomPanel.add(startButton);
     
     
     	getContentPane().setLayout(new GridLayout(0,1));
     	getContentPane().add(playerSelectPanel);
     	getContentPane().add(playerInfoPanel);
     	getContentPane().add(humanPlayerPanel);
     	getContentPane().add(humanPlayerInfoPanel);
     	getContentPane().add(AIinfoPanel);
     	getContentPane().add(AIselectionPanel);
     	getContentPane().add(playerPanel);
     	getContentPane().add(inputPanel1);
     	getContentPane().add(inputPanel2);
     	getContentPane().add(bottomPanel);
     	
     	setVisible( false);
    }
	
	public void back()
	{
		AIplayers=0;
		totalPlayers=0;
		humanPlayers=0;
		difficulty=0;
		setVisible(false);
		frameManager.showGameModeFrame();
		
	}
	
	public void next()
	{	
		if(totalPlayers==humanPlayers + AIplayers && totalPlayers!=0 && humanPlayers !=0) {
			setVisible(false);
			if (totalPlayers == 2){
				Hue player1Colour = (Hue) colorBox1.getSelectedItem();
				frameManager.createHumanPlayer(player1Name.getText(), player1Colour.getColor(), 1);
				if(AIplayers == 1) {
					Hue player2Colour = (Hue) colorBox2.getSelectedItem();
					frameManager.createAIPlayer(player2Name.getText(), player2Colour.getColor(), 2, difficulty);
				} else {
				Hue player2Colour = (Hue) colorBox2.getSelectedItem();
				frameManager.createHumanPlayer(player2Name.getText(), player2Colour.getColor(), 2);
				}
			}
			else if(totalPlayers == 4){
				Hue player1Colour = (Hue) colorBox1.getSelectedItem();
				frameManager.createHumanPlayer(player1Name.getText(), player1Colour.getColor(), 1);
				if (AIplayers == 3) {
					Hue player2Colour = (Hue) colorBox2.getSelectedItem();
					frameManager.createAIPlayer(player2Name.getText() + "(AI)", player2Colour.getColor(), 2, difficulty);

					Hue player3Colour = (Hue) colorBox3.getSelectedItem();
					frameManager.createAIPlayer(player3Name.getText() + "(AI)", player3Colour.getColor(), 3, difficulty);

					Hue player4Colour = (Hue) colorBox4.getSelectedItem();
					frameManager.createAIPlayer(player4Name.getText() + "(AI)", player4Colour.getColor(), 4, difficulty);
				} else if (AIplayers == 2) {
					Hue player2Colour = (Hue) colorBox2.getSelectedItem();
					frameManager.createHumanPlayer(player2Name.getText(), player2Colour.getColor(), 2);
					
					Hue player3Colour = (Hue) colorBox3.getSelectedItem();
					frameManager.createAIPlayer(player3Name.getText() + "(AI)", player3Colour.getColor(), 3, difficulty);

					Hue player4Colour = (Hue) colorBox4.getSelectedItem();
					frameManager.createAIPlayer(player4Name.getText() + "(AI)", player4Colour.getColor(), 4, difficulty);
					
				} else if (AIplayers == 1) {
					Hue player2Colour = (Hue) colorBox2.getSelectedItem();
					frameManager.createHumanPlayer(player2Name.getText(), player2Colour.getColor(), 2);

					Hue player3Colour = (Hue) colorBox3.getSelectedItem();
					frameManager.createHumanPlayer(player3Name.getText(), player3Colour.getColor(), 3);
					
					Hue player4Colour = (Hue) colorBox4.getSelectedItem();
					frameManager.createAIPlayer(player4Name.getText() + "(AI)", player4Colour.getColor(), 4, difficulty);
				} else {
				Hue player2Colour = (Hue) colorBox2.getSelectedItem();
				frameManager.createHumanPlayer(player2Name.getText(), player2Colour.getColor(), 2);

				Hue player3Colour = (Hue) colorBox3.getSelectedItem();
				frameManager.createHumanPlayer(player3Name.getText(), player3Colour.getColor(), 3);

				Hue player4Colour = (Hue) colorBox4.getSelectedItem();
				frameManager.createHumanPlayer(player4Name.getText(), player4Colour.getColor(), 4);
				}
			}
			frameManager.setPlayerNameOnBoard();
			frameManager.startingRound();
			
		} else {
			JOptionPane.showMessageDialog(null, "Invalid settings inputted! Please select valid settings for your game.", null, JOptionPane.PLAIN_MESSAGE);
		}	
	}

	public int getNumOfPlayers()
	{
		return totalPlayers;
	}
}

    

    
