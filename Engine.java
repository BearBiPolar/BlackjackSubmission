import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*;
/**
 * The Actual Game. Run main method :D
 *
 * @author William Wang
 * @version 2018.01.05
 */
public class Engine extends Deck
{
    // instance variables - replace the example below with your own
    private final static String greeting = "Welcome Player, please enter your name: ";

    private static String name = "";

    public Engine ()
    {
        main("");
    }

    public static void seperate()
    {
        System.out.println("--------------------------------------------------");
    }

    /**
     * The Game.
     */
    public static void main(String arguments)
    {
        int player;
        int dealer;
        int dealerAces;
        int playerAces;
        int dealerWins = 0;
        int playerWins = 0;
        boolean isPlaying = true;
        String dealerDisplay;
        String playerDisplay;

        //Enter data using BufferReader 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println(greeting);

        try
        {
            // Reading data using readLine 
            name = reader.readLine(); 
        }
        catch(IOException exception)
        {

        }

        //Get a new deck
        Deck deck = new Deck();
        System.out.println("Default Deck: ");
        //Print deck.
        System.out.println(deck.returnDeck());
        seperate();
        //Shuffle deck.
        deck.shuffleDeck();
        do
        {
            dealerDisplay = "";
            playerDisplay = "";
            dealer = 0;
            player = 0;
            dealerAces = 0;
            playerAces = 0;
            // if deck size is smaller than 5.
            if(deck.deckSize() < 5)
            {
                System.out.println("Getting a New deck :)");
                deck = new Deck();
                seperate();
                System.out.println(deck.returnDeck());
                deck.shuffleDeck();
            }
            else
            {
                System.out.println("Current Deck: ");
                System.out.println(deck.returnDeck());
            }
            seperate();

            Card one = deck.drawCard();
            Card two = deck.drawCard();

            dealerDisplay = one.returnDisplay() + " " + two.returnDisplay();
            dealer = two.returnValue() + one.returnValue();

            if(one.isAce())
            {
                dealerAces++;
            }
            if(two.isAce())
            {
                dealerAces++;
            }

            System.out.println("Dealer's Score = " + one.returnValue());
            System.out.println(one.returnDisplay() + " ?");

            for(int i = 0; i < 2; i++)
            {
                Card card = deck.drawCard();
                if(card.isAce())
                {
                    playerAces++;
                }
                playerDisplay = playerDisplay + card.returnDisplay() + " ";
                player = player + card.returnValue(); 
            }
            System.out.println(playerDisplay);
            System.out.println("Player's Score = " + player);
            boolean isExit = false;
            boolean isCorrect = false;
            seperate();
            if(player!=21)
            {
                do
                {
                    String input = "";
                    System.out.println(name + ", Hit or Stay?[H/S]");
                    do
                    {
                        try
                        {
                            input = reader.readLine();
                            if(input.equals("H")||input.equals("h"))
                            {
                                isCorrect = true;
                            }
                            else if(input.equals("S")||input.equals("s"))
                            {
                                isCorrect = true;
                            }
                            else
                            {
                                System.out.println("Invalid Option :( Please try again.[H/S]");
                            }
                        }
                        catch(IOException exception)
                        {
                        }
                    }
                    while(!isCorrect);

                    if(input.equals("H")||input.equals("h"))
                    {
                        Card card = null;
                        if(deck.getLength() > 0)
                        {
                            boolean aceChanged = false;
                            card = deck.drawCard();
                            if(card.isAce())
                            {
                                playerAces++;
                            }
                            playerDisplay = playerDisplay + card.returnDisplay() + " ";
                            player = player + card.returnValue();
                            if(playerAces > 0)
                            {
                                if(player > 21)
                                {
                                    aceChanged = true;
                                    player = player - 10;
                                    playerAces = playerAces - 1;
                                }
                            }
                            seperate();
                            System.out.println("Dealer's Score = " + one.returnValue());
                            System.out.println(one.returnDisplay() + " ?");
                            System.out.println(playerDisplay);
                            System.out.println("Player's Score = " + player); 
                            if(aceChanged)
                            {
                                System.out.println("(Ace Value Changed to 1 :D)");
                            }

                        }
                        else
                        {
                            System.out.println("Out of cards :(");
                            isExit = true;
                        }
                    }
                    else if (input.equals("S") || input.equals("s"))
                    {
                        isExit = true;
                    }

                    if(player >= 21)
                    {
                        isExit = true;
                    }
                    seperate();
                }
                while(!isExit);
            }
            dealerDisplay = dealerDisplay + " ";
            if(player < 21 && dealer <= 16)
            {
                boolean dealDone = false;
                do
                {
                    Card card = null;
                    if(deck.getLength() > 0)
                    {
                        card = deck.drawCard();
                        if(card.isAce())
                        {
                            dealerAces++;
                        }
                        dealerDisplay = dealerDisplay + card.returnDisplay() + " ";
                        dealer = dealer + card.returnValue();
                        if(dealerAces > 0)
                        {
                            if(dealer > 21)
                            {
                                dealer = dealer - 10;
                                dealerAces = dealerAces - 1;
                            }
                        }
                        if(dealer >= 16)
                        {
                            dealDone = true;
                        }
                    }
                    else
                    {
                        System.out.println("Out of cards :(");
                        dealDone = true;
                    }
                }
                // Dealer must surpass player to win if under 21.
                while(!dealDone);
            }
            System.out.println("Dealer's Score = " + dealer);
            System.out.println(dealerDisplay);
            System.out.println(playerDisplay);
            System.out.println("Player's Score = " + player);
            seperate();

            if (player > 21)
            {
                System.out.println("You lost your bet. :(");
                System.out.println("Would you like to play again? [Y/N]");
                dealerWins++;
            }
            else if (dealer > 21)
            {
                System.out.println("You won your bet. :D");
                System.out.println("Would you like to play again? [Y/N]");
                playerWins++;
            }
            else if (dealer > player)
            {
                System.out.println("You lost your bet. :(");
                System.out.println("Would you like to play again? [Y/N]");
                dealerWins++;
            }
            else if(player > dealer)
            {
                System.out.println("You won your bet. :D");
                System.out.println("Would you like to play again? [Y/N]");
                playerWins++;
            }
            else if (player == dealer)
            {
                System.out.println("You have tied. :)");
                System.out.println("Would you like to play again? [Y/N]");
            }
            String input = "";
            isCorrect = false;
            do
            {
                try
                {
                    input = reader.readLine();
                    if(input.equals("N") || input.equals("n"))
                    {
                        isCorrect = true;
                    }
                    else if(input.equals("Y") || input.equals("y"))
                    {
                        isCorrect = true;
                    }
                    else
                    {
                        System.out.println("Invalid Option :( Please try again. [Y/N]");
                    }
                }
                catch(IOException exception)
                {
                }
            }
            while(!isCorrect);
            if(input.equals("N") || input.equals("n"))
            {
                isPlaying = false;
                System.out.println("Your wins: " + playerWins);
                System.out.println("Dealer wins: " + dealerWins);
                System.out.println("Thanks for playing " + name + "! Goodbye :)");
            }
            seperate();
        }
        while(isPlaying);
    }
}
