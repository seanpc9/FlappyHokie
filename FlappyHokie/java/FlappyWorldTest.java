import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in the FlappyWorld class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class FlappyWorldTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private MediumBird hokie;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlappyWorldTest test object.
     */
    public FlappyWorldTest()
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
     * Tests the constructor. Three buttons should be created.
     */
    public void testConstructor()
    {
        assertEquals(1000, world.getWidth());
        assertEquals(500, world.getHeight());
        assertNotNull(world.getEasy());
        assertNotNull(world.getMedium());
        assertNotNull(world.getHard());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the placePipes() method. Three sets of pipes should
     * be added to the world.
     */
    public void testPlacePipes()
    {
        world.placePipes();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertEquals(6, pipes.size());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the populate() method. The FlappyHokie and pipes
     * should be created and added to the world.
     */
    public void testPopulate()
    {
        world.populate(hokie);
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertEquals(20, hokie.getGridX());
        assertEquals(250, hokie.getGridY());
        assertEquals(6, pipes.size());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the onTouchDown() method. The FlappyHokie should
     * flap every time the user taps the screen.
     */
    public void testOnTouchDown1()
    {
        world.populate(hokie);
        world.onTouchDown();
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
        world.onTouchDown();
        // make sure world did not change
        List<Pipe> pipes = world.getObjects(Pipe.class);
        List<FlappyHokie> birds = world.getObjects(FlappyHokie.class);
        assertEquals(0, pipes.size());
        assertEquals(0, birds.size());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the createScoreboard() method. A scoreboard should
     * be created in the upper left hand corner. This also tests
     * the getMessage() method. It should return the "text" field.
     */
    public void testCreateScoreboardAndGetMessage()
    {
        world.populate(hokie);
        world.createScoreboard();
        assertEquals(50, (int)world.getMessage().getTypeSize());
        assertEquals("Score: " + hokie.getPoints(),
            world.getMessage().getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the lose() method. The game should end and a game
     * over message should be created.
     */
    public void testLose()
    {
        world.populate(hokie);
        world.createScoreboard();
        world.lose();
        assertEquals(70, (int)world.getMessage().getTypeSize());
        assertEquals("Game Over!!! Your score is: " + hokie.getPoints(),
            world.getMessage().getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getEasy() method. It should return button1.
     */
    public void testGetEasy()
    {
        assertNotNull(world.getEasy());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getMedium() method. It should return button2.
     */
    public void testGetMedium()
    {
        assertNotNull(world.getMedium());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getHard() method. It should return button3.
     */
    public void testGetHard()
    {
        assertNotNull(world.getHard());
    }
}
