import sofia.micro.*;
import java.util.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods of the FlappyHokie class.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.05.01)
 */
public class FlappyHokieTest extends TestCase
{
    //~ Fields ................................................................

    private FlappyWorld world;
    private FlappyHokie hokie;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlappyHokieTest test object.
     */
    public FlappyHokieTest()
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
        hokie = new FlappyHokie();
        world.remove(world.getEasy());
        world.remove(world.getMedium());
        world.remove(world.getHard());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. The FlappyHokie should call the
     * lose() method from FlappyWorld and remove itself from the
     * world if it hits a pipe.
     */
    public void testAct1()
    {
        world.add(hokie, 200, 200);
        Pipe pipe = new Pipe();
        world.add(pipe, 200, 200);
        world.createScoreboard();
        hokie.act();
        assertNull(world.getOneObjectAt(200, 200, FlappyHokie.class));
        assertEquals(70, (int)world.getMessage().getTypeSize());
        assertEquals("Game Over!!! Your score is: " + hokie.getPoints(),
            world.getMessage().getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. The FlappyHokie should call the
     * lose() method from FlappyWorld and remove itself from the
     * world if it touches the top edge of the world.
     */
    public void testAct2()
    {
        world.add(hokie, 200, 1);
        world.createScoreboard();
        hokie.act();
        assertNull(world.getOneObjectAt(200, 200, FlappyHokie.class));
        assertEquals(70, (int)world.getMessage().getTypeSize());
        assertEquals("Game Over!!! Your score is: " + hokie.getPoints(),
            world.getMessage().getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. The FlappyHokie should call the
     * lose() method from FlappyWorld and remove itself from the
     * world if it touches the bottom edge of the world.
     */
    public void testAct3()
    {
        world.add(hokie, 200, world.getHeight() - 1);
        world.createScoreboard();
        hokie.act();
        assertNull(world.getOneObjectAt(200, 200, FlappyHokie.class));
        assertEquals(70, (int)world.getMessage().getTypeSize());
        assertEquals("Game Over!!! Your score is: " + hokie.getPoints(),
            world.getMessage().getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. The FlappyHokie should just wrap
     * around and fall if it is not touching a pipe or the top
     * or bottom edge of the world.
     */
    public void testAct4()
    {
        world.add(hokie, 200, 250);
        hokie.act();
        assertEquals(200, hokie.getGridX());
        assertEquals(251, hokie.getGridY());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. If isFlapping is true, then add
     * flapping to speed and reset isFlapping. Also, if speed
     * is greater than 4, set speed equal to 4.
     */
    public void testAct5()
    {
        world.add(hokie, 200, 250);
        hokie.setFlapping(true);
        hokie.act();
        assertEquals(200, hokie.getGridX());
        assertEquals(230, hokie.getGridY());
        assertEquals(4, hokie.getSpeed());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the act() method. If speed is less than -6, then set
     * the speed equal to -6.
     */
    public void testAct6()
    {
        world.add(hokie, 200, 250);
        hokie.setSpeed(-10);
        hokie.act();
        assertEquals(200, hokie.getGridX());
        assertEquals(256, hokie.getGridY());
        assertEquals(-6, hokie.getSpeed());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getSpeed() method. It should return speed. Also
     * tests the setSpeed() method. It sets a new value for speed.
     */
    public void testGetAndSetSpeed()
    {
        hokie.setSpeed(2);
        assertEquals(2, hokie.getSpeed());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getFlapping() method. It should return the value
     * of isFlapping. Also tests the setFlapping() method. It
     * sets a new value for isFlapping.
     */
    public void testGetAndSetFlapping()
    {
        hokie.setFlapping(true);
        assertEquals(true, hokie.getFlapping());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getVertical() method. It should return vertical.
     * Also tests the setVertical() method. It sets a new value
     * for vertical.
     */
    public void testGetAndSetVertical()
    {
        hokie.setVertical(5);
        assertEquals(5, hokie.getVertical());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the getPoints() method. It should return points. Also
     * tests the setPoints() method. It sets a new value for points.
     */
    public void testGetAndSetPoints()
    {
        hokie.setPoints(25);
        assertEquals(25, hokie.getPoints());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the flap() method. If j is greater than zero, then 
     * the bird should flap up 5 cells for as many times as given
     * in the parameter.
     */
    public void testFlap1()
    {
        world.populate(hokie);
        hokie.flap(5);
        assertEquals(20, hokie.getGridX());
        assertEquals(225, hokie.getGridY());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the flap() method. If j is less than zero, then 
     * the bird should flap down 1 cell for as many times as given
     * in the parameter.
     */
    public void testFlap2()
    {
        world.populate(hokie);
        hokie.flap(-5);
        assertEquals(20, hokie.getGridX());
        assertEquals(255, hokie.getGridY());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the reset() method. The world that the bird is in
     * should remove the scoreboard and pipes, update them, and
     * then place them back into the word.
     */
    public void testReset()
    {
        world.populate(hokie);
        world.createScoreboard();
        hokie.reset();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertNotNull(world.getMessage());
        assertEquals(6, pipes.size());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the wrapAround() method. If points is equal to zero,
     * then points should be set to five and the world should be
     * reset.
     */
    public void testWrapAround1()
    {
        world.populate(hokie);
        world.createScoreboard();
        hokie.wrapAround();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertNotNull(world.getMessage());
        assertEquals(6, pipes.size());
        assertEquals(5, hokie.getPoints());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the wrapAround() method. If points is not equal to
     * zero, then points should double
     */
    public void testWrapAround2()
    {
        world.populate(hokie);
        world.createScoreboard();
        hokie.setPoints(5);
        hokie.wrapAround();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        assertNotNull(world.getMessage());
        assertEquals(6, pipes.size());
        assertEquals(10, hokie.getPoints());
    }
}
