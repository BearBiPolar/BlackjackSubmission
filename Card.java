
/**
 * Write a description of class Card here.
 *
 * @author William Wang
 * @version 2018.01.04
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int serial;
    private String display;
    private int value;

    /**
     * Constructor for objects of class card
     */
    public Card(int serial, String display, int value)
    {
        // initialise instance variables
        this.serial = serial;
        this.value = value;
        this.display = display;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    /**
     * Returns information about this card.
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String returnDisplay()
    {
        return display;
    }

    public int returnSerial()
    {
        return serial;
    }

    public int returnValue()
    {
        return value;
    }

    public boolean isAce()
    {
        boolean re = false;
        switch (returnSerial()) 
        {
            case 1: 
            case 14:  
            case 27: 
            case 40: re = true;
            break;
            default: 
            re = false;
            break;

        }
        return re;
    }
}
