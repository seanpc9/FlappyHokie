import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  The obstacles that FlappyHokie must avoid.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.04.30)
 */
public class Pipe extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Pipe object.
     */
    public Pipe()
    {
        // Leave empty
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Makes the FlappyHokie flap everytime the user taps
     * the pipe.
     */
    public void onTouchDown()
    {
        List<FlappyHokie> birds = this.getWorld().getObjects(FlappyHokie.class);
        if (birds.size() != 0)
        {
            FlappyHokie bird = birds.get(0);
            bird.setFlapping(true);
        }
    }
}
