import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.UIManager;

public class FrameManager implements java.io.Serializable
{
    private KingDomino kingDomino;
    private GameBoard player1GameBoard;
    private GameBoard player2GameBoard;
    private GameBoard player3GameBoard;
    private GameBoard player4GameBoard;
    private GameModeFrame gameModeFrame;
    private MainFrame mainFrame;
    private ColourSettingsFrame colourSettingsFrame;
    private SettingsFrame settingsFrame;
    private PlayerSettingsFrame playerSettingsFrame;
    private ResultsFrame resultsFrame;
    private int AIdifficulty;

    public FrameManager(KingDomino kingDomino) throws IOException
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        }   
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.kingDomino = kingDomino;
        player1GameBoard = new GameBoard(this, 1);
        player2GameBoard = new GameBoard(this, 2);
        player3GameBoard = new GameBoard(this, 3);
        player4GameBoard = new GameBoard(this, 4);
        gameModeFrame = new GameModeFrame(this);
        mainFrame = new MainFrame(this);
        colourSettingsFrame = new ColourSettingsFrame(this);
        settingsFrame = new SettingsFrame(this);
        playerSettingsFrame = new PlayerSettingsFrame(this);
        
        
    }

    public void showMainFrame()
    {
        mainFrame.makeVisible();
    }
            
    public void hideMainFrame()
    {
        mainFrame.makeInvisible();
    }

    public void showGameModeFrame()
    {
        gameModeFrame.makeVisible();
    }

    public void hideGameModeFrame()
    {
        gameModeFrame.makeInvisible();
    }

    public ArrayList<Player> getListOfPlayers()
	{
		return kingDomino.getListOfPlayers();
	}

    public Player highestScoringPlayer()
	{
		return kingDomino.highestScoringPlayer();
	}

    public void showPlayer1GameBoard()
    {
        player1GameBoard.makeVisible();
    }

    public void hidePlayer1GameBoard()
    {
        player1GameBoard.makeInvisible();
    }

    public void showPlayer2GameBoard()
    {
        player2GameBoard.makeVisible();
        if(player2GameBoard.isAIboard() == true & kingDomino.getCurrentPlayer() == 1) {
        	if(AIdifficulty==1) {
        		player2GameBoard.doHardAIaction();
        	}
        	else {
        		player2GameBoard.doAIaction();
        	}
        }
    }

    public void hidePlayer2GameBoard()
    {
        player2GameBoard.makeInvisible();
    }

    public void showPlayer3GameBoard()
    {
        player3GameBoard.makeVisible();
        if(player3GameBoard.isAIboard() == true & kingDomino.getCurrentPlayer() == 2) {
        	if(AIdifficulty==1) {
        		player3GameBoard.doHardAIaction();
        	}
        	else {
        		player3GameBoard.doAIaction();
        	}
        }
    }

    public void hidePlayer3GameBoard()
    {
        player3GameBoard.makeInvisible();
    }

    public void showPlayer4GameBoard()
    {
        player4GameBoard.makeVisible();
        if(player4GameBoard.isAIboard() == true & kingDomino.getCurrentPlayer() == 3) {
        	if(AIdifficulty==1) {
        		player4GameBoard.doHardAIaction();
        	}
        	else {
        		player4GameBoard.doAIaction();
        	}
        }
    }

    public void hidePlayer4GameBoard()
    {
        player4GameBoard.makeInvisible();
    }

    public void showColourSettingsFrame()
    {
        colourSettingsFrame.makeVisible();
    }
            
    public void hideColourSettingsFrame()
    {
        colourSettingsFrame.makeInvisible();
    }

    public void showSettingsFrame()
    {
        settingsFrame.makeVisible();
    }
            
    public void hideSettingsFrame()
    {
        settingsFrame.makeInvisible();
    }
    
    public void showPlayerSettingsFrame()
    {
    	playerSettingsFrame.makeVisible();
    }
    
    public void hidePlayerSettingsFrame()
    {
    	playerSettingsFrame.makeInvisible();
    }

    public void showResultsFrame()
    {
    	resultsFrame = new ResultsFrame(this);
    }
    
    public void hideResultsFrame()
    {
    	resultsFrame.makeInvisible();
    }

    
    
    public void regenerateFrames() throws IOException
    {
        player1GameBoard = new GameBoard(this, 1);
        player2GameBoard = new GameBoard(this, 2);
        player3GameBoard = new GameBoard(this, 3);
        player4GameBoard = new GameBoard(this, 4);
        gameModeFrame = new GameModeFrame(this);
        mainFrame = new MainFrame(this);
        colourSettingsFrame = new ColourSettingsFrame(this);
        settingsFrame = new SettingsFrame(this);
        playerSettingsFrame = new PlayerSettingsFrame(this);
    }

    public void startingRound()
    {
        kingDomino.startingRound();
    }

    public boolean allPlayersTookTurn()
	{
		return kingDomino.allPlayersTookTurn();
	}

    public void updateLastRoundTracker()
    {
        kingDomino.updateLastRoundTracker();
    }

    public int lastRoundTracker()
    {
        return kingDomino.lastRoundTracker();
    }

    public void setCurrentRndDominos(ArrayList<Domino> currentRndDominos)
    {
        player1GameBoard.setCurrentRndDominos(currentRndDominos);
        player2GameBoard.setCurrentRndDominos(currentRndDominos);
        player3GameBoard.setCurrentRndDominos(currentRndDominos);
        player4GameBoard.setCurrentRndDominos(currentRndDominos);
    }

    public void setNextRndDominos(ArrayList<Domino> currentRndDominos)
    {
        player1GameBoard.setNextRndDominos(currentRndDominos);
        player2GameBoard.setNextRndDominos(currentRndDominos);
        player3GameBoard.setNextRndDominos(currentRndDominos);
        player4GameBoard.setNextRndDominos(currentRndDominos);
    }

    public int getRoundNum()
    {
        return kingDomino.getRoundNum();
    }

    public int getRemainingDominos()
    {
        return kingDomino.getRemainingDominos();
    }

    public void setRound(int roundNum)
    {
        
        player1GameBoard.setRound(roundNum);
        player2GameBoard.setRound(roundNum);
        player3GameBoard.setRound(roundNum);
        player4GameBoard.setRound(roundNum);
    }

    public void setRemainingDominos(int dominosRemaining)
    {
        player1GameBoard.setRemainingDominos(dominosRemaining);
        player2GameBoard.setRemainingDominos(dominosRemaining);
        player3GameBoard.setRemainingDominos(dominosRemaining);
        player4GameBoard.setRemainingDominos(dominosRemaining);
    }

    public int getNumOfPlayers()
    {
        return playerSettingsFrame.getNumOfPlayers();
    }

    public void setTotalPlayers(int totalPlayers)
    {
        kingDomino.setTotalPlayers(totalPlayers);
    }

    public void createHumanPlayer(String playerName, Color playerColor, int playerNumber)
    {
        kingDomino.createHumanPlayer(playerName, playerColor, playerNumber);
    }
    
    public void createAIPlayer(String playerName, Color playerColor, int playerNumber, int difficulty)
    {
    	AIdifficulty = difficulty;
    	kingDomino.createAIplayer(playerName, playerColor, playerNumber, difficulty);
    	if(playerNumber == 1) {
    		player1GameBoard.setAsAIboard();
    	} else if (playerNumber == 2) {
    		player2GameBoard.setAsAIboard();
    	} else if (playerNumber == 3) {
    		player3GameBoard.setAsAIboard();
    	} else if (playerNumber == 4) {
    		player4GameBoard.setAsAIboard();
    	}
    }
    
    public void setPlayerNameOnBoard()
    {
        ArrayList<Player> players = kingDomino.getListOfPlayers();
        int numOfPlayers = playerSettingsFrame.getNumOfPlayers();
        int i;
        int j = 1;
        for( i = 0; i < numOfPlayers; ++i){
            if (j == 1){
                player1GameBoard.setPlayerName(players.get(i));
            }
            else if(j == 2){
                player2GameBoard.setPlayerName(players.get(i));
            }
            else if(j == 3){
                player3GameBoard.setPlayerName(players.get(i));
            }
            else if(j == 4){
                player4GameBoard.setPlayerName(players.get(i));
            }
            ++j;
        }
    }

    public String getRoundStatus()
    {
        return kingDomino.getRoundStatus();
    }

    public void addDominoToPlayer(Domino domino, int player)
    {
        kingDomino.addDominoToPlayer(domino, player);
    }

    public int getPlayerNumber(GameBoard gameBoard)
    {
        int playersNumber = 0;

        if (gameBoard == player1GameBoard){
            playersNumber = 1;
        }
        else if(gameBoard == player2GameBoard){
            playersNumber = 2;
        }
        else if(gameBoard == player3GameBoard){
            playersNumber = 3;
        }
        else if(gameBoard == player4GameBoard){
            playersNumber = 4;
        }
        return playersNumber;
    }

    public void setCurrentDomino1Invisible()
    {
        player1GameBoard.setCurrentDomino1Invisible();
        player2GameBoard.setCurrentDomino1Invisible();
        player3GameBoard.setCurrentDomino1Invisible();
        player4GameBoard.setCurrentDomino1Invisible();
    }

    public void setCurrentDomino2Invisible()
    {
        player1GameBoard.setCurrentDomino2Invisible();
        player2GameBoard.setCurrentDomino2Invisible();
        player3GameBoard.setCurrentDomino2Invisible();
        player4GameBoard.setCurrentDomino2Invisible();
    }

    public void setCurrentDomino3Invisible()
    {
        player1GameBoard.setCurrentDomino3Invisible();
        player2GameBoard.setCurrentDomino3Invisible();
        player3GameBoard.setCurrentDomino3Invisible();
        player4GameBoard.setCurrentDomino3Invisible();
    }

    public void setCurrentDomino4Invisible()
    {
        player1GameBoard.setCurrentDomino4Invisible();
        player2GameBoard.setCurrentDomino4Invisible();
        player3GameBoard.setCurrentDomino4Invisible();
        player4GameBoard.setCurrentDomino4Invisible();
    }

    public void setNextDomino1Invisible()
    {
        player1GameBoard.setNextDomino1Invisible();
        player2GameBoard.setNextDomino1Invisible();
        player3GameBoard.setNextDomino1Invisible();
        player4GameBoard.setNextDomino1Invisible();
    }

    public void setNextDomino2Invisible()
    {
        player1GameBoard.setNextDomino2Invisible();
        player2GameBoard.setNextDomino2Invisible();
        player3GameBoard.setNextDomino2Invisible();
        player4GameBoard.setNextDomino2Invisible();
    }

    public void setNextDomino3Invisible()
    {
        player1GameBoard.setNextDomino3Invisible();
        player2GameBoard.setNextDomino3Invisible();
        player3GameBoard.setNextDomino3Invisible();
        player4GameBoard.setNextDomino3Invisible();
    }

    public void setNextDomino4Invisible()
    {
        player1GameBoard.setNextDomino4Invisible();
        player2GameBoard.setNextDomino4Invisible();
        player3GameBoard.setNextDomino4Invisible();
        player4GameBoard.setNextDomino4Invisible();
    }

    public void setNextRndDominoesVisible()
    {
        player1GameBoard.setNextRndDominoesVisible();
        player2GameBoard.setNextRndDominoesVisible();
        player3GameBoard.setNextRndDominoesVisible();
        player4GameBoard.setNextRndDominoesVisible();
    }

    public void nextPlayersTurn()
    {

        kingDomino.nextPlayersTurn();
    }

    public void setDoThis(String thisThing)
    {
        player1GameBoard.setDoThis(thisThing);
        player2GameBoard.setDoThis(thisThing);
        player3GameBoard.setDoThis(thisThing);
        player4GameBoard.setDoThis(thisThing);

    }

    public void setCurrentDominoesVisible()
    {
        player1GameBoard.setCurrentDominoesVisible();
        player2GameBoard.setCurrentDominoesVisible();
        player3GameBoard.setCurrentDominoesVisible();
        player4GameBoard.setCurrentDominoesVisible();
    }
    
    public void showRotate(Domino domino)
    {
        int player = domino.getPickedBy().getPlayerNumber();
        if (player == 1){
            player1GameBoard.showRotate(domino);
        }
        else if(player == 2){
            player2GameBoard.showRotate(domino);
        }
        else if(player == 3){
            player3GameBoard.showRotate(domino);
        }
        else if(player == 4){
            player4GameBoard.showRotate(domino);
        }
    }

    public boolean currentDominosAvailable()
    {
        return kingDomino.currentDominosAvailable();
    }

    public void disableNextRndDominoes(Domino domino)
    {
        int player = domino.getPickedBy().getPlayerNumber();
        if (player == 1){
            player1GameBoard.disableNextRndDominoes();
        }
        else if(player == 2){
            player2GameBoard.disableNextRndDominoes();
        }
        else if(player == 3){
            player3GameBoard.disableNextRndDominoes();
        }
        else if(player == 4){
            player4GameBoard.disableNextRndDominoes();
        }
    }

    public void disableNextRndDominoesForAll()
    {
        player1GameBoard.disableNextRndDominoes();
        player2GameBoard.disableNextRndDominoes();
        player3GameBoard.disableNextRndDominoes();
        player4GameBoard.disableNextRndDominoes();
    }

    public void selectNextRndDomino(int player)
    {
            kingDomino.selectNextRndDomino(player);
    }

    public void enableNextRndDominoes(int player, int i)
    {
        if (player == 1){

            if(i == 0){
                player1GameBoard.enableNextRndDominoes1();
            }
            else if(i == 1){
                player1GameBoard.enableNextRndDominoes2();
            }
            else if(i == 2){
                player1GameBoard.enableNextRndDominoes3();
            }
            else if(i == 3){
                player1GameBoard.enableNextRndDominoes4();
            }
            player1GameBoard.setDoThis("Select domino from 'next round' pile");
        }
        else if(player == 2){

            if(i == 0){
                player2GameBoard.enableNextRndDominoes1();
            }
            else if(i == 1){
                player2GameBoard.enableNextRndDominoes2();
            }
            else if(i == 2){
                player2GameBoard.enableNextRndDominoes3();
            }
            else if(i == 3){
                player2GameBoard.enableNextRndDominoes4();
            }

            player2GameBoard.setDoThis("Select domino from 'next round' pile");
        }
        else if(player == 3){
    
            if(i == 0){
                player3GameBoard.enableNextRndDominoes1();
            }
            else if(i == 1){
                player3GameBoard.enableNextRndDominoes2();
            }
            else if(i == 2){
                player3GameBoard.enableNextRndDominoes3();
            }
            else if(i == 3){
                player3GameBoard.enableNextRndDominoes4();
            }
            player3GameBoard.setDoThis("Select domino from 'next round' pile");
        }
        else if(player == 4){
  
            if(i == 0){
                player4GameBoard.enableNextRndDominoes1();
            }
            else if(i == 1){
                player4GameBoard.enableNextRndDominoes2();
            }
            else if(i == 2){
                player4GameBoard.enableNextRndDominoes3();
            }
            else if(i == 3){
                player4GameBoard.enableNextRndDominoes4();
            }
            player4GameBoard.setDoThis("Select domino from 'next round' pile");
        }
    }

    public Domino getCurrentDomino()
    {
        return kingDomino.getCurrentDomino();
    }

    public void disableEndTurn()
    {
        player1GameBoard.disableEndTurn();
        player2GameBoard.disableEndTurn();
        player3GameBoard.disableEndTurn();
        player4GameBoard.disableEndTurn();
    }

    public void enableEndTurn(int player)
    {
        if (player == 1){
            player1GameBoard.enableEndTurn();
        }

        else if (player == 2){
            player2GameBoard.enableEndTurn();
        }
        else if (player == 3){
            player3GameBoard.enableEndTurn();
        }
        else if (player == 4){
            player4GameBoard.enableEndTurn();
        }
    }

    public boolean getPlayerTookTurn(int player)
    {
        return kingDomino.getPlayerTookTurn(player);
    }
    
    public void setPlayerTookTurn(int player, boolean turnTook)
    {
        kingDomino.setPlayerTookTurn(player, turnTook);
    }

    public void setRoundStatus(String roundStatus)
    {
        kingDomino.setRoundStatus(roundStatus);
    }

    public void removeDomino()
    {
        kingDomino.removeDomino();
    }

    public void saveGame()
    {
        kingDomino.saveGame();
    }

    public void loadGame()
    {
        kingDomino.loadGame();
    }

    public void reset() throws IOException
    {
        player1GameBoard = null;
        player2GameBoard = null;
        player3GameBoard = null;
        player4GameBoard = null;
        gameModeFrame = null;
        mainFrame = null;
        colourSettingsFrame = null;
        settingsFrame = null;
        playerSettingsFrame = null;
        kingDomino.reset();
    }
}
