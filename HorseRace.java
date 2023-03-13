// Name: Zulkifli Salami
// Date: March 10th, 2023
// App Name: Horse Race
// Description: App to practise using inheritance in programming


public class HorseRace 
{
    // Constants for determining half a second with a value of 500 milliseconds
    private static final int HALF_SECOND = 500;

    /**
     * Method that stops code execution for half a second
     */
    static void waitHalfSecond()
    {
        try {
            // pause the code execution for HALF_SECOND milliseconds
            Thread.sleep(HALF_SECOND);
        // catch an InterruptedException if it occurs
        } catch (InterruptedException exception) {
            // do nothing
        }
    }


    /**
     * Method to draw a line representing the distance covered by each horse
     * @param horse a horse object from the class Horse
     */
    static void drawDistanceLine(Horse horse)
    {
        int distance = horse.getDistanceCovered(); // get the distance covered by the horse and cast it to an integer
        //// in case the horse wins (i.e. distance covered is 20)
        if (distance == 20)
        {
            // Set winner colour
            Colours.setColour(Colour.CYAN.bright());
            for (int index = 0; index < distance; index++) { // iterate over the distance covered by the horse
                System.out.print("."); // print a dot character for each unit of distance covered
            }
            // Print out the winner
            System.out.print(" "+ horse.getName()+" wins\n");
            // Reset colours
            Colours.resetColours();

        }
        else
        {
            for (int index = 0; index < distance; index++) { // iterate over the distance covered by the horse
                System.out.print("."); // print a dot character for each unit of distance covered
            }
            System.out.print(" "+ horse.getName()+"\n");
        }
    }



    

    public static void main(String[] args) 
    {
        // Set the App title from the Console Class
        Console.setTitle("Horse Race - Zulkifli Salami");

        // Pre-defined array of Horse objects
        Horse[] runners =
        {
            new Horse("Snowfall"),
            new Horse("GOT"),
            new Horse("BMF"),
            new Horse("Power"),
            new Horse("Viking")
        };

        // Variables 
        String banner;
        boolean startRace = true;

        
        // Format the App Banner from the console class
        banner = Console.formatBanner("Horse Race");

        // Output Screen 
        while(startRace)
        {
            // Clear terminal from the Console class
            Console.clearTerminal();

            // Print the Banner
            Console.print(banner);
            
            // Set Race track colour
            Colours.setColour(Colour.RED.bright());
            // Race track start
            Console.print("\n====================");
            // Reset colour
            Colours.resetColours();

            // call the run() method on each Horse object to move them forward
            for (int index = 0; index < runners.length; index++) 
            {
                runners[index].run(); // move each horse object forward
                drawDistanceLine(runners[index]); // draw the distance covered by the horse so far
                if (runners[index].getDistanceCovered() == 20)
                {
                    startRace = false;
                }
            }

            // Set Race track colour
            Colours.setColour(Colour.RED.bright());
            // Race track end
            Console.print("====================");
            // Reset colour
            Colours.resetColours();

            waitHalfSecond(); // pause for half a second to update the race twice per second
        }
            
        // Check which horses won the race
        System.out.println("\nThe race is over!");
        // loop through the horses in the array
        for (Horse horse : runners)
        {
            if (horse.getDistanceCovered() == 20)
            {
                System.out.println(horse.getName()+" won the race!");
            }
        }


        // Prompting the user to exit the program from console class
        Console.input("\nPress [enter] to exit: ");
        // Closing the Scanner from the Console Class 
        Console.closeScanner();   
    }
}
