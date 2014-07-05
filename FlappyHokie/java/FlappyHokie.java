import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  This Actor represents the bird that the user controls in the game.
 *
 *  @author Sean Crenshaw
 *  @version (2014.04.29)
 */
public class FlappyHokie extends Actor
{
    //~ Fields ................................................................

    private int vertical;
    private int speed;
    private int points;
    /**
     * Constant downward acceleration
     */
    static final int GRAVITY = -1;
    /**
     * Upward acceleration when isFlapping
     */
    static final int FLAPPING = 10;
    private Boolean isFlapping;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlappyHokie object.
     */
    public FlappyHokie()
    {
        vertical = this.getVertical() / 2;
        speed = 0;
        points = 0;
        isFlapping = false;
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * If a FlappyHokie hits a pipe, the top edge, or the bottom
     * edge of the world, it removes itself from the world and
     * the game is lost. Otherwise, the FlappyHokie wrapsAround
     * the world and flaps at the given speed.
     */
    public void act()
    {
        if (this.getOneIntersectingObject(Pipe.class) != null
            || this.getGridY() == 1
            || this.getGridY() == this.getWorld().getHeight() - 1)
        {
            FlappyWorld world = (FlappyWorld)this.getWorld();
            world.lose();
            this.remove();
        }
        else
        {
            speed += GRAVITY;
            if (isFlapping)
            {
                speed += FLAPPING;
                this.setFlapping(false);
            }
            
            if (speed < -6)
            {
                speed = -6;
            }
            
            if (speed > 4)
            {
                speed = 4;
            }
            this.wrapAround();
            this.flap(speed);
        }
    }
    
    
    // ----------------------------------------------------------
    /**
     * Get the value of speed.
     * @return speed.
     */
    public int getSpeed()
    {
        return speed;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Changes the value of speed.
     * @param s new speed
     */
    public void setSpeed(int s)
    {
        speed = s;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Get the value of isFlapping.
     * @return true or false.
     */
    public boolean getFlapping()
    {
        return isFlapping;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Changes the status of isFlapping.
     * @param t true or false
     */
    public void setFlapping(boolean t)
    {
        isFlapping = t;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Get the height of the FlappyHokie.
     * @return This FlappyHokie's height.
     */
    public int getVertical()
    {
        return vertical;
    }


    // ----------------------------------------------------------
    /**
     * Set the height of the FlappyHokie.
     * @param h new value for height.
     */
    public void setVertical(int h)
    {
        vertical = h;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Get the points of the FlappyHokie.
     * @return This FlappyHokie's points.
     */
    public int getPoints()
    {
        return points;
    }


    // ----------------------------------------------------------
    /**
     * Set the points of the FlappyHokie.
     * @param p new value for points.
     */
    public void setPoints(int p)
    {
        points = p;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Move up j cells one cell at a time.
     * @param j number of cells
     */
    public void flap(int j)
    {
        if (j >= 0)
        {
            for (int i = 0; i < j; i++)
            {
                this.setGridY(this.getGridY() - 5);
            }
        }
        else
        {
            for (int i = 0; i > j; i--)
            {
                this.setGridY(this.getGridY() + 1);
            }
        }
    }
    
    
    // ----------------------------------------------------------
    /**
     * Remove scoreboard and pipes, update them, and then place
     * them back into the world.
     */
    public void reset()
    {
        FlappyWorld world = (FlappyWorld)this.getWorld();
        world.remove(world.getMessage());
        world.createScoreboard();
        List<Pipe> pipes = world.getObjects(Pipe.class);
        for (Pipe pipe : pipes)
        {
            pipe.remove();
        }
        world.placePipes();
    }
    
    
    // ----------------------------------------------------------
    /**
     * This is a base method that will be overwritten in the
     * subclasses to make more sense. Right now it simply
     * updates the score and resets the world with random pipes.
     */
    public void wrapAround()
    {
        if (points == 0)
        {
            this.setPoints(5);
            this.reset();
        }
        else
        {
            // more points get added as the game gets harder
            this.setPoints(this.getPoints() * 2);
            this.reset();
        }
    }
}
