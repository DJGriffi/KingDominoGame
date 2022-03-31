import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameBoard extends GameFrame implements ActionListener
{
    private GridSquares [][] gridSquares;	// squares to appear in grid formation
    private final int COLUMNS = 9;
    private final int ROWS = 9;
    private int topMostDominoRow;
    private int bottomMostDominoRow;
    private int leftMostDominoColumn;
    private int rightMostDominoColumn;
    private int playerNum;
    private Random rand;
    private JPanel rightPanel, topPanel, centerPanel, bottomPanel;
    private JLabel round, whoTurn, doThis, dominosLeft;
    private JButton rotateTile2, rotateTile4, rotateTile5, rotateTile6, rotateTile8;
	private JButton leftRotate, rightRotate, discardDomino, endTurn;
    private JButton currentTile11, currentTile12, currentTile21, currentTile22, currentTile31, currentTile32, currentTile41, currentTile42;
    private JButton nextRndTile11, nextRndTile12, nextRndTile21, nextRndTile22, nextRndTile31, nextRndTile32, nextRndTile41, nextRndTile42; 
    private FrameManager frameManager;
    private ArrayList<Domino> currentDominos;
    private ArrayList<Domino> nextDominos; 
    private boolean AIboard;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public GameBoard(FrameManager frameManager, int playerNum) throws IOException
    {
        super();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frameManager = frameManager;
        this.playerNum = playerNum;
        this.AIboard = false;
        rand = new Random();
        topMostDominoRow = 4;
        bottomMostDominoRow = 4;
        leftMostDominoColumn = 4;
        rightMostDominoColumn = 4;
        //setBounds(100, 100, 2000, 1500);
        getContentPane().setLayout(new BorderLayout());
        makeBoard();
    }
    
    private void makeBoard() throws IOException
    {
        /***********************************************/
        /*Create panel to the right of the playing area*/
        rightPanel = new JPanel();
        //rightPanel.setPreferredSize(new Dimension(700,1500));
        rightPanel.setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height));
        rightPanel.setLayout(new BorderLayout());

        /****************************************************/
        /* Creating top panel with currentDominos round information*/
        topPanel = new JPanel();
        //topPanel.setPreferredSize(new Dimension(650,60));
        topPanel.setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height * 2/20));
        topPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        JPanel topLeft = new JPanel();
        //topLeft.setPreferredSize(new Dimension(125,20));
        //topLeft.setPreferredSize(new Dimension(screenSize.width * 3/8 * 2/9, screenSize.height * 1/9));
        topLeft.setLayout(new BoxLayout(topLeft, BoxLayout.Y_AXIS));
        round = new JLabel("Round #: 0");
        round.setHorizontalAlignment(SwingConstants.LEFT);
        topLeft.add(round);
        round.setAlignmentX(Component.LEFT_ALIGNMENT);
        topPanel.add(topLeft);


        JPanel topCenter = new JPanel();
        //topCenter.setPreferredSize(new Dimension(screenSize.width * 3/8 * 5/9, screenSize.height * 1/9));
        //topCenter.setPreferredSize(new Dimension(400,50));
        whoTurn = new JLabel("Player One's turn");
        doThis = new JLabel("Do this thing this turn");
        topCenter.add(whoTurn);
        topCenter.add(doThis);
        topPanel.add(topCenter);

        JPanel topRight = new JPanel();
        //topRight.setPreferredSize(new Dimension(150,20));
        //topRight.setPreferredSize(new Dimension(screenSize.width * 3/8 * 2/9, screenSize.height * 1/9));
        topRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
        dominosLeft = new JLabel("Dominos remaining: 0");
        topRight.add(dominosLeft);
        topPanel.add(topRight);

        rightPanel.add(topPanel, BorderLayout.NORTH);

        /*****************************************************************/
        /* Creating bottom panel to hold the 'End Turn' and 'Quit' Buttons*/
        bottomPanel = new JPanel();
        setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height * 1/20));
        //bottomPanel.setPreferredSize(new Dimension(650,60));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        //bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
/*
        JButton quit = new JButton("Quit");
        quit.setAlignmentX(Component.LEFT_ALIGNMENT);
        quit.addActionListener(e-> quit());
        bottomPanel.add(quit);
*/
        //Dimension minSize = new Dimension(40, 50);
        //Dimension prefSize = new Dimension(40, 50);
        //Dimension maxSize = new Dimension(40, 50);
/*      bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        JButton viewPlayer1 = new JButton("View Player 1");
        viewPlayer1.addActionListener(e -> viewPlayer1() );
        bottomPanel.add(viewPlayer1);

        bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        JButton viewPlayer2 = new JButton("View Player 2");
        viewPlayer2.addActionListener(e -> viewPlayer2() );
        bottomPanel.add(viewPlayer2);

        bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        //JButton viewPlayer3 = new JButton("View Player 3");
        //viewPlayer3.addActionListener(e -> viewPlayer3() );
        //bottomPanel.add(viewPlayer3);

        //bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        //JButton viewPlayer4 = new JButton("View Player 4");
        //viewPlayer4.addActionListener(e -> viewPlayer4() );
        //bottomPanel.add(viewPlayer4);
*/
        //Dimension minSize = new Dimension(screenSize.width * 1/20, screenSize.height * 1/20);
        //Dimension prefSize = new Dimension(screenSize.width * 1/20, screenSize.height * 1/20);
        //Dimension maxSize = new Dimension(screenSize.width * 1/20, screenSize.height * 1/20);

        //bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));
      
        discardDomino = new JButton("Discard domino");
        discardDomino.addActionListener(e -> discardDomino(frameManager.getCurrentDomino()));
        bottomPanel.add(discardDomino);
        //bottomPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        Dimension minSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);
        Dimension prefSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);
        Dimension maxSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);

        bottomPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        endTurn = new JButton("End Turn");
        //endTurn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        endTurn.addActionListener(this);
        bottomPanel.add(endTurn);
        
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        /*******************************************************/
        /*Creating panel to hold the buttons to rotate the tile*/
        JPanel rightCenterPanel = new JPanel();
        rightCenterPanel.setLayout(new BorderLayout());

        JPanel rightCenterTopPanel = new JPanel();
        setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height * 1/20));
        //rightCenterTopPanel.setPreferredSize(new Dimension(650,40));
        rightCenterTopPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        //minSize = new Dimension(210, 30);
        //prefSize = new Dimension(210, 30);
        //maxSize = new Dimension(210, 30);

        //rightCenterTopPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        leftRotate = new JButton("Left");
        leftRotate.addActionListener(e-> rotateLeft(frameManager.getCurrentDomino()));
        rightCenterTopPanel.add(leftRotate);

        JLabel rotate = new JLabel("Rotate Tiles");
        rightCenterTopPanel.add(rotate);

        rightRotate = new JButton("Right");
        rightRotate.addActionListener(e-> rotateRight(frameManager.getCurrentDomino()));
        rightCenterTopPanel.add(rightRotate);

        //minSize = new Dimension(50, 30);
        //prefSize = new Dimension(50, 30);
        //maxSize = new Dimension(50, 30);
        //rightCenterTopPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        //discardDomino = new JButton("Discard domino");
        //discardDomino.addActionListener(e -> discardDomino(frameManager.getCurrentDomino()));
        //rightCenterTopPanel.add(discardDomino);

        rightCenterPanel.add(rightCenterTopPanel, BorderLayout.NORTH);

        /***********************************************************************/
        /*Creating new panel with border layout to be nested in center position*/
        JPanel rightCenterCenterPanel = new JPanel();
        rightCenterCenterPanel.setLayout(new BorderLayout());
        
        /*********************************************************************/
        /**************Creating panel to show rotating tiles******************/
        JPanel rightCenterCenterTopPanel = new JPanel();
        rightCenterCenterTopPanel.setLayout(new BorderLayout());
        
        JPanel rightCenterCenterTopCenterPanel = new JPanel();
        //rightCenterCenterTopCenterPanel.setPreferredSize(new Dimension(550,300));
        rightCenterCenterTopCenterPanel.setPreferredSize(new Dimension(screenSize.width *1/3 * 1/2, screenSize.height * 5/20));
        rightCenterCenterTopCenterPanel.setLayout(new GridLayout(3,3,2,2));
        JButton rotateTile1 = new JButton();
        rotateTile1.setPreferredSize(new Dimension(50,50));
        rotateTile1.setMaximumSize(new Dimension(50,50));
        rotateTile1.setBackground(getBackgroundColour());
        rotateTile1.setOpaque(true);
        rotateTile1.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile1);

        rotateTile2 = new JButton();
        rotateTile2.setPreferredSize(new Dimension(50,50));
        rotateTile2.setMaximumSize(new Dimension(50,50));
        rotateTile2.setBackground(Color.WHITE);
        rotateTile2.setOpaque(true);
        rotateTile2.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile2);

        JButton rotateTile3 = new JButton();
        rotateTile3.setPreferredSize(new Dimension(50,50));
        rotateTile3.setMaximumSize(new Dimension(50,50));
        rotateTile3.setBackground(getBackgroundColour());
        rotateTile3.setOpaque(true);
        rotateTile3.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile3);

        rotateTile4 = new JButton();
        rotateTile4.setPreferredSize(new Dimension(50,50));
        rotateTile4.setMaximumSize(new Dimension(50,50));
        rotateTile4.setBackground(Color.WHITE);
        rotateTile4.setOpaque(true);
        rotateTile4.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile4);

        rotateTile5 = new JButton();
        rotateTile5.setPreferredSize(new Dimension(50,50));
        rotateTile5.setMaximumSize(new Dimension(50,50));
        rotateTile5.setBackground(Color.WHITE);
        rotateTile5.setOpaque(true);
        rotateTile5.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile5);

        rotateTile6 = new JButton();
        rotateTile6.setPreferredSize(new Dimension(50,50));
        rotateTile6.setMaximumSize(new Dimension(50,50));
        rotateTile6.setBackground(Color.WHITE);
        rotateTile6.setOpaque(true);
        rotateTile6.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile6);

        JButton rotateTile7 = new JButton();
        rotateTile7.setPreferredSize(new Dimension(50,50));
        rotateTile7.setMaximumSize(new Dimension(50,50));
        rotateTile7.setBackground(getBackgroundColour());
        rotateTile7.setOpaque(true);
        rotateTile7.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile7);

        rotateTile8 = new JButton();
        rotateTile8.setPreferredSize(new Dimension(50,50));
        rotateTile8.setMaximumSize(new Dimension(50,50));
        rotateTile8.setBackground(Color.WHITE);
        rotateTile8.setOpaque(true);
        rotateTile8.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile8);

        JButton rotateTile9 = new JButton();
        rotateTile9.setPreferredSize(new Dimension(50,50));
        rotateTile9.setMaximumSize(new Dimension(50,50));
        rotateTile9.setBackground(getBackgroundColour());
        rotateTile9.setOpaque(true);
        rotateTile9.setBorderPainted(false);
        rightCenterCenterTopCenterPanel.add(rotateTile9);

        JPanel eastFiller = new JPanel();
        JPanel westFiller = new JPanel();
        Dimension topCCMinSize = new Dimension(screenSize.width * 1/4 * 1/3, screenSize.height * 5/20);
        Dimension topCCPrefSize = new Dimension(screenSize.width * 1/4 * 1/3, screenSize.height * 5/20);
        Dimension topCCMaxSize = new Dimension(screenSize.width * 1/4 * 1/3, screenSize.height * 5/20);//150,200
        eastFiller.add(new Box.Filler(topCCMinSize, topCCPrefSize, topCCMaxSize));
        westFiller.add(new Box.Filler(topCCMinSize, topCCPrefSize, topCCMaxSize));
        rightCenterCenterTopPanel.add(eastFiller, BorderLayout.EAST);
        rightCenterCenterTopPanel.add(westFiller, BorderLayout.WEST);
        
        rightCenterCenterTopPanel.add(rightCenterCenterTopCenterPanel, BorderLayout.CENTER);

        /*********************************************************************/
        /**Create panel to hold the currentDominos round tiles and next round tiles**/
        JPanel rightCenterCenterTopBottomPanel = new JPanel();
        //rightCenterCenterTopBottomPanel.setPreferredSize(new Dimension(550,60));
        rightCenterCenterTopBottomPanel.setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height * 1/20));
        rightCenterCenterTopBottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        JLabel currentRndTiles = new JLabel("Current Round Dominoes");
        rightCenterCenterTopBottomPanel.add(currentRndTiles);
        Dimension label1MinSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);
        Dimension label1PrefSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);
        Dimension label1MaxSize = new Dimension(screenSize.width * 3/8 * 2/5, screenSize.height * 1/20);
        rightCenterCenterTopBottomPanel.add(new Box.Filler(label1MinSize, label1PrefSize, label1MaxSize));
        JLabel nextRndTiles = new JLabel("Next Round Dominoes");
        rightCenterCenterTopBottomPanel.add(nextRndTiles);

        rightCenterCenterTopPanel.add(rightCenterCenterTopBottomPanel, BorderLayout.SOUTH);
        rightCenterCenterPanel.add(rightCenterCenterTopPanel, BorderLayout.NORTH);

        JPanel rightCenterCenterLeftPanel = new JPanel();
        rightCenterCenterLeftPanel.setPreferredSize(new Dimension(30,screenSize.height * 11/20));

        Dimension playerIconMinSize = new Dimension(5, 15);//20
        Dimension playerIconPrefSize = new Dimension(5, 15);
        Dimension playerIconMaxSize = new Dimension(5, 15);
        rightCenterCenterLeftPanel.add(new Box.Filler(playerIconMinSize, playerIconPrefSize, playerIconMaxSize));

        Dimension playerIconMinSize1 = new Dimension(5, 40);
        Dimension playerIconPrefSize1 = new Dimension(5, 40);
        Dimension playerIconMaxSize1 = new Dimension(5, 40);
        rightCenterCenterLeftPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterLeftPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterLeftPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterPanel.add(rightCenterCenterLeftPanel, BorderLayout.WEST);

        JPanel rightCenterCenterRightPanel = new JPanel();
        rightCenterCenterRightPanel.setPreferredSize(new Dimension(30,screenSize.height * 11/20));

        rightCenterCenterRightPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterRightPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterRightPanel.add(new Box.Filler(playerIconMinSize1, playerIconPrefSize1, playerIconMaxSize1));

        rightCenterCenterPanel.add(rightCenterCenterRightPanel, BorderLayout.EAST);

        JPanel rightCenterCenterCenterPanel = new JPanel();
        rightCenterCenterCenterPanel.setLayout(new GridLayout(4,5,2,2));
        rightCenterCenterCenterPanel.setPreferredSize(new Dimension(screenSize.width * 3/8, screenSize.height * 11/20));
        //rightCenterCenterCenterPanel.setPreferredSize(new Dimension(500, 600));

        currentTile11 = new JButton();
        currentTile11.setPreferredSize(new Dimension(50,50));
        currentTile11.setMaximumSize(new Dimension(50,50));
        currentTile11.setBackground(Color.WHITE);
        currentTile11.setOpaque(true);
        currentTile11.setBorderPainted(false);
        currentTile11.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile11);

        currentTile12 = new JButton();
        currentTile12.setPreferredSize(new Dimension(50,50));
        currentTile12.setBackground(Color.WHITE);
        currentTile12.setOpaque(true);
        currentTile12.setBorderPainted(false);
        currentTile12.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile12);

        Dimension tile1MinSize = new Dimension(50, 50);//200
        Dimension tile1PrefSize = new Dimension(50, 50);//200
        Dimension tile1MaxSize = new Dimension(50, 50);//Short.MAX_VALUE
        rightCenterCenterCenterPanel.add(new Box.Filler(tile1MinSize, tile1PrefSize, tile1MaxSize));

        nextRndTile11 = new JButton();
        nextRndTile11.setPreferredSize(new Dimension(50,50));
        nextRndTile11.setBackground(Color.WHITE);
        nextRndTile11.setOpaque(true);
        nextRndTile11.setBorderPainted(false);
        nextRndTile11.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile11);

        nextRndTile12 = new JButton();
        nextRndTile12.setPreferredSize(new Dimension(50,50));
        nextRndTile12.setBackground(Color.WHITE);
        nextRndTile12.setOpaque(true);
        nextRndTile12.setBorderPainted(false);
        nextRndTile12.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile12);

        currentTile21 = new JButton();
        currentTile21.setPreferredSize(new Dimension(50,50));
        currentTile21.setBackground(Color.WHITE);
        currentTile21.setOpaque(true);
        currentTile21.setBorderPainted(false);
        currentTile21.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile21);

        currentTile22 = new JButton();
        currentTile22.setPreferredSize(new Dimension(50,50));
        currentTile22.setBackground(Color.WHITE);
        currentTile22.setOpaque(true);
        currentTile22.setBorderPainted(false);
        currentTile22.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile22);

        rightCenterCenterCenterPanel.add(new Box.Filler(tile1MinSize, tile1PrefSize, tile1MaxSize));

        nextRndTile21 = new JButton();
        nextRndTile21.setPreferredSize(new Dimension(50,50));
        nextRndTile21.setBackground(Color.WHITE);
        nextRndTile21.setOpaque(true);
        nextRndTile21.setBorderPainted(false);
        nextRndTile21.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile21);

        nextRndTile22 = new JButton();
        nextRndTile22.setPreferredSize(new Dimension(50,50));
        nextRndTile22.setBackground(Color.WHITE);
        nextRndTile22.setOpaque(true);
        nextRndTile22.setBorderPainted(false);
        nextRndTile22.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile22);

        currentTile31 = new JButton();
        currentTile31.setPreferredSize(new Dimension(50,50));
        currentTile31.setBackground(Color.WHITE);
        currentTile31.setOpaque(true);
        currentTile31.setBorderPainted(false);
        currentTile31.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile31);

        currentTile32 = new JButton();
        currentTile32.setPreferredSize(new Dimension(50,50));
        currentTile32.setBackground(Color.WHITE);
        currentTile32.setOpaque(true);
        currentTile32.setBorderPainted(false);
        currentTile32.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile32);

        rightCenterCenterCenterPanel.add(new Box.Filler(tile1MinSize, tile1PrefSize, tile1MaxSize));

        nextRndTile31 = new JButton();
        nextRndTile31.setPreferredSize(new Dimension(50,50));
        nextRndTile31.setBackground(Color.WHITE);
        nextRndTile31.setOpaque(true);
        nextRndTile31.setBorderPainted(false);
        nextRndTile31.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile31);

        nextRndTile32 = new JButton();
        nextRndTile32.setPreferredSize(new Dimension(50,50));
        nextRndTile32.setBackground(Color.WHITE);
        nextRndTile32.setOpaque(true);
        nextRndTile32.setBorderPainted(false);
        nextRndTile32.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile32);

        currentTile41 = new JButton();
        currentTile41.setPreferredSize(new Dimension(50,50));
        currentTile41.setBackground(Color.WHITE);
        currentTile41.setOpaque(true);
        currentTile41.setBorderPainted(false);
        currentTile41.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile41);

        currentTile42 = new JButton();
        currentTile42.setPreferredSize(new Dimension(50,50));
        currentTile42.setBackground(Color.WHITE);
        currentTile42.setOpaque(true);
        currentTile42.setBorderPainted(false);
        currentTile42.addActionListener(this);
        rightCenterCenterCenterPanel.add(currentTile42);

        rightCenterCenterCenterPanel.add(new Box.Filler(tile1MinSize, tile1PrefSize, tile1MaxSize));

        nextRndTile41 = new JButton();
        nextRndTile41.setPreferredSize(new Dimension(50,50));
        nextRndTile41.setBackground(Color.WHITE);
        nextRndTile41.setOpaque(true);
        nextRndTile41.setBorderPainted(false);
        nextRndTile41.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile41);

        nextRndTile42 = new JButton();
        nextRndTile42.setPreferredSize(new Dimension(50,50));
        nextRndTile42.setBackground(Color.WHITE);
        nextRndTile42.setOpaque(true);
        nextRndTile42.setBorderPainted(false);
        nextRndTile42.addActionListener(this);
        rightCenterCenterCenterPanel.add(nextRndTile42);

        rightCenterCenterPanel.add(rightCenterCenterCenterPanel, BorderLayout.CENTER);
        rightCenterPanel.add(rightCenterCenterPanel, BorderLayout.CENTER);
        
        rightPanel.add(rightCenterPanel, BorderLayout.CENTER);

        getContentPane().add(rightPanel, BorderLayout.EAST);

        centerPanel = new JPanel();
        //centerPanel.setBounds(100, 100, 1300, 1500);
        //centerPanel.setPreferredSize(new Dimension(1300, 1500));
        centerPanel.setPreferredSize(new Dimension(screenSize.width * 5/8, screenSize.height));
        centerPanel.setLayout(new GridLayout(ROWS,COLUMNS,2,2));
        addGridSquares();
        getContentPane().add(centerPanel, BorderLayout.WEST);

        //setPlayerNum();
        Image startingTile = ImageIO.read(getClass().getResource("/images/StartingTile.png"));
        startingTile = startingTile.getScaledInstance(185, 110, java.awt.Image.SCALE_SMOOTH);
        gridSquares[4][4].setIcon(new ImageIcon(startingTile));
        gridSquares[4][4].setBackground(Color.BLACK);

        makeMenuBar();
        pack();
        setVisible(false);

    }
	
    private void makeMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e->save());
        fileMenu.add(saveItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e->quit());
        fileMenu.add(quitItem);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        JMenuItem viewPlayer1 = new JMenuItem("View Player 1");
        viewPlayer1.addActionListener(e -> viewPlayer1());
        viewMenu.add(viewPlayer1);

        JMenuItem viewPlayer2 = new JMenuItem("View Player 2");
        viewPlayer2.addActionListener(e -> viewPlayer2());
        viewMenu.add(viewPlayer2);

        JMenuItem viewPlayer3 = new JMenuItem("View Player 3");
        viewPlayer3.addActionListener(e -> viewPlayer3());
        viewMenu.add(viewPlayer3);

        JMenuItem viewPlayer4 = new JMenuItem("View Player 4");
        viewPlayer4.addActionListener(e -> viewPlayer4());
        viewMenu.add(viewPlayer4);
    }
    
    public void actionPerformed(ActionEvent e)
    {	
		Domino current;
		Domino next;

        if (frameManager.getRoundStatus().equals("starting round") && frameManager.currentDominosAvailable() && !(frameManager.getPlayerTookTurn(frameManager.getPlayerNumber(this)))){
		    if ((e.getSource() == currentTile11) || (e.getSource() == currentTile12)){
			    current = currentDominos.get(0);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                frameManager.setCurrentDomino1Invisible();
                setDoThis("Press 'End Turn' to end your turn.");
                //endTurn();
                //frameManager.nextPlayersTurn();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                enableEndTurn();
		    }

		    else if ((e.getSource() == currentTile21) || (e.getSource() == currentTile22)){
			    current = currentDominos.get(1);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                frameManager.setCurrentDomino2Invisible(); 
                setDoThis("Press 'End Turn' to end your turn.");
                //endTurn();
                //frameManager.nextPlayersTurn();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                enableEndTurn();
		    }

		    else if ((e.getSource() == currentTile31) || (e.getSource() == currentTile32)){
			    current = currentDominos.get(2);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                frameManager.setCurrentDomino3Invisible();
                setDoThis("Press 'End Turn' to end your turn.");
                //endTurn();
                //frameManager.nextPlayersTurn();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                enableEndTurn();
		    }

		    else if ((e.getSource() == currentTile41) || (e.getSource() == currentTile42)){
			    current = currentDominos.get(3);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                frameManager.setCurrentDomino4Invisible();
                setDoThis("Press 'End Turn' to end your turn.");
                //endTurn();
                //frameManager.nextPlayersTurn();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                enableEndTurn();
		    }
        }

        else if (frameManager.getRoundStatus().equals("starting round") && frameManager.currentDominosAvailable() && frameManager.getPlayerTookTurn(frameManager.getPlayerNumber(this))){
            if (e.getSource() == endTurn){
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), false);
                setDoThis("Select a domino from current round dominoes");
                disableEndTurn();   
                frameManager.nextPlayersTurn();
            }
        }

        else if (frameManager.getRoundStatus().equals("starting round") && !(frameManager.currentDominosAvailable())){

            if (e.getSource() == endTurn){
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), false);
                disableEndTurn();
                frameManager.setRoundStatus("place domino");   //place dominos
                frameManager.nextPlayersTurn();
            }
        }        
/*
		else if (e.getSource() == leftRotate)
		{
			rotateLeft(frameManager.getCurrentDomino());
		}

		else if (e.getSource() == rightRotate)
		{   
			rotateRight(frameManager.getCurrentDomino());
		}
*/		else if (frameManager.getRoundStatus().equals("select domino") && !(frameManager.getPlayerTookTurn(frameManager.getPlayerNumber(this)))){

		    if ((e.getSource() == nextRndTile11) || (e.getSource() == nextRndTile12)){

			    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to select this domino for the next round?", "Confirm", JOptionPane.YES_NO_OPTION); 

                if(confirm == JOptionPane.YES_OPTION){

            	    next = nextDominos.get(0);
                    frameManager.addDominoToPlayer(next, frameManager.getPlayerNumber(this)); 
            	    frameManager.setNextDomino1Invisible();
                    frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                    setDoThis("Press 'End Turn' to end your turn.");
                    //frameManager.setRoundStatus("");
                    enableEndTurn();
                    //endTurn();
                    //frameManager.nextPlayersTurn();
                }
		    }
		
		    else if ((e.getSource() == nextRndTile21) || (e.getSource() == nextRndTile22)){

			    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to select this domino for the next round?", "Confirm", JOptionPane.YES_NO_OPTION); 

                if(confirm == JOptionPane.YES_OPTION){
            	    next = nextDominos.get(1);
            	    frameManager.addDominoToPlayer(next, frameManager.getPlayerNumber(this)); 
            	    frameManager.setNextDomino2Invisible();
                    frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                    setDoThis("Press 'End Turn' to end your turn.");
                    //frameManager.setRoundStatus("");
                    enableEndTurn();
                    //endTurn();
                    //frameManager.nextPlayersTurn();
                }
		    }
		
		    else if ((e.getSource() == nextRndTile31) || (e.getSource() == nextRndTile32)){

			    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to select this domino for the next round?", "Confirm", JOptionPane.YES_NO_OPTION); 

                if(confirm == JOptionPane.YES_OPTION){

            	    next = nextDominos.get(2); 
            	    frameManager.addDominoToPlayer(next, frameManager.getPlayerNumber(this)); 
            	    frameManager.setNextDomino3Invisible();
                    frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                    setDoThis("Press 'End Turn' to end your turn.");
                    //frameManager.setRoundStatus("");
                    enableEndTurn();
                    //endTurn();
                    //frameManager.nextPlayersTurn();
                }
		    }   
		
		    else if ((e.getSource() == nextRndTile41) || (e.getSource() == nextRndTile42)){

			    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to select this domino for the next round?", "Confirm", JOptionPane.YES_NO_OPTION); 

                if(confirm == JOptionPane.YES_OPTION){

            	    next = nextDominos.get(3); 
            	    frameManager.addDominoToPlayer(next, frameManager.getPlayerNumber(this)); 
            	    frameManager.setNextDomino4Invisible();
                    frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                    setDoThis("Press 'End Turn' to end your turn.");
                    //frameManager.setRoundStatus("");
                    enableEndTurn();
                    //endTurn();
                    //frameManager.nextPlayersTurn();
                }
		    }
        }
		
        else if (frameManager.getRoundStatus().equals("select domino") && (frameManager.getPlayerTookTurn(frameManager.getPlayerNumber(this)))){

            if (e.getSource() == endTurn){

                frameManager.setRoundStatus("place domino");
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), false);
                disableEndTurn();
                frameManager.nextPlayersTurn();
            }
        }
        //else if (e.getSource() == endTurn){
        //    disableEndTurn();
        //    frameManager.nextPlayersTurn();
        //}

        else if (frameManager.getRoundStatus().equals("place domino")){

            for(int i = 0; i < ROWS; ++i){

                for(int j = 0; j < COLUMNS; ++j){

                    if (e.getSource() == gridSquares[i][j]){

                        if (gridSquares[i][j].getBackground() == Color.WHITE){

                            if (rotatingTileOnRight(i, j)){

                                if (verifyAdjacentSquare(i,j+1) && verifyTerrainRule(i,j) && verifyWithInKingdom(i,j) && verifyDimensions(i,j)){
                                    
                                    placeTile(i, j);
                                    frameManager.setRoundStatus("select domino");
                                    frameManager.selectNextRndDomino(frameManager.getPlayerNumber(this));
                                }

                                else{

                                    JOptionPane.showMessageDialog(null, "Please select a valid square for your domino!", null, JOptionPane.PLAIN_MESSAGE);
                                }
                            }

                            else if (rotatingTileOnLeft(i, j)){

                                if (verifyAdjacentSquare(i,j-1) && verifyTerrainRule(i,j) && verifyWithInKingdom(i,j) && verifyDimensions(i,j)){

                                    placeTile(i,j);
                                    frameManager.setRoundStatus("select domino");
                                    frameManager.selectNextRndDomino(frameManager.getPlayerNumber(this));
                                }

                                else{
                                    JOptionPane.showMessageDialog(null, "Please select a valid square for your domino!", null, JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                            else if (rotatingTileBelow(i, j)){

                                if (verifyAdjacentSquare(i+1,j) && verifyTerrainRule(i,j) && verifyWithInKingdom(i,j) && verifyDimensions(i,j)){

                                    placeTile(i,j);
                                    frameManager.setRoundStatus("select domino");
                                    frameManager.selectNextRndDomino(frameManager.getPlayerNumber(this));
                                }

                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Please select a valid square for your domino!", null, JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                            else if (rotatingTileOnTop(i, j))
                            {
                                if (verifyAdjacentSquare(i-1,j) && verifyTerrainRule(i,j) && verifyWithInKingdom(i,j) && verifyDimensions(i,j)){

                                    placeTile(i,j);
                                    frameManager.setRoundStatus("select domino");
                                    frameManager.selectNextRndDomino(frameManager.getPlayerNumber(this));
                                }

                                else{

                                    JOptionPane.showMessageDialog(null, "Please select a valid square for your domino!", null, JOptionPane.PLAIN_MESSAGE);
                                }
                            }
                        }

                        else if (rotateTile5.getBackground() != Color.WHITE){

                            JOptionPane.showMessageDialog(null, "Square already taken! Please select a different square.", null, JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }
            }
        }

        else{

            if ( e.getSource() == endTurn){

                frameManager.nextPlayersTurn();
            }
        }
    }



    private boolean rotatingTileOnRight(int i, int j)
    {
        if((rotateTile6.getBackground() != Color.WHITE) && ((j+1) < COLUMNS) && rotateTile5.getBackground() != Color.WHITE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean rotatingTileOnLeft(int i, int j)
    {
        if((rotateTile4.getBackground() != Color.WHITE && ((j-1) >= 0) && rotateTile5.getBackground() != Color.WHITE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean rotatingTileBelow(int i, int j)
    {
        if((rotateTile8.getBackground() != Color.WHITE && ((i+1) < ROWS) && rotateTile5.getBackground() != Color.WHITE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean rotatingTileOnTop(int i, int j)
    {
        if((rotateTile2.getBackground() != Color.WHITE && ((i-1) >= 0) && rotateTile5.getBackground() != Color.WHITE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean verifyAdjacentSquare(int i, int j)
    {
        if (gridSquares[i][j].getBackground() == Color.WHITE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean verifyTerrainRule(int i, int j)
    {
        if(rotatingTileOnRight(i, j))
        {
            if((j-1)>=0)
            {
                if ((gridSquares[i][j-1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j-1].getBackground() == Color.BLACK))
                {
                    return true;
                }
            }

            if((i-1)>=0)
            {   

                if ((gridSquares[i-1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i-1][j].getBackground() == Color.BLACK) || (gridSquares[i-1][j+1].getBackground() == Color.BLACK) || (gridSquares[i-1][j+1].getBackground() == rotateTile6.getBackground()))
                {
                    return true;
                }
            } 

            if((i+1)<ROWS)
            {
                if ((gridSquares[i+1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i+1][j].getBackground() == Color.BLACK) || (gridSquares[i+1][j+1].getBackground() == Color.BLACK) || (gridSquares[i+1][j+1].getBackground() == rotateTile6.getBackground()))
                {
                    return true;
                }
            }

            if((j+2)<COLUMNS)
            {
                if ((gridSquares[i][j+2].getBackground() == Color.BLACK) || (gridSquares[i][j+2].getBackground() == rotateTile6.getBackground()))
                {
                    return true;
                }
            }
            
            return false;
            
        }

        if(rotatingTileOnLeft(i, j))
        {
             if((j+1)<COLUMNS)
            {
                if ((gridSquares[i][j+1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j+1].getBackground() == Color.BLACK))
                {
                    return true;
                }
            }

            if((i-1)>=0)
            {   

                if ((gridSquares[i-1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i-1][j].getBackground() == Color.BLACK) || (gridSquares[i-1][j-1].getBackground() == Color.BLACK) || (gridSquares[i-1][j-1].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            } 

            if((i+1)<ROWS)
            {
                if ((gridSquares[i+1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i+1][j].getBackground() == Color.BLACK) || (gridSquares[i+1][j-1].getBackground() == Color.BLACK) || (gridSquares[i+1][j-1].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            }

            if((j-2) >= 0)
            {
                if ((gridSquares[i][j-2].getBackground() == Color.BLACK) || (gridSquares[i][j-2].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            }
            
            return false;
        }

        if(rotatingTileBelow(i, j))
        {
            if((i-1)>=0)
            {
                if ((gridSquares[i-1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i-1][j].getBackground() == Color.BLACK))
                {
                    return true;
                }
            }

            if((j-1)>=0)
            {   

                if ((gridSquares[i][j-1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j-1].getBackground() == Color.BLACK) || (gridSquares[i+1][j-1].getBackground() == Color.BLACK) || (gridSquares[i+1][j-1].getBackground() == rotateTile8.getBackground()))
                {
                    return true;
                }
            } 

            if((j+1)<COLUMNS)
            {
                if ((gridSquares[i][j+1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j+1].getBackground() == Color.BLACK) || (gridSquares[i+1][j+1].getBackground() == Color.BLACK) || (gridSquares[i+1][j+1].getBackground() == rotateTile8.getBackground()))
                {
                    return true;
                }
            }

            if((i+2)<ROWS)
            {
                if ((gridSquares[i+2][j].getBackground() == Color.BLACK) || (gridSquares[i+2][j].getBackground() == rotateTile8.getBackground()))
                {
                    return true;
                }
            }
            
            return false;
        }

        if(rotatingTileOnTop(i, j))
        {
            if((i+1)<ROWS)
            {
                if ((gridSquares[i+1][j].getBackground() == rotateTile5.getBackground()) || (gridSquares[i+1][j].getBackground() == Color.BLACK))
                {
                    return true;
                }
            }

            if((j-1)>=0)
            {   

                if ((gridSquares[i][j-1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j-1].getBackground() == Color.BLACK) || (gridSquares[i-1][j-1].getBackground() == Color.BLACK) || (gridSquares[i-1][j-1].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            } 

            if((j+1)<COLUMNS)
            {
                if ((gridSquares[i][j+1].getBackground() == rotateTile5.getBackground()) || (gridSquares[i][j+1].getBackground() == Color.BLACK) || (gridSquares[i-1][j+1].getBackground() == Color.BLACK) || (gridSquares[i-1][j+1].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            }

            if((i-2)>=0)
            {
                if ((gridSquares[i-2][j].getBackground() == Color.BLACK) || (gridSquares[i-2][j].getBackground() == rotateTile2.getBackground()))
                {
                    return true;
                }
            }
            
            return false;
        }

        return false;
    }

     
    private boolean verifyDimensions(int i, int j)
    {

        if(rotatingTileOnRight(i, j))
        {
            if (((leftMostDominoColumn <= j) && (j+1 <= rightMostDominoColumn)) && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow)))
            {
                return true;
            }

            if (((j+1) > rightMostDominoColumn)  && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow))) //1
            {
                if(((j+1) - leftMostDominoColumn) < 5)
                {   
                    
                    rightMostDominoColumn = j+1;
                    return true;
                }
            }

            if ((j < leftMostDominoColumn) && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow))) //2
            {
                if((rightMostDominoColumn - j) < 5)
                {
                    
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            if (((leftMostDominoColumn <= j) && ((j+1) <= rightMostDominoColumn)) && (i < topMostDominoRow)) //3
            {
                if((bottomMostDominoRow - i) < 5)
                {
                    
                    topMostDominoRow = i;
                    return true;
                }
            }

            if (((leftMostDominoColumn <= j) && ((j+1) <= rightMostDominoColumn)) && (i > bottomMostDominoRow)) //4
            {
                if((i - topMostDominoRow) < 5)
                {
                    
                    bottomMostDominoRow = i;
                    return true;
                }
            }

            if (((j+1) > rightMostDominoColumn) && (i > bottomMostDominoRow)) //5
            {
                if((((j+1) - leftMostDominoColumn) < 5) && ((i - topMostDominoRow) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    rightMostDominoColumn = j+1;
                    return true;
                }
            }
            
            if (((j+1) > rightMostDominoColumn) && (i < topMostDominoRow)) //6
            {
                if((((j+1) - leftMostDominoColumn) < 5) && ((bottomMostDominoRow - i) < 5))
                {
                    
                    topMostDominoRow = i;
                    rightMostDominoColumn = j+1;
                    return true;
                }
            }

            if (((j) < leftMostDominoColumn) && (i > bottomMostDominoRow)) //7
            {
                if(((rightMostDominoColumn - j) < 5) && ((i - topMostDominoRow) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    leftMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((j) < leftMostDominoColumn) && (i < topMostDominoRow)) //8
            {
                if(((rightMostDominoColumn - j) < 5) && ((bottomMostDominoRow - i) < 5))
                {
                    
                    topMostDominoRow = i;
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            return false;
            
        }

        if(rotatingTileOnLeft(i, j))
        {
           if (((leftMostDominoColumn <= j - 1) && (j <= rightMostDominoColumn)) && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow)))
            {
                return true;
            }
            
            if (((j) > rightMostDominoColumn)  && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow))) //1
            {
                if(((j) - leftMostDominoColumn) < 5)
                {   
                    
                    rightMostDominoColumn = j;
                    return true;
                }
            }   

            if ((j-1 < leftMostDominoColumn) && ((topMostDominoRow <= i) && (i <= bottomMostDominoRow))) //2
            {
                if((rightMostDominoColumn - (j-1)) < 5)
                {
                    
                    leftMostDominoColumn = j-1;
                    return true;
                }
            }

            if (((leftMostDominoColumn <= j-1) && ((j) <= rightMostDominoColumn)) && (i < topMostDominoRow)) //3
            {
                if((bottomMostDominoRow - i) < 5)
                {
                    
                    topMostDominoRow = i;
                    return true;
                }
            }

            if (((leftMostDominoColumn <= j-1) && ((j) <= rightMostDominoColumn)) && (i > bottomMostDominoRow)) //4
            {
                if((i - topMostDominoRow) < 5)
                {
                    
                    bottomMostDominoRow = i;
                    return true;
                }
            }

            if (((j) > rightMostDominoColumn) && (i > bottomMostDominoRow)) //5
            {
                if((((j) - leftMostDominoColumn) < 5) && ((i - topMostDominoRow) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    rightMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((j) > rightMostDominoColumn) && (i < topMostDominoRow)) //6
            {
                if((((j) - leftMostDominoColumn) < 5) && ((bottomMostDominoRow - i) < 5))
                {
                    
                    topMostDominoRow = i;
                    rightMostDominoColumn = j;
                    return true;
                }
            }

            if (((j-1) < leftMostDominoColumn) && (i > bottomMostDominoRow)) //7
            {
                if(((rightMostDominoColumn - (j-1)) < 5) && ((i - topMostDominoRow) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    leftMostDominoColumn = j-1;
                    return true;
                }
            }
            
            if (((j-1) < leftMostDominoColumn) && (i < topMostDominoRow)) //8
            {
                if(((rightMostDominoColumn - (j-1)) < 5) && ((bottomMostDominoRow - i) < 5))
                {
                    
                    topMostDominoRow = i;
                    leftMostDominoColumn = j-1;
                    return true;
                }
            }

            return false;
        }

        if(rotatingTileBelow(i, j))
        {
            if (((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn)) && ((topMostDominoRow <= i) && ((i+1) <= bottomMostDominoRow)))
            {
                return true;
            }

            if (((i+1) > bottomMostDominoRow)  && ((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn))) //1
            {
                if(((i+1) - topMostDominoRow) < 5)
                {   
                    
                    bottomMostDominoRow = i+1;
                    return true;
                }
            }

            if ((i < topMostDominoRow) && ((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn))) //2
            {
                if((bottomMostDominoRow - i) < 5)
                {
                    
                    topMostDominoRow = i;
                    return true;
                }
            }

            if (((topMostDominoRow <= i) && ((i+1) <= bottomMostDominoRow)) && (j < leftMostDominoColumn)) //3
            {
                if((rightMostDominoColumn - j) < 5)
                {
                    
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            if (((topMostDominoRow <= i) && ((i+1) <= bottomMostDominoRow)) && (j > rightMostDominoColumn)) //4
            {
                if((j - leftMostDominoColumn) < 5)
                {
                    
                    rightMostDominoColumn = j;
                    return true;
                }
            }

            if (((i+1) > bottomMostDominoRow) && (j > rightMostDominoColumn)) //5
            {
                if((((i+1) - topMostDominoRow) < 5) && ((j - leftMostDominoColumn) < 5))
                {
                    
                    bottomMostDominoRow = i+1;
                    rightMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((i+1) > bottomMostDominoRow) && (j < leftMostDominoColumn)) //6
            {
                if((((i+1) - topMostDominoRow) < 5) && ((rightMostDominoColumn - j) < 5))
                {
                    
                    bottomMostDominoRow = i+1;
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            if (((i) < topMostDominoRow) && (j > rightMostDominoColumn)) //7
            {
                if(((bottomMostDominoRow - i) < 5) && ((j - leftMostDominoColumn) < 5))
                {
                    
                    topMostDominoRow = i;
                    rightMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((i) < topMostDominoRow) && (j < leftMostDominoColumn)) //8
            {
                if(((bottomMostDominoRow - i) < 5) && ((rightMostDominoColumn - j) < 5))
                {
                    
                    topMostDominoRow = i;
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            return false;
        }

        if(rotatingTileOnTop(i, j))
        {
            if (((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn)) && ((topMostDominoRow <= (i-1)) && (i <= bottomMostDominoRow)))
            {
                return true;
            }

            if (((i) > bottomMostDominoRow)  && ((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn))) //1
            {
                if(((i) - topMostDominoRow) < 5)
                {   
                    
                    bottomMostDominoRow = i;
                    return true;
                }
            }

            if (((i-1) < topMostDominoRow) && ((leftMostDominoColumn <= j) && (j <= rightMostDominoColumn))) //2
            {
                if((bottomMostDominoRow - (i-1)) < 5)
                {
                    
                    topMostDominoRow = i-1;
                    return true;
                }
            }

            if (((topMostDominoRow <= (i-1)) && (i <= bottomMostDominoRow)) && (j < leftMostDominoColumn)) //3
            {
                if((rightMostDominoColumn - j) < 5)
                {
                    
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            if (((topMostDominoRow <= (i-1)) && (i <= bottomMostDominoRow)) && (j > rightMostDominoColumn)) //4
            {
                if((j - leftMostDominoColumn) < 5)
                {
                    
                    rightMostDominoColumn = j;
                    return true;
                }
            }

            if (((i) > bottomMostDominoRow) && (j > rightMostDominoColumn)) //5
            {
                if((((i) - topMostDominoRow) < 5) && ((j - leftMostDominoColumn) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    rightMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((i) > bottomMostDominoRow) && (j < leftMostDominoColumn)) //6
            {
                if(((i - topMostDominoRow) < 5) && ((rightMostDominoColumn - j) < 5))
                {
                    
                    bottomMostDominoRow = i;
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            if (((i-1) < topMostDominoRow) && (j > rightMostDominoColumn)) //7
            {
                if(((bottomMostDominoRow - (i-1)) < 5) && ((j - leftMostDominoColumn) < 5))
                {
                    
                    topMostDominoRow = i-1;
                    rightMostDominoColumn = j;
                    return true;
                }
            }
            
            if (((i-1) < topMostDominoRow) && (j < leftMostDominoColumn)) //8
            {
                if(((bottomMostDominoRow - (i-1)) < 5) && ((rightMostDominoColumn - j) < 5))
                {
                    topMostDominoRow = i-1;
                    leftMostDominoColumn = j;
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    private boolean verifyWithInKingdom(int i, int j)
    {
        int rowStart  = Math.max( i - 2, 0 );
        int rowFinish = Math.min( i + 2, ROWS - 1 );
        int colStart  = Math.max( j - 2, 0 );
        int colFinish = Math.min( j + 2, COLUMNS - 1 );

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ )
        {    
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) 
            {
                {
                    if (gridSquares[curRow][curCol].getBackground() != Color.WHITE)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void placeTile(int i, int j)
    {
        if(rotatingTileOnRight(i, j))
        {
            gridSquares[i][j].setBackground(rotateTile5.getBackground());
            gridSquares[i][j+1].setBackground(rotateTile6.getBackground());
            gridSquares[i][j].setIcon(rotateTile5.getIcon());
            gridSquares[i][j+1].setIcon(rotateTile6.getIcon());
            rotateTile5.setBackground(Color.WHITE);
            rotateTile6.setBackground(Color.WHITE);
            rotateTile5.setIcon(null);
            rotateTile6.setIcon(null);
        }

        if(rotatingTileOnLeft(i, j))
        {
            gridSquares[i][j].setBackground(rotateTile5.getBackground());
            gridSquares[i][j-1].setBackground(rotateTile4.getBackground());
            gridSquares[i][j].setIcon(rotateTile5.getIcon());
            gridSquares[i][j-1].setIcon(rotateTile4.getIcon());
            rotateTile5.setBackground(Color.WHITE);
            rotateTile4.setBackground(Color.WHITE);
            rotateTile5.setIcon(null);
            rotateTile4.setIcon(null);
        }

        if(rotatingTileBelow(i, j))
        {
            gridSquares[i][j].setBackground(rotateTile5.getBackground());
            gridSquares[i+1][j].setBackground(rotateTile8.getBackground());
            gridSquares[i][j].setIcon(rotateTile5.getIcon());
            gridSquares[i+1][j].setIcon(rotateTile8.getIcon());
            rotateTile5.setBackground(Color.WHITE);
            rotateTile8.setBackground(Color.WHITE);
            rotateTile5.setIcon(null);
            rotateTile8.setIcon(null);
        }

        if(rotatingTileOnTop(i, j))
        {
            gridSquares[i][j].setBackground(rotateTile5.getBackground());
            gridSquares[i-1][j].setBackground(rotateTile2.getBackground());
            gridSquares[i][j].setIcon(rotateTile5.getIcon());
            gridSquares[i-1][j].setIcon(rotateTile2.getIcon());
            rotateTile5.setBackground(Color.WHITE);
            rotateTile2.setBackground(Color.WHITE);
            rotateTile5.setIcon(null);
            rotateTile2.setIcon(null);
        }

    }

    //private void setPlayerNum()
    //{
    //    whoTurn.setText("Player " + playerNum + "'s turn");
    //}

    private void addGridSquares()
    {
        gridSquares = new GridSquares [ROWS][COLUMNS];
        for(int i = 0; i < ROWS; ++i){
            for(int j = 0; j < COLUMNS; ++j){
                gridSquares[i][j] = new GridSquares(i,j);
                gridSquares[i][j].addActionListener(this);
                centerPanel.add(gridSquares[i][j]);
            }
        }
    }

    private void quit()
    {
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the current game?", "Confirmation Required", JOptionPane.YES_NO_OPTION); 
            if(answer == 0){
                setVisible(false);
                frameManager.showMainFrame();
            }
    }

    private void save()
    {
        /* PLACE SAVE FUNCTION HERE */
    }

    private void rotateLeft(Domino domino)
    {
        Domino currDomino = domino;

		if (rotateTile6.getBackground() != Color.WHITE)
		{
			rotateTile2.setBackground(rotateTile6.getBackground());
            rotateTile2.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile6.setBackground(Color.WHITE);
            rotateTile6.setIcon(null);
		}

		else if (rotateTile2.getBackground() != Color.WHITE)
		{
			rotateTile4.setBackground(rotateTile2.getBackground());
            rotateTile4.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile2.setBackground(Color.WHITE);
            rotateTile2.setIcon(null);
		}

		else if (rotateTile4.getBackground() != Color.WHITE)
		{
			rotateTile8.setBackground(rotateTile4.getBackground());
            rotateTile8.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile4.setBackground(Color.WHITE);
            rotateTile4.setIcon(null);
		}

		else if (rotateTile8.getBackground() != Color.WHITE)
		{
			rotateTile6.setBackground(rotateTile8.getBackground());
            rotateTile6.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile8.setBackground(Color.WHITE);
            rotateTile8.setIcon(null);
		}
    }

    private void rotateRight(Domino domino)
    {
        Domino currDomino = domino;

		if (rotateTile2.getBackground() != Color.WHITE)
		{
			rotateTile6.setBackground(rotateTile2.getBackground());
            rotateTile6.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile2.setBackground(Color.WHITE);
            rotateTile2.setIcon(null);
		}

		else if (rotateTile6.getBackground() != Color.WHITE)
		{
			rotateTile8.setBackground(rotateTile6.getBackground());
            rotateTile8.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile6.setBackground(Color.WHITE);
            rotateTile6.setIcon(null);
		}

		else if (rotateTile8.getBackground() != Color.WHITE)
		{
			rotateTile4.setBackground(rotateTile8.getBackground());
            rotateTile4.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile8.setBackground(Color.WHITE);
            rotateTile8.setIcon(null);
		}

		else if (rotateTile4.getBackground() != Color.WHITE)
		{
			rotateTile2.setBackground(rotateTile4.getBackground());
            rotateTile2.setIcon(new ImageIcon(currDomino.getTile2Image()));
			rotateTile4.setBackground(Color.WHITE);
            rotateTile4.setIcon(null);
		}
    }

    private void discardDomino(Domino domino)
    {
        if (rotateTile5.getBackground() != Color.WHITE){

            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to discard this domino?", "Confirm", JOptionPane.YES_NO_OPTION); 

                if(confirm == JOptionPane.YES_OPTION){

                    rotateTile2.setBackground(Color.WHITE);
                    rotateTile2.setIcon(null);
                    rotateTile4.setBackground(Color.WHITE);
                    rotateTile4.setIcon(null);
                    rotateTile5.setBackground(Color.WHITE);
                    rotateTile5.setIcon(null);
                    rotateTile6.setBackground(Color.WHITE);
                    rotateTile6.setIcon(null);
                    rotateTile8.setBackground(Color.WHITE);
                    rotateTile8.setIcon(null);

                    frameManager.removeDomino();
                    frameManager.setRoundStatus("select domino");
                    frameManager.selectNextRndDomino(frameManager.getPlayerNumber(this));
                }

        }
    }

    public void setCurrentRndDominos(ArrayList<Domino> currentRndDominos)
    {
        currentDominos = currentRndDominos;
        Domino currentDomino;
        currentDomino = currentDominos.get(0);
        currentTile11.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        currentTile12.setIcon(new ImageIcon(currentDomino.getTile2Image()));
        currentTile11.setBackground(currentDomino.getTile1Color());
        currentTile12.setBackground(currentDomino.getTile2Color());

        currentDomino = currentDominos.get(1);
        currentTile21.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        currentTile22.setIcon(new ImageIcon(currentDomino.getTile2Image()));
        currentTile21.setBackground(currentDomino.getTile1Color());
        currentTile22.setBackground(currentDomino.getTile2Color());

        currentDomino = currentDominos.get(2);
        currentTile31.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        currentTile32.setIcon(new ImageIcon(currentDomino.getTile2Image()));
        currentTile31.setBackground(currentDomino.getTile1Color());
        currentTile32.setBackground(currentDomino.getTile2Color());

        currentDomino = currentDominos.get(3);
        currentTile41.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        currentTile42.setIcon(new ImageIcon(currentDomino.getTile2Image()));
        currentTile41.setBackground(currentDomino.getTile1Color());
        currentTile42.setBackground(currentDomino.getTile2Color());

    }

    public void setNextRndDominos(ArrayList<Domino> nextRndDominos)
    {
    	nextDominos = nextRndDominos;
        Domino currentDomino = nextRndDominos.get(0);
        nextRndTile11.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        nextRndTile12.setIcon(new ImageIcon(currentDomino.getTile2Image()));

        currentDomino = nextRndDominos.get(1);
        nextRndTile21.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        nextRndTile22.setIcon(new ImageIcon(currentDomino.getTile2Image()));

        currentDomino = nextRndDominos.get(2);
        nextRndTile31.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        nextRndTile32.setIcon(new ImageIcon(currentDomino.getTile2Image()));

        currentDomino = nextRndDominos.get(3);
        nextRndTile41.setIcon(new ImageIcon(currentDomino.getTile1Image()));
        nextRndTile42.setIcon(new ImageIcon(currentDomino.getTile2Image()));
    }

    public void setRound(int roundNum)
    {
        round.setText("Round #: " + roundNum);
    }

    public void setRemainingDominos(int dominosRemaining)
    {
        dominosLeft.setText("Dominos left: " + dominosRemaining);
    }

    public void enableCurrentRndDominos()
    {
        currentTile11.setEnabled(true);
        currentTile12.setEnabled(true);
        currentTile21.setEnabled(true);
        currentTile22.setEnabled(true);
        currentTile31.setEnabled(true);
        currentTile32.setEnabled(true);
        currentTile41.setEnabled(true);
        currentTile42.setEnabled(true);
    }

    public void setPlayerName(Player player)
    {
        whoTurn.setText(player.getName() + "'s turn");
        whoTurn.setForeground(player.getColour());
    }

    public void setCurrentDomino1Invisible()
    {
        currentTile11.setOpaque(false);
        currentTile12.setOpaque(false);
        currentTile11.setEnabled(false);
        currentTile12.setEnabled(false);
    }

    public void setCurrentDomino2Invisible()
    {
        currentTile21.setOpaque(false);
        currentTile22.setOpaque(false);
        currentTile21.setEnabled(false);
        currentTile22.setEnabled(false);
    }

    public void setCurrentDomino3Invisible()
    {
        currentTile31.setOpaque(false);
        currentTile32.setOpaque(false);
        currentTile31.setEnabled(false);
        currentTile32.setEnabled(false);
    }

    public void setCurrentDomino4Invisible()
    {
        currentTile41.setOpaque(false);
        currentTile42.setOpaque(false);
        currentTile41.setEnabled(false);
        currentTile42.setEnabled(false);
    }

    public void setCurrentDominoesVisible()
    {
        //currentTile11.setOpaque(true);
        currentTile11.setEnabled(true);
        currentTile12.setEnabled(true);
        currentTile21.setEnabled(true);
        currentTile22.setEnabled(true);
        currentTile31.setEnabled(true);
        currentTile32.setEnabled(true);
        currentTile41.setEnabled(true);
        currentTile42.setEnabled(true);
    }

    public void setNextDomino1Invisible()
    {
        nextRndTile11.setOpaque(false);
        nextRndTile12.setOpaque(false);
        nextRndTile11.setEnabled(false);
        nextRndTile12.setEnabled(false);
    }

    public void setNextDomino2Invisible()
    {
        nextRndTile21.setOpaque(false);
        nextRndTile22.setOpaque(false);
        nextRndTile21.setEnabled(false);
        nextRndTile22.setEnabled(false);
    }

    public void setNextDomino3Invisible()
    {
        nextRndTile31.setOpaque(false);
        nextRndTile32.setOpaque(false);
        nextRndTile31.setEnabled(false);
        nextRndTile32.setEnabled(false);
    }

    public void setNextDomino4Invisible()
    {
        nextRndTile41.setOpaque(false);
        nextRndTile42.setOpaque(false);
        nextRndTile41.setEnabled(false);
        nextRndTile42.setEnabled(false);
    }

    public void setNextRndDominoesVisible()
    {
        nextRndTile11.setOpaque(true);
        nextRndTile12.setOpaque(true);
        nextRndTile21.setOpaque(true);
        nextRndTile22.setOpaque(true);
        nextRndTile31.setOpaque(true);
        nextRndTile32.setOpaque(true);
        nextRndTile41.setOpaque(true);
        nextRndTile42.setOpaque(true);
    }

    public void setDoThis(String thisThing)
    {
        doThis.setText(thisThing);
    }

    public void showRotate(Domino domino)
    {
        rotateTile5.setIcon(new ImageIcon(domino.getTile1Image()));
        rotateTile6.setIcon(new ImageIcon(domino.getTile2Image()));
        rotateTile5.setBackground(domino.getTile1Color());
        rotateTile6.setBackground(domino.getTile2Color());
        rotateTile2.setBackground(Color.WHITE);
        rotateTile4.setBackground(Color.WHITE);
        rotateTile8.setBackground(Color.WHITE);
        rotateTile2.setIcon(null);
        rotateTile4.setIcon(null);
        rotateTile8.setIcon(null);
    }

    public void disableNextRndDominoes()
    {
        nextRndTile11.setEnabled(false);
        nextRndTile12.setEnabled(false);
        nextRndTile21.setEnabled(false);
        nextRndTile22.setEnabled(false);
        nextRndTile31.setEnabled(false);
        nextRndTile32.setEnabled(false);
        nextRndTile41.setEnabled(false);
        nextRndTile42.setEnabled(false);
    }

    public void enableNextRndDominoes1()
    {
        nextRndTile11.setEnabled(true);
        nextRndTile12.setEnabled(true);
    }

    public void enableNextRndDominoes2()
    {
        nextRndTile21.setEnabled(true);
        nextRndTile22.setEnabled(true);
    }

    public void enableNextRndDominoes3()
    {
        nextRndTile31.setEnabled(true);
        nextRndTile32.setEnabled(true);
    }

    public void enableNextRndDominoes4()
    {
        nextRndTile41.setEnabled(true);
        nextRndTile42.setEnabled(true);
    }

    public void enableEndTurn()
    {
        endTurn.setEnabled(true);
    }

    public void disableEndTurn()
    {
        endTurn.setEnabled(false);
    }

    public void viewPlayer1()
    {
        makeInvisible();
        frameManager.showPlayer1GameBoard();
    }

    public void viewPlayer2()
    {
        makeInvisible();
        frameManager.showPlayer2GameBoard();
    }

    public void viewPlayer3()
    {
        makeInvisible();
        frameManager.showPlayer3GameBoard();
    }

    public void viewPlayer4()
    {
        makeInvisible();
        frameManager.showPlayer4GameBoard();
    }

    public void setAsAIboard() 
    {
    	this.AIboard = true;
    }
    
    public boolean isAIboard() 
    {
    	return AIboard;
    }
    
    public void doAIaction()
    {
    	//if first round, pick from current pile and end turn
    	//if not first round, place tile, pick next tile and end turn
    	if (frameManager.getRoundStatus().equals("starting round") && frameManager.currentDominosAvailable() && !(frameManager.getPlayerTookTurn(frameManager.getPlayerNumber(this)))){
    		AIpickTile();
    		//end turn ;automate with frameManager.nextPlayersTurn();
    	} else {
    		//AIplaceTile();
    		//AIpickNextTile();
    		//end turn ;automate with frameManager.nextPlayersTurn();
    	}
    }
    
    public void AIpickTile()
    {	
    	boolean picked = false;
    	while(picked==false){
    		int num = rand.nextInt(currentDominos.size());
    		if(currentDominos.get(num).getAvailable() == true) {
    			Domino current = currentDominos.get(num);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                if(num == 0)frameManager.setCurrentDomino1Invisible();
                if(num == 1)frameManager.setCurrentDomino2Invisible();
                if(num == 2)frameManager.setCurrentDomino3Invisible();
                if(num == 3)frameManager.setCurrentDomino4Invisible();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                picked = true;
                enableEndTurn();// TEMPORARY 
    		}
    	}
    }
    
    public void AIplaceTile() 
    {
    	
    }
    
    public void AIpickNextTile()
    {
    	boolean picked = false;
    	while(picked==false){
    		int num = rand.nextInt(nextDominos.size());
    		if(nextDominos.get(num).getAvailable() == true) {
    			Domino current = nextDominos.get(num);
                frameManager.addDominoToPlayer(current, frameManager.getPlayerNumber(this));
                if(num == 0)frameManager.setNextDomino1Invisible();
                if(num == 1)frameManager.setNextDomino2Invisible();
                if(num == 2)frameManager.setNextDomino3Invisible();
                if(num == 3)frameManager.setNextDomino4Invisible();
                frameManager.setPlayerTookTurn(frameManager.getPlayerNumber(this), true);
                picked = true;
                enableEndTurn();// TEMPORARY 
    		}
    	}
    }
/*
    public static void main(String[] args) {
        FrameManager frameManager = new FrameManager();
        new GameBoard(frameManager);
        frameManager.showGameBoard();
    }
*/
}
