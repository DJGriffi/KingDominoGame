import java.awt.GridBagConstraints;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameModeFrame extends GameFrame 
{
	private FrameManager frameManager;
	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public GameModeFrame(FrameManager frameManager) throws IOException 
	{
		super();
		this.frameManager = frameManager;
		makeFrame();
    }

    private void makeFrame()
    {
		
		JLabel lblSelectGameMode = new JLabel("Select Game Mode");
		lblSelectGameMode.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSelectGameMode = new GridBagConstraints();
		gbc_lblSelectGameMode.weightx = 1;
		gbc_lblSelectGameMode.weighty = 1;
		gbc_lblSelectGameMode.fill = GridBagConstraints.BOTH;
		gbc_lblSelectGameMode.gridx = 7;
		gbc_lblSelectGameMode.gridy = 0;
		getContentPane().add(lblSelectGameMode, gbc_lblSelectGameMode);
		
		JButton btnNewButton = new JButton("<html><b><u>D</u>efault mode</b><p>Testing game mode!</html>");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.weighty = 1;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.ipady = 40;
		gbc_btnNewButton.gridwidth = 11;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		btnNewButton.addActionListener(e->playerSettingsSetup());
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("<html><b><u>G</u>ame mode</b><p>description</html>");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.weighty = 1;
		gbc_btnNewButton_1.ipady = 40;
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridwidth = 11;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<html><b><u>G</u>ame mode</b><p>description</html>");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.gridwidth = 11;
		gbc_btnNewButton_2.weighty = 1;
		gbc_btnNewButton_2.ipady = 40;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 8;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<html><b><u>G</u>ame mode</b><p>description</html>");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridheight = 2;
		gbc_btnNewButton_3.weighty = 1;
		gbc_btnNewButton_3.ipady = 40;
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.gridwidth = 11;
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 11;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("<html><b><u>G</u>ame mode</b><p>description</html>");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.gridwidth = 11;
		gbc_btnNewButton_4.weighty = 1;
		gbc_btnNewButton_4.ipady = 40;
		
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 14;
		getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.weightx = 0.0;
		gbc_btnNewButton_5.weighty = 1.0;
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 19;
		btnNewButton_5.addActionListener(e-> back());
		getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Help");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.weightx = 0.0;
		gbc_btnNewButton_6.weighty = 0.0;
		gbc_btnNewButton_6.gridwidth = 2;
		gbc_btnNewButton_6.gridx = 12;
		gbc_btnNewButton_6.gridy = 19;
		getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);

        setVisible(false);
	}

	private void back() 
	{
		setVisible(false);
		frameManager.showMainFrame();
		
	}
	
	private void playerSettingsSetup()
	{
		setVisible(false);
		frameManager.showPlayerSettingsFrame();
	}

}