import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame
{
    private JButton b1, b2, b3, b4, b5;
	private JLabel title;
	private GridBagConstraints gbc = new GridBagConstraints();
	
    /**
	 * Create the frame.
	 */
	public MainFrame() 
	{	
		setBounds(100, 100, 700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());
		//makeFrame();
	}

	public void makeFrame()
	{
		title = new JLabel("KingDomino");
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
		GameSetupFrame setupFrame = new GameSetupFrame();
		setVisible(false);
		setupFrame.makeVisible();
	}
	
	public void makeVisible()
	{
		setVisible(true);
	}

	public void makeInvisible()
	{
		setVisible(false);
	}

}