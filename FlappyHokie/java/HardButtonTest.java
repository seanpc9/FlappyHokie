import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in the HardButton class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class HardButtonTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private HardButton button;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HardButtonTest test object.
     */
    public HardButtonTest()
    {
        // Leave empty.
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
        button = world.getHard();
    }


    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown() method. This method should remove
     * all of the buttons, populate the world with a HardBird and
     * pipes, and create a scoreboard.
     */
    public void testOnTouchDown()
    {
        button.onTouchDown();
        List<HardBird> birds = world.getObjects(HardBird.class);
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertNotNull(birds.get(0));
        assertEquals(6, pipes.size());
        assertNotNull(world.getMessage());
        // make sure all buttons have been removed
        assertNull(world.getOneObjectAt(200, 425));
        assertNull(world.getOneObjectAt(500, 425));
        assertNull(world.getOneObjectAt(800, 425));
    }
}
