import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in the EasyBird class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class EasyBirdTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private EasyBird hokie;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EasyBirdTest test object.
     */
    public EasyBirdTest()
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
        hokie = new EasyBird();
        world.remove(world.getEasy());
        world.remove(world.getMedium());
        world.remove(world.getHard());
    }


    // ----------------------------------------------------------
    /**
     * Tests the wrapAround() method. If the EasyBird reaches the
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
     * Tests the wrapAround() method. If the EasyBird is not at
     * the right edge of the world, it will move three cells.
     */
    public void testWrapAround2()
    {
        world.populate(hokie);
        hokie.wrapAround();
        assertEquals(23, hokie.getGridX());
    }
}
