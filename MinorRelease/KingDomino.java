import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KingDomino implements java.io.Serializable
{
	private final int DOMINOES_PER_ROUND =4;

    private FrameManager frameManager;
	private ArrayList<Domino> currentRndDominos;
	private ArrayList<Domino> nextRndDominos;
	private ArrayList<Player> players;
	private DeckOfDominos dealer;
	private int roundNum, numOfPlayers, currentPlayersTurn, previousPlayersTurn, lastRoundTracker;
	private Random rand;
	private String roundStatus;
	private Domino currentDomino;
	
	public KingDomino() throws IOException
	{
		rand = new Random();
		currentRndDominos = new ArrayList<>();
		nextRndDominos = new ArrayList<>();
		dealer = new DeckOfDominos();
		dealer.createDeck();
		players = new ArrayList<>();
		frameManager = new FrameManager(this);
        frameManager.showMainFrame();
		roundNum = 1;
		numOfPlayers = 2;
		lastRoundTracker = 0;
		roundStatus = "starting round";

	}

	public void startingRound()
	{
		numOfPlayers = frameManager.getNumOfPlayers();
		dealer.createDeckToBePlayed(frameManager.getNumOfPlayers());
		currentRndDominos = dealer.randomDominos();
		nextRndDominos = dealer.randomDominos();
		frameManager.setCurrentRndDominos(currentRndDominos);
		frameManager.setNextRndDominos(nextRndDominos);
		frameManager.setRound(roundNum);
		frameManager.setRemainingDominos(dealer.getRemainingDominos());
		currentPlayersTurn = rand.nextInt(numOfPlayers);
		frameManager.setDoThis("Select a domino from current round dominoes");
		frameManager.disableEndTurn();
		showCurrentPlayerBoard();

	}

	public void nextPlayersTurn()
	{
			if(roundStatus.equals("starting round") && currentDominosAvailable()){
				hideCurrentPlayerBoard();

				currentPlayersTurn = (currentPlayersTurn + 1) % numOfPlayers;
				showCurrentPlayerBoard(); 
			}

			else if(roundStatus.equals("place domino") && !currentDominosAvailable() && !playedDominoes()){ //place dominos
				hideCurrentPlayerBoard();
				frameManager.setCurrentDominoesVisible();
				for (Domino domino : currentRndDominos){
					if(!domino.getPlayed()){
						currentPlayersTurn = (domino.getPickedBy().getPlayerNumber()) - 1;
						domino.setPlayed(true);
						currentDomino = domino;
						break;
					}
				}
				frameManager.showRotate(currentDomino);
				frameManager.setDoThis("Rotate and place the domino");
				frameManager.disableNextRndDominoes(currentDomino);
				showCurrentPlayerBoard();
			
			}

			else if(playedDominoes() && frameManager.getRemainingDominos() > 0){
				hideCurrentPlayerBoard();
				++roundNum;
				Collections.copy(currentRndDominos, nextRndDominos);
				nextRndDominos = dealer.randomDominos();
				frameManager.setCurrentRndDominos(currentRndDominos);
				frameManager.setNextRndDominos(nextRndDominos);
				frameManager.setNextRndDominoesVisible();
				frameManager.setRound(roundNum);
				frameManager.setRemainingDominos(dealer.getRemainingDominos());
				currentDomino = currentRndDominos.get(0);
				currentDomino.setPlayed(true);
				currentPlayersTurn = (currentDomino.getPickedBy().getPlayerNumber()) - 1;
				frameManager.showRotate(currentDomino);
				frameManager.setDoThis("Rotate and place the domino");
				frameManager.disableNextRndDominoes(currentDomino);
				showCurrentPlayerBoard();
			}

			else if(frameManager.getRemainingDominos() == 0 && playedDominoes() && nextRndDominos.size() > 0){
				hideCurrentPlayerBoard();
				++roundNum;
				Collections.copy(currentRndDominos, nextRndDominos);
				frameManager.setCurrentRndDominos(currentRndDominos);
				frameManager.disableNextRndDominoesForAll();
				frameManager.setRound(roundNum);
				currentDomino = currentRndDominos.get(0);
				currentDomino.setPlayed(true);
				currentPlayersTurn = (currentDomino.getPickedBy().getPlayerNumber()) - 1;
				frameManager.showRotate(currentDomino);
				frameManager.setDoThis("Rotate and place the domino");
				frameManager.disableNextRndDominoes(currentDomino);
				nextRndDominos.clear();
				showCurrentPlayerBoard();
			}
			
			else if(frameManager.getRemainingDominos() == 0 && !playedDominoes() && nextRndDominos.size() == 0){
				previousPlayersTurn = currentPlayersTurn;
				frameManager.disableNextRndDominoesForAll();
				frameManager.setCurrentDominoesVisible();
				setRoundStatus("place domino");
				for (Domino domino : currentRndDominos){
					if(!domino.getPlayed()){
						currentPlayersTurn = (domino.getPickedBy().getPlayerNumber()) - 1;
						domino.setPlayed(true);
						currentDomino = domino;
						break;
					}
				}
				frameManager.showRotate(currentDomino);
				frameManager.setDoThis("Rotate and place the domino");
				hidePreviousPlayerBoard();
				showCurrentPlayerBoard();	
			}
		}

		public void selectNextRndDomino(int player)
		{	if (getRemainingDominos() > 0){
				int i;
				for(i = 0; i < DOMINOES_PER_ROUND; i++){
					if(nextRndDominos.get(i).getAvailable() == true){
						frameManager.enableNextRndDominoes(player, i);
					}
				}
			}
			else if (getRemainingDominos() == 0 && nextRndDominos.size() > 0){
				int i;
				for(i = 0; i < DOMINOES_PER_ROUND; i++){
					if(nextRndDominos.get(i).getAvailable() == true){
						frameManager.enableNextRndDominoes(player, i);
					}
				}
			}
			else{
				setRoundStatus("");
				frameManager.setDoThis("Press 'End Turn' to end your turn.");
				frameManager.enableEndTurn(player);
			}
		}

	private void showCurrentPlayerBoard()
	{
		if (currentPlayersTurn == 0){
			frameManager.showPlayer1GameBoard();
		}
		else if (currentPlayersTurn == 1){
			frameManager.showPlayer2GameBoard();
		}
		else if (currentPlayersTurn == 2){
			frameManager.showPlayer3GameBoard();
		}
		else if (currentPlayersTurn == 3)
		{
			frameManager.showPlayer4GameBoard();
		}
	}

	private void hideCurrentPlayerBoard()
	{
		if (currentPlayersTurn == 0){
			frameManager.hidePlayer1GameBoard();
		}
		else if (currentPlayersTurn == 1){
			frameManager.hidePlayer2GameBoard();
		}
		else if (currentPlayersTurn == 2){
			frameManager.hidePlayer3GameBoard();
		}
		else if (currentPlayersTurn == 3)
		{
			frameManager.hidePlayer4GameBoard();
		}
	}

	private void hidePreviousPlayerBoard()
	{
		if (previousPlayersTurn == 0){
			frameManager.hidePlayer1GameBoard();
		}
		else if (previousPlayersTurn == 1){
			frameManager.hidePlayer2GameBoard();
		}
		else if (previousPlayersTurn == 2){
			frameManager.hidePlayer3GameBoard();
		}
		else if (previousPlayersTurn == 3){
			frameManager.hidePlayer4GameBoard();
		}
	}

	public int getRoundNum()
	{
		return roundNum;
	}

	public void incrementRnd()
	{
		++roundNum;
	}

	public int getRemainingDominos()
	{
		return dealer.getRemainingDominos();
	}

	public void setTotalPlayers(int totalPlayers)
	{
		numOfPlayers = totalPlayers;
	}

	public void createHumanPlayer(String playerName, Color playerColor, int playerNumber)
	{
		players.add(new Player(playerName, playerColor, playerNumber));
	}
	
	public void createAIplayer(String playerName, Color playerColor, int playerNumber, int difficulty)
	{
		players.add(new Player(playerName, playerColor, playerNumber, difficulty));
	}
	
	public String getRoundStatus()
	{
		return roundStatus;
	}

	public void setRoundStatus(String roundStatus)
	{
		this.roundStatus = roundStatus;
	}

	public void addDominoToPlayer(Domino domino, int player)
	{
		if (player == 1){
			players.get(0).addDomino(domino);
			domino.setAvailable(false);
			domino.setPickedBy(players.get(0));
		}
		else if(player == 2){
			players.get(1).addDomino(domino);
			domino.setAvailable(false);
			domino.setPickedBy(players.get(1));
		}
		else if(player == 3){
			players.get(2).addDomino(domino);
			domino.setAvailable(false);
			domino.setPickedBy(players.get(2));
		}
		else if(player == 4){
			players.get(3).addDomino(domino);
			domino.setAvailable(false);
			domino.setPickedBy(players.get(3));
		}
	}

	public boolean currentDominosAvailable()
	{
		boolean available = false;
		for(Domino domino : currentRndDominos){
			if (domino.getAvailable() == true){
				available = true;
			}
		}
		return available;
	}

	private boolean playedDominoes()
	{
		boolean played = true;
		for(Domino domino : currentRndDominos){
			if (domino.getPlayed() == false){
				played = false;
			}
		}
		return played;
	}

	public ArrayList<Player> getListOfPlayers()
	{
		return players;
	}

	public Domino getCurrentDomino()
	{
		return currentDomino;
	}

	public void setPlayerTookTurn(int player, boolean turnTook)
	{
		int playa = player -1;
		players.get(playa).setTookTurn(turnTook);	
	}

	public boolean getPlayerTookTurn(int player)
	{
		int playa = player - 1;
		return players.get(playa).getTookTurn();
	}

	public boolean allPlayersTookTurn()
	{
		
		for (int i = 0; i < frameManager.getNumOfPlayers(); i++)
		{
			if (players.get(i).getTookTurn() == true)
			{
				System.out.println("" + i);
				return false;
			}
		}

		return true;
	}

	public Player highestScoringPlayer()
	{
		Player highestScoringPlayer = players.get(0);
		for (int i = 1; i < frameManager.getNumOfPlayers(); i++)
		{
			if (players.get(i).getPoints() > highestScoringPlayer.getPoints())
			{
				highestScoringPlayer = players.get(i);
			}
		}
		return highestScoringPlayer;
	}

	public void updateLastRoundTracker()
	{
		lastRoundTracker +=1;
	}

	public int lastRoundTracker()
	{
		return lastRoundTracker;
	}
	
	public int getCurrentPlayer() 
	{
		return currentPlayersTurn;
	}

	public void removeDomino()
	{
		Player player = currentDomino.getPickedBy();
		player.removeDomino(currentDomino);
	}

	public void saveGame()
	{
		Driver.saveGame();
	}

	public void loadGame()
	{
		Driver.loadGame();
	}
}