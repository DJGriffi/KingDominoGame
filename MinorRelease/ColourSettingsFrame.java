import java.awt.GridBagConstraints;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; 

public class ColourSettingsFrame extends GameFrame
{
	private FrameManager frameManager;
	private JComboBox<String> comboBox;
	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public ColourSettingsFrame(FrameManager frameManager) throws IOException 
	{
		super();
        this.frameManager = frameManager;
		makeFrame();
    }

    private void makeFrame()
    {	
		getContentPane().setBackground(getBackgroundColour());
		
		JLabel lblColourSettings = new JLabel("Colour Settings");
		lblColourSettings.setForeground(getTextColour());
		lblColourSettings.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblColourSettings = new GridBagConstraints();
		gbc_lblColourSettings.weightx = 1;
		gbc_lblColourSettings.weighty = 1;
		gbc_lblColourSettings.fill = GridBagConstraints.BOTH;
		gbc_lblColourSettings.gridx = 7;
		gbc_lblColourSettings.gridy = 0;
		getContentPane().add(lblColourSettings, gbc_lblColourSettings);


        String choices[] = {"Please select your preferred colour option", "Standard", "Zesty", "Elegant"};
        comboBox = new JComboBox<>(choices);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridheight = 2;
		gbc_comboBox.weighty = 1;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.ipady = 40;
		gbc_comboBox.gridwidth = 11;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
        comboBox.addActionListener(e-> {
			try {
				confirmColourSettings((String)comboBox.getSelectedItem());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		getContentPane().add(comboBox, gbc_comboBox);
        

        JButton backButton = new JButton("Back");
		backButton.setBackground(getButtonColour());
		backButton.setForeground(getTextColour());
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.weightx = 0.0;
		gbc_backButton.weighty = 1.0;
		gbc_backButton.gridwidth = 2;
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 19;
		backButton.addActionListener(e-> back());
		getContentPane().add(backButton, gbc_backButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.setBackground(getButtonColour());
		helpButton.setForeground(getTextColour());
		GridBagConstraints gbc_helpButton = new GridBagConstraints();
		gbc_helpButton.weightx = 0.0;
		gbc_helpButton.weighty = 0.0;
		gbc_helpButton.gridwidth = 2;
		gbc_helpButton.gridx = 12;
		gbc_helpButton.gridy = 19;
		getContentPane().add(helpButton, gbc_helpButton);

		setVisible(false);

	}

    private void confirmColourSettings(String choise) throws IOException{
        if(choise != "Please select your preferred colour option"){
            int answer = JOptionPane.showConfirmDialog(null, "Would you like to set " + choise + " as your colour settings?", "Confirmation Required", JOptionPane.YES_NO_OPTION); 
            if(answer == 0){
                changeColour(choise);
                JOptionPane.showMessageDialog(null, "Your preferred colour settings have been applied.", null, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

	private void changeColour(String colourChoise) throws IOException{
        if( colourChoise == "Standard"){
			try{
            FileWriter writer = new FileWriter("./colorConfiguration.txt");
			writer.write("standardBG standardBTN standardTXT");
			writer.close();
        }catch (Exception ex){
            return;
        }

        }

		else if( colourChoise == "Zesty"){
			try{
            FileWriter writer = new FileWriter("./colorConfiguration.txt");
			writer.write("zestyBG zestyBTN zestyTXT");
			writer.close();
        }catch (Exception ex){
            return;
        }

        }

		else if( colourChoise == "Elegant"){
			try{
            FileWriter writer = new FileWriter("./colorConfiguration.txt");
			writer.write("elegantBG elegantBTN elegantTXT");
			writer.close();
        }catch (Exception ex){
            return;
        }

        }


		setVisible(false);
		frameManager.regenerateFrames();
		frameManager.showColourSettingsFrame();
    }


	private void back() 
	{
		setVisible(false);
		frameManager.showSettingsFrame();
		
	}

}	
