import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Test the methods in the Pipe class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class PipeTest extends TestCase
{
    //~ Fields ................................................................
    
    private FlappyWorld world;
    private Pipe pipe;
    private MediumBird hokie;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new PipeTest test object.
     */
    public PipeTest()
    {
        // Leave empty
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        world = new FlappyWorld();
        hokie = new MediumBird();
        pipe = new Pipe();
        world.add(pipe, 200, 200);
        world.remove(world.getEasy());
        world.remove(world.getMedium());
        world.remove(world.getHard());
    }


    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown() method. The FlappyHokie should
     * flap every time the user taps a pipe.
     */
    public void testOnTouchDown1()
    {
        world.populate(hokie);
        pipe.onTouchDown();
        hokie.act();
        assertEquals(230, hokie.getGridY());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown() method. If there is no FlappyHokie
     * in the world, nothing happens.
     */
    public void testOnTouchDown2()
    {
        pipe.onTouchDown();
        // make sure world did not change
        List<Pipe> pipes = world.getObjects(Pipe.class);
        List<FlappyHokie> birds = world.getObjects(FlappyHokie.class);
        assertEquals(1, pipes.size());
        assertEquals(0, birds.size());
    }
}
