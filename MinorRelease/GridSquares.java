import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import javax.swing.JButton;

public class GridSquares extends JButton implements java.io.Serializable
{
    
    private int xcoord, ycoord, crowns;

    public GridSquares(int y, int x)
    {
        super();
        xcoord = x;
        ycoord = y;
        crowns = 0;
        setPreferredSize(new Dimension(40,40));
        setMinimumSize(new Dimension(40,40));
        setMaximumSize(new Dimension(40,40));
        setSize(new Dimension(40,40));
        setBackground(Color.WHITE);
        setOpaque(true);
        setBorderPainted(false);
    }

    public int getXCoord()  {return xcoord;}
    public int getYCoord()  {return ycoord;}
    public void setCrowns(int crownCount)  
    {
        crowns = crownCount;
    }
    public int getCrowns()  {return crowns;}
}