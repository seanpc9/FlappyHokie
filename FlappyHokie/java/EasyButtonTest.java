import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in the EasyButton class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class EasyButtonTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private EasyButton button;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EasyButtonTest test object.
     */
    public EasyButtonTest()
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
        button = world.getEasy();
    }


    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown() method. This method should remove
     * all of the buttons, populate the world with an EasyBird and
     * pipes, and create a scoreboard.
     */
    public void testOnTouchDown()
    {
        button.onTouchDown();
        List<EasyBird> birds = world.getObjects(EasyBird.class);
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
