import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a description of class Deck here.
 *
 * @author William Wang
 * @version 2018.01.04
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private int[] serial = new int[52];
    private int[] value = {10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10 };
    private String[] display =  {"K♥", "A♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♦", "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♣", "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♠", "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠"};

    ArrayList<Card> deck = new ArrayList<Card>();
    Card[] list = new Card[52];
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        // initialise instance variables

        for(int i = 0; i < 52; i++)
        {
            serial[i] = i;
            list[i] = new Card(serial[i], display[i], value[i]);
            deck.add(list[i]);
        }

    }

    public Card drawCard()
    {
        Card card = null;
        if(deck.size() > 0)
        {
            card = deck.get(0);
            deck.remove(0);
        }
        else
        {

        }

        return card;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    public int getLength()
    {
        return deck.size();
    }
    
    public String returnDeck()
    {
        String index = "";
        for(int i = 0; i < deck.size(); i++)
        {
            Card card = deck.get(i);
            index = index + card.returnDisplay() + " ";
        }
        return index;
    }

    public int deckSize()
    {
        return deck.size();
    }
}
