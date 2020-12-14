import java.util.Random;
/**
 * Write a description of class Cell here.
 *
 * @author Milo Baker
 * @version 11/18/20
 */
public class Cell
{
    private boolean living;
    Random rng = new Random();


    /**
     * Constructor for objects of class Cell that has a 50% chance of 
     * it being dead or alive
     */
    public Cell()
    {
        Random rng = new Random();
          if (rng.nextInt(2) == 0) {
            living = false;
        } else {
            living = true;
        }

    }

    /**
     * Constructor that allows the user to input the status of being alive
     * as true or false
     */
    public Cell (boolean assignment){
        living = assignment;
    }

    /**
     * Method that returns if the status of a cell being alive is true or
     * false
     */
    public boolean isAlive(){
        return living;
    }
}
