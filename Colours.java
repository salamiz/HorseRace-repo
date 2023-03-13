// enum: enumerated Group  of constants
    // enums are static by default
    enum Colour 
    {
        // 0    1     2      3      4       5      6     7
        BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, GREY;

        /* Dark Version of colour */
        int dark()
        {
            return ordinal() + 30;
        }

        /* Bright version of colour */
        int bright()
        {
            return ordinal() + 90;
        }
    }

/**
 * Colours Methods
 */
public class Colours 
{
    // Constant - Only available to the colour methods
    static final private String SET_COLOUR = "\033[%sm";

    /**
     * Reset colours to default
     */
    static void resetColours()
    {
        setColour(0);
    }
    

    
    /**
     * Change the foreground colour (text colour)
     * @param foreground Font colour
     */
    static void setColour(int foreground)
    {
        System.out.printf(SET_COLOUR, foreground);
    }


    /**
     * Change the foreground colour (text colour) and background colour
     * @param background background colour
     * @param foreground Font colour
     */
    static void setColour(int foreground, int background)
    {
        background += 10; // Convert to background colour
        System.out.printf(SET_COLOUR, foreground);
        System.out.printf(SET_COLOUR, background);
    }



    /**
     * Prints coloured text ending with a new line
     * @param prompt The text to be printed
     * @param foreground Text colour
     **/
    static void print(String prompt, int foreground)
    {
        setColour(foreground);
        System.out.println(prompt);
        resetColours();
    }


    /**
     * Prints coloured text ending with a new line
     * @param prompt The text to be printed
     * @param foreground Text colour
     * @param background Background colour
     **/
    static void print(String prompt, int foreground, int background)
    {
        setColour(foreground);
        setColour(background);
        System.out.println(prompt);
        resetColours();
    }
}