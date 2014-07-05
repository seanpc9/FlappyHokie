import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in the MediumBird class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class MediumBirdTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private MediumBird hokie;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MediumBirdTest test object.
     */
    public MediumBirdTest()
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
        hokie = new MediumBird();
        world.remove(world.getEasy());
        world.remove(world.getMedium());
        world.remove(world.getHard());
    }


    // ----------------------------------------------------------
    /**
     * Tests the wrapAround() method. If the MediumBird reaches the
     * right edge of the world, it should wrap back around to the
     * left edge of the world and update the world.
     */
    public void testWrapAround1()
    {
        world.populate(hokie);
        world.createScoreboard();
        hokie.setGridX(world.getWidth() - 1);
        hokie.wrapAround();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertNotNull(world.getMessage());
        assertEquals(6, pipes.size());
        assertEquals(5, hokie.getPoints());
        assertEquals(1, hokie.getGridX());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the wrapAround() method. If the MediumBird is not at
     * the right edge of the world, it will move three cells.
     */
    public void testWrapAround2()
    {
        world.populate(hokie);
        hokie.wrapAround();
        assertEquals(25, hokie.getGridX());
    }
}
