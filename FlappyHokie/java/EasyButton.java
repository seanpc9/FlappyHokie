import sofia.micro.*;
import sofia.graphics.*;

//-------------------------------------------------------------------------
/**
 *  This class represents the easy button.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.04.30)
 */
public class EasyButton extends TextShape 
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new StartScreen object.
     */
    public EasyButton()
    {
        super("Easy");
        super.setTypeSize(50);
        super.setColor(Color.rgb(0xff, 0xaa, 0x88));
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * When the button is clicked, the appropriate bird is creted,
     * the world is populated, and the buttons are removed.
     */
    public void onTouchDown()
    {
        FlappyWorld world = (FlappyWorld)this.getWorld();
        EasyBird hokie = new EasyBird();
        world.populate(hokie);
        world.createScoreboard();
        world.remove(world.getEasy());
        world.remove(world.getMedium());
        world.remove(world.getHard());
    }
}