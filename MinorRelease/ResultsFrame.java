import java.awt.*;    
import java.util.*;    
import javax.swing.*;  
  
    
public class ResultsFrame extends JFrame
{    
    private Button buttons[];
    private FrameManager frameManager;
    private ArrayList<Player> players;

    public ResultsFrame(FrameManager frameManager)
    {
        super();
        buttons = new Button [5];
        this.frameManager = frameManager;
        makeFrame();
    }

    public void makeFrame()
    {   
        players = frameManager.getListOfPlayers();
        for (int i = 0;i<frameManager.getNumOfPlayers();i++) 
        {
            buttons[i] = new Button ("" + players.get(i).getName() + " score : " + players.get(i).getPoints());   
            add (buttons[i]);    
        }
        buttons[4] = new Button (frameManager.highestScoringPlayer().getName() + " Wins!");
        add(buttons[4]);
        setLayout (new BoxLayout (getContentPane(), BoxLayout.Y_AXIS));    
        setSize(400,400);    
        setVisible(true); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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