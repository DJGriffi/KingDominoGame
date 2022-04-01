import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import javax.imageio.ImageIO;

public class DeckOfDominos implements java.io.Serializable
{

    private ArrayList<Domino> deck;
    private ArrayList<Domino> deckToBePlayed;
    private ArrayList<Domino> randomDominos;
    private int dominosRemaining;
    private final int NUM_OF_DOMINOS = 48;
    private final int CARDS_PER_RND = 4;
    private Random rand;

    public DeckOfDominos()
    {
        dominosRemaining = NUM_OF_DOMINOS; 
        rand = new Random();
        deckToBePlayed = new ArrayList<>();
    }

    public void createDeck() throws IOException
    {
        deck = new ArrayList<>();

        Domino domino1 = new Domino(Color.YELLOW, Color.YELLOW, 0, 0, 1, ImageIO.read(getClass().getResource("/images/Domino1-1.png")), ImageIO.read(getClass().getResource("/images/Domino1-2.png")));
        deck.add(domino1);

        Domino domino2 = new Domino(Color.YELLOW, Color.YELLOW, 0, 0, 2, ImageIO.read(getClass().getResource("/images/Domino2-1.png")), ImageIO.read(getClass().getResource("/images/Domino2-2.png")));
        deck.add(domino2);

        Domino domino3 = new Domino(Color.GREEN, Color.GREEN, 0, 0, 3, ImageIO.read(getClass().getResource("/images/Domino3-1.png")), ImageIO.read(getClass().getResource("/images/Domino3-2.png")));
        deck.add(domino3);

        Domino domino4 = new Domino(Color.GREEN, Color.GREEN, 0, 0, 4, ImageIO.read(getClass().getResource("/images/Domino4-1.png")), ImageIO.read(getClass().getResource("/images/Domino4-2.png")));
        deck.add(domino4);

        Domino domino5 = new Domino(Color.GREEN, Color.GREEN, 0, 0, 5, ImageIO.read(getClass().getResource("/images/Domino5-1.png")), ImageIO.read(getClass().getResource("/images/Domino5-2.png")));
        deck.add(domino5);

        Domino domino6 = new Domino(Color.GREEN, Color.GREEN, 0, 0, 6, ImageIO.read(getClass().getResource("/images/Domino6-1.png")), ImageIO.read(getClass().getResource("/images/Domino6-2.png")));
        deck.add(domino6);

        Domino domino7 = new Domino(Color.BLUE, Color.BLUE, 0, 0, 7, ImageIO.read(getClass().getResource("/images/Domino7-1.png")), ImageIO.read(getClass().getResource("/images/Domino7-2.png")));
        deck.add(domino7);

        Domino domino8 = new Domino(Color.BLUE, Color.BLUE, 0, 0, 8, ImageIO.read(getClass().getResource("/images/Domino8-1.png")), ImageIO.read(getClass().getResource("/images/Domino8-2.png")));
        deck.add(domino8);

        Domino domino9 = new Domino(Color.BLUE, Color.BLUE, 0, 0, 9, ImageIO.read(getClass().getResource("/images/Domino9-1.png")), ImageIO.read(getClass().getResource("/images/Domino9-2.png")));
        deck.add(domino9);
        
        Domino domino10 = new Domino(Color.CYAN, Color.CYAN, 0, 0, 10, ImageIO.read(getClass().getResource("/images/Domino10-1.png")), ImageIO.read(getClass().getResource("/images/Domino10-2.png")));
        deck.add(domino10);
        
        Domino domino11 = new Domino(Color.CYAN, Color.CYAN, 0, 0, 11, ImageIO.read(getClass().getResource("/images/Domino11-1.png")), ImageIO.read(getClass().getResource("/images/Domino11-2.png")));
        deck.add(domino11);

        Domino domino12 = new Domino(Color.LIGHT_GRAY, Color.LIGHT_GRAY, 0, 0, 12, ImageIO.read(getClass().getResource("/images/Domino12-1.png")), ImageIO.read(getClass().getResource("/images/Domino12-2.png")));
        deck.add(domino12);

        Domino domino13 = new Domino(Color.YELLOW, Color.GREEN, 0, 0, 13, ImageIO.read(getClass().getResource("/images/Domino13-1.png")), ImageIO.read(getClass().getResource("/images/Domino13-2.png")));
        deck.add(domino13);

        Domino domino14 = new Domino(Color.YELLOW, Color.BLUE, 0, 0, 14, ImageIO.read(getClass().getResource("/images/Domino14-1.png")), ImageIO.read(getClass().getResource("/images/Domino14-2.png")));
        deck.add(domino14);

        Domino domino15 = new Domino(Color.YELLOW, Color.CYAN, 0, 0, 15, ImageIO.read(getClass().getResource("/images/Domino15-1.png")), ImageIO.read(getClass().getResource("/images/Domino15-2.png")));
        deck.add(domino15);

        Domino domino16 = new Domino(Color.YELLOW, Color.LIGHT_GRAY, 0, 0, 16, ImageIO.read(getClass().getResource("/images/Domino16-1.png")), ImageIO.read(getClass().getResource("/images/Domino16-2.png")));
        deck.add(domino16);

        Domino domino17 = new Domino(Color.GREEN, Color.BLUE, 0, 0, 17, ImageIO.read(getClass().getResource("/images/Domino17-1.png")), ImageIO.read(getClass().getResource("/images/Domino17-2.png")));
        deck.add(domino17);

        Domino domino18 = new Domino(Color.GREEN, Color.CYAN, 0, 0, 18, ImageIO.read(getClass().getResource("/images/Domino18-1.png")), ImageIO.read(getClass().getResource("/images/Domino18-2.png")));
        deck.add(domino18);

        Domino domino19 = new Domino(Color.YELLOW, Color.GREEN, 1, 0, 19, ImageIO.read(getClass().getResource("/images/Domino19-1.png")), ImageIO.read(getClass().getResource("/images/Domino19-2.png")));
        deck.add(domino19);

        Domino domino20 = new Domino(Color.YELLOW, Color.BLUE, 1, 0, 20, ImageIO.read(getClass().getResource("/images/Domino20-1.png")), ImageIO.read(getClass().getResource("/images/Domino20-2.png")));
        deck.add(domino20);

        Domino domino21 = new Domino(Color.YELLOW, Color.CYAN, 1, 0, 21, ImageIO.read(getClass().getResource("/images/Domino21-1.png")), ImageIO.read(getClass().getResource("/images/Domino21-2.png")));
        deck.add(domino21);

        Domino domino22 = new Domino(Color.YELLOW, Color.LIGHT_GRAY, 1, 0, 22, ImageIO.read(getClass().getResource("/images/Domino22-1.png")), ImageIO.read(getClass().getResource("/images/Domino22-2.png")));
        deck.add(domino22);

        Domino domino23 = new Domino(Color.YELLOW, Color.BLACK, 1, 0, 23, ImageIO.read(getClass().getResource("/images/Domino23-1.png")), ImageIO.read(getClass().getResource("/images/Domino23-2.png")));
        deck.add(domino23);

        Domino domino24 = new Domino(Color.GREEN, Color.YELLOW, 1, 0, 24, ImageIO.read(getClass().getResource("/images/Domino24-1.png")), ImageIO.read(getClass().getResource("/images/Domino24-2.png")));
        deck.add(domino24);

        Domino domino25 = new Domino(Color.GREEN, Color.YELLOW, 1, 0, 25, ImageIO.read(getClass().getResource("/images/Domino25-1.png")), ImageIO.read(getClass().getResource("/images/Domino25-2.png")));
        deck.add(domino25);

        Domino domino26 = new Domino(Color.GREEN, Color.YELLOW, 1, 0, 26, ImageIO.read(getClass().getResource("/images/Domino26-1.png")), ImageIO.read(getClass().getResource("/images/Domino26-2.png")));
        deck.add(domino26);

        Domino domino27 = new Domino(Color.GREEN, Color.YELLOW, 1, 0, 27, ImageIO.read(getClass().getResource("/images/Domino27-1.png")), ImageIO.read(getClass().getResource("/images/Domino27-2.png")));
        deck.add(domino27);

        Domino domino28 = new Domino(Color.GREEN, Color.BLUE, 1, 0, 28, ImageIO.read(getClass().getResource("/images/Domino28-1.png")), ImageIO.read(getClass().getResource("/images/Domino28-2.png")));
        deck.add(domino28);

        Domino domino29 = new Domino(Color.GREEN, Color.CYAN, 1, 0, 29, ImageIO.read(getClass().getResource("/images/Domino29-1.png")), ImageIO.read(getClass().getResource("/images/Domino29-2.png")));
        deck.add(domino29);

        Domino domino30 = new Domino(Color.BLUE, Color.YELLOW, 1, 0, 30, ImageIO.read(getClass().getResource("/images/Domino30-1.png")), ImageIO.read(getClass().getResource("/images/Domino30-2.png")));
        deck.add(domino30);

        Domino domino31 = new Domino(Color.BLUE, Color.YELLOW, 1, 0, 31, ImageIO.read(getClass().getResource("/images/Domino31-1.png")), ImageIO.read(getClass().getResource("/images/Domino31-2.png")));
        deck.add(domino31);

        Domino domino32 = new Domino(Color.BLUE, Color.GREEN, 1, 0, 32, ImageIO.read(getClass().getResource("/images/Domino32-1.png")), ImageIO.read(getClass().getResource("/images/Domino32-2.png")));
        deck.add(domino32);

        Domino domino33 = new Domino(Color.BLUE, Color.GREEN, 1, 0, 33, ImageIO.read(getClass().getResource("/images/Domino33-1.png")), ImageIO.read(getClass().getResource("/images/Domino33-2.png")));
        deck.add(domino33);

        Domino domino34 = new Domino(Color.BLUE, Color.GREEN, 1, 0, 34, ImageIO.read(getClass().getResource("/images/Domino34-1.png")), ImageIO.read(getClass().getResource("/images/Domino34-2.png")));
        deck.add(domino34);

        Domino domino35 = new Domino(Color.BLUE, Color.GREEN, 1, 0, 35, ImageIO.read(getClass().getResource("/images/Domino35-1.png")), ImageIO.read(getClass().getResource("/images/Domino35-2.png")));
        deck.add(domino35);

        Domino domino36 = new Domino(Color.YELLOW, Color.CYAN, 0, 1, 36, ImageIO.read(getClass().getResource("/images/Domino36-1.png")), ImageIO.read(getClass().getResource("/images/Domino36-2.png")));
        deck.add(domino36);

        Domino domino37 = new Domino(Color.BLUE, Color.CYAN, 0, 1, 37, ImageIO.read(getClass().getResource("/images/Domino37-1.png")), ImageIO.read(getClass().getResource("/images/Domino37-2.png")));
        deck.add(domino37);

        Domino domino38 = new Domino(Color.YELLOW, Color.LIGHT_GRAY, 0, 1, 38, ImageIO.read(getClass().getResource("/images/Domino38-1.png")), ImageIO.read(getClass().getResource("/images/Domino38-2.png")));
        deck.add(domino38);

        Domino domino39 = new Domino(Color.CYAN, Color.LIGHT_GRAY, 0, 1, 39, ImageIO.read(getClass().getResource("/images/Domino39-1.png")), ImageIO.read(getClass().getResource("/images/Domino39-2.png")));
        deck.add(domino39);

        Domino domino40 = new Domino(Color.BLACK, Color.YELLOW, 1, 0, 40, ImageIO.read(getClass().getResource("/images/Domino40-1.png")), ImageIO.read(getClass().getResource("/images/Domino40-2.png")));
        deck.add(domino40);

        Domino domino41 = new Domino(Color.YELLOW, Color.CYAN, 0, 2, 41, ImageIO.read(getClass().getResource("/images/Domino41-1.png")), ImageIO.read(getClass().getResource("/images/Domino41-2.png")));
        deck.add(domino41);

        Domino domino42 = new Domino(Color.BLUE, Color.CYAN, 0, 2, 42, ImageIO.read(getClass().getResource("/images/Domino42-1.png")), ImageIO.read(getClass().getResource("/images/Domino42-2.png")));
        deck.add(domino42);

        Domino domino43 = new Domino(Color.YELLOW, Color.LIGHT_GRAY, 0, 2, 43, ImageIO.read(getClass().getResource("/images/Domino43-1.png")), ImageIO.read(getClass().getResource("/images/Domino43-2.png")));
        deck.add(domino43);

        Domino domino44 = new Domino(Color.CYAN, Color.LIGHT_GRAY, 0, 2, 44, ImageIO.read(getClass().getResource("/images/Domino44-1.png")), ImageIO.read(getClass().getResource("/images/Domino44-2.png")));
        deck.add(domino44);

        Domino domino45 = new Domino(Color.BLACK, Color.YELLOW, 2, 0, 45, ImageIO.read(getClass().getResource("/images/Domino45-1.png")), ImageIO.read(getClass().getResource("/images/Domino45-2.png")));
        deck.add(domino45);

        Domino domino46 = new Domino(Color.LIGHT_GRAY, Color.BLACK, 0, 2, 46, ImageIO.read(getClass().getResource("/images/Domino46-1.png")), ImageIO.read(getClass().getResource("/images/Domino46-2.png")));
        deck.add(domino46);

        Domino domino47 = new Domino(Color.LIGHT_GRAY, Color.BLACK, 0, 2, 47, ImageIO.read(getClass().getResource("/images/Domino47-1.png")), ImageIO.read(getClass().getResource("/images/Domino47-2.png")));
        deck.add(domino47);

        Domino domino48 = new Domino(Color.YELLOW, Color.BLACK, 0, 3, 48, ImageIO.read(getClass().getResource("/images/Domino48-1.png")), ImageIO.read(getClass().getResource("/images/Domino48-2.png")));
        deck.add(domino48);

    }

    public void createDeckToBePlayed(int numOfPlayers){
        if (numOfPlayers == 2){
            int i, randomNum;
            int dominoesLeft = 48;
            dominosRemaining = 24;
        

            for (i = 0; i < 24; i++){
                randomNum = rand.nextInt(dominoesLeft);
                deckToBePlayed.add(deck.get(randomNum));
                deck.remove(randomNum);
                --dominoesLeft;
            }
        }

        else{
            deckToBePlayed = deck;
        }
    }

    public ArrayList<Domino> randomDominos()
    {
        int i;
        int randomNum;
        randomDominos = new ArrayList<>();

        for (i = 0; i < CARDS_PER_RND; i++){
            randomNum = rand.nextInt(dominosRemaining);
            randomDominos.add(deckToBePlayed.get(randomNum));
            deckToBePlayed.remove(randomNum);
            --dominosRemaining;

        }

        Collections.sort(randomDominos, Comparator.comparing(Domino::getNumericalVal));

        return randomDominos;
    }

    public int getRemainingDominos()
    {
        return dominosRemaining;
    }



}