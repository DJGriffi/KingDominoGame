import java.awt.GridBagConstraints;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SettingsFrame extends GameFrame 
{
	private FrameManager frameManager;
	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public SettingsFrame(FrameManager frameManager) throws IOException 
	{
		super();
        this.frameManager = frameManager;
		makeFrame();
    }

    private void makeFrame()
    {
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSettings = new GridBagConstraints();
		gbc_lblSettings.weightx = 1;
		gbc_lblSettings.weighty = 1;
		gbc_lblSettings.fill = GridBagConstraints.BOTH;
		gbc_lblSettings.gridx = 7;
		gbc_lblSettings.gridy = 0;
		getContentPane().add(lblSettings, gbc_lblSettings);
		
		JButton btnNewButton = new JButton("<html><b><u>C</u>olour Settings</b><p>Select between different colour profiles available for the game</html>");
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
        btnNewButton.addActionListener(e-> colourSettingsSetUp());
		getContentPane().add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_1 = new JButton("Back");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.weightx = 0.0;
		gbc_btnNewButton_1.weighty = 1.0;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 19;
		btnNewButton_1.addActionListener(e-> back());
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Help");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.weightx = 0.0;
		gbc_btnNewButton_2.weighty = 0.0;
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.gridx = 12;
		gbc_btnNewButton_2.gridy = 19;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);

		setVisible(false);

	}

    private void colourSettingsSetUp() 
	{	

		setVisible(false);
		frameManager.showColourSettingsFrame();
	}

	private void back() 
	{
		setVisible(false);
		frameManager.showMainFrame();
		
	}

}