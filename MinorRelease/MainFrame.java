import java.awt.GridBagConstraints;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainFrame extends GameFrame
{
    private JButton b1, b2, b3, b4, b5;
	private JLabel title;
	private GridBagConstraints gbc;
    private FrameManager frameManager;
	
    /**
	 * Create the frame.
     * @throws IOException
	 */
	public MainFrame(FrameManager frameManager) throws IOException 
	{	
        super();
		this.frameManager = frameManager;
        gbc = new GridBagConstraints();
		makeFrame();
	}

	private void makeFrame()
	{
		
		title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(title, gbc);
		
		b1 = new JButton("Play a Game");
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.weighty = 0.2;
		gbc.fill = GridBagConstraints.NONE;
		b1.addActionListener(e->setUp());
		getContentPane().add(b1, gbc);
		
		
		b2 = new JButton("Load a Game");
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		getContentPane().add(b2, gbc);
		
		b3 = new JButton("Settings");

		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		b3.addActionListener(e->settings());
		getContentPane().add(b3, gbc);
		
		b4 = new JButton("Quit");
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;

		getContentPane().add(b4, gbc);
		
		b5 = new JButton("Help");
		b5.setHorizontalTextPosition(SwingConstants.CENTER);
		gbc.gridx = 9;
		gbc.gridy = 10;
		gbc.gridwidth = 2;
		getContentPane().add(b5, gbc);

		setVisible(false);
	}

	private void setUp() 
	{	
		
		setVisible(false);
		frameManager.showGameModeFrame();

	}

	private void settings()
	{
		setVisible(false);
		frameManager.showSettingsFrame();
	}

}