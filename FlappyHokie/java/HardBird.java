import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Subclass of FlappyHokie that is fast.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.04.30)
 */
public class HardBird extends FlappyHokie
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HardBird object.
     */
    public HardBird()
    {
        // Leave empty
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Override the wrapAround() method.
     */
    public void wrapAround()
    {
        if (this.getGridX() == this.getWorld().getWidth() - 1)
        {
            this.setGridX(1);
            super.wrapAround();
        }
        else
        {
            this.move(7);
        }
    }
}
