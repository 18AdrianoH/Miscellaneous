import java.io.IOException;


public class Main
{

    /**
     * A simple program to capture key presses from System.in
     * Note that the input stream will not indicate anything 
     * available until after a end of line is entered, then each
     * character will be processed one at a time.
     * The stream read() method returns an int, so it must be first typecast
     * to a char and then into a string
     * @author Mr. Page
     */
    public static void main(String[] args)
    {
        String key = "";
        while(true)
        {
            try
            {
                // wait for input to become available
                while(System.in.available() == 0)
                {
                    Thread.sleep(10);
                }
            }
            catch(InterruptedException e)
            {
                die(e);
            }
            catch (IOException e)
            {
                die(e);
            }
            try
            {
                key = "" + (char)System.in.read();
                // eliminate white space
                if(!key.equals("\n") && !key.equals("\r") && !key.equals("\t") && !key.equals(" "))
                // this is where you would process the key press
                System.out.println("you pressed " + key);
            }

            catch (IOException e)
            {
                die(e);
            }

        }
    }
    /**
     * on error, print the stack trace and kill the program
     * @param e - the exception that was thrown
     */
    public static void die(Exception e)
    {
        e.printStackTrace();
        System.out.println("Die! Die! Die!");
        System.exit(1);
    }

}
