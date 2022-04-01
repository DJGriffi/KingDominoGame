import java.awt.Color;
import java.util.ArrayList;
import java.io.*;

public class Player implements java.io.Serializable
{
	private String name;
	private int points, playerNumber;
	private Color colour;
	private int difficulty;              //0 for easy, 1 for hard
	private boolean AI;
	private ArrayList<Domino> dominoes;
	private boolean tookTurn;
	
	public Player(String name, Color colour, int playerNumber)
	{
		this.name=name;
		this.colour= colour;
		this.playerNumber = playerNumber;
		this.AI = false;
		tookTurn = false;
		points=0;
		dominoes = new ArrayList<>();
	}

	public Player(String name, Color colour, int playerNumber, int difficulty)
	{
		this.name=name;
		this.colour= colour;
		this.playerNumber = playerNumber;
		this.difficulty = difficulty;
		this.AI = true;
		tookTurn = false;
		points=0;
		dominoes = new ArrayList<>();
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public boolean isAI()
	{
		return AI;
	}
	
	public int getPoints() 
	{
		return points;
	}

	public void setEasy()
	{
		difficulty = 0;
	}
	
	public void setHard()
	{
		difficulty = 1;
	}
	
	public void setPoints(int points) 
	{
		this.points = points;
	}
	
	public Color getColour() 
	{
		return colour;
	}

	public void setColour(Color colour) 
	{
		this.colour = colour;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	public void addDomino(Domino domino)
	{
		dominoes.add(domino);
	}

	public boolean getTookTurn()
	{
		return tookTurn;
	}

	public void setTookTurn(boolean turnTook)
	{
		tookTurn = turnTook;
	}

	public void removeDomino(Domino dominoToRemove)
	{
		//System.out.println(dominoes.size());
		dominoes.removeIf(domino -> domino == dominoToRemove);
		//System.out.println(dominoes.size());
	}
}
