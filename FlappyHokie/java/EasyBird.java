import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Subclass of FlappyHokie that is slow.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.04.30)
 */
public class EasyBird extends FlappyHokie
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new EasyBird object.
     */
    public EasyBird()
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
            this.move(3);
        }
    }
}
