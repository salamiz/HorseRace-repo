// import the built-in Java class for generating random numbers
import java.util.Random;

/**
 * Horse
 */
public class Horse 
{
    // private variables only accessible within the class Horse
    private String name;
    private int distanceCovered = 0;
    private Random random = new Random();


    /**
     * Constructor to be accessible outide the class, i.e., an Object of the class
     * @return Horse object
     */
    Horse(String name)
    {
        // Initialize the private variables
        this.name = name;
    }


    /** Generate each Horse Object name
     * @return the variable name for each object
     */
    public String getName() {
        return name;
    }

    
    /** Generate each Horse Object distance Covered
     * @return the variable distanceCovered for each object
     */
    public int getDistanceCovered() {
        return distanceCovered;
    }


    /**
     * Method used to make Horse object run at random speed
     */
    public void run()
    {
        // Random number from 0 to 1 inclusive
        int speed = random.nextInt(0,2);
        // Add this random number to the variable distanceCovered
        distanceCovered += speed;
    }
}