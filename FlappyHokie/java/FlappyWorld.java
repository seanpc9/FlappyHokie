import sofia.micro.*;
import java.util.*;
import sofia.graphics.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  The world in which the FlappyHokie acts.
 *
 *  @author Sean Crenshaw (seanpc9)
 *  @version (2014.04.28)
 */
public class FlappyWorld extends World
{
    //~ Fields ................................................................

    private TextShape text;
    private int rand;
    private EasyButton button1;
    private MediumButton button2;
    private HardButton button3;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FlappyWorld object.
     */
    public FlappyWorld()
    {
        super(1000, 500, 1);
        // add the start menu
        button1 = new EasyButton();
        this.add(button1, 200, this.getHeight() / 2);
        button2 = new MediumButton();
        this.add(button2, 500, this.getHeight() / 2);
        button3 = new HardButton();
        this.add(button3, 800, this.getHeight() / 2);
    }


    //~ Methods ...............................................................
    
    // ----------------------------------------------------------
    /**
     * Create three sets of pipes.
     */
    public void placePipes()
    {        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (j == 0)
                {
                    rand = Random.generator().nextInt(126) - 25;
                    Pipe botpipe = new Pipe();
                    this.add(botpipe, 375 * (i + 1) - (100 * i),
                        this.getHeight() - (80 - rand));
                }
                else
                {
                    Pipe toppipe = new Pipe();
                    this.add(toppipe, 375 * (i + 1) - (100 * i) , rand);
                    toppipe.turn(180);
                }
            }
        }
    }
    
    
    // ----------------------------------------------------------
    /**
     * Creates a flappy Bird on the left edge of the map with
     * three randomly placed pipes on the top and bottom.
     * @param birdie the FlappyHokie in the world
     */
    public void populate(FlappyHokie birdie)
    {
        FlappyHokie hokie = birdie;
        this.add(hokie, 20, this.getHeight() / 2);
        this.placePipes();
    }
    
    
    // ----------------------------------------------------------
    /**
     * Makes the FlappyHokie flap everytime the user taps
     * the screen.
     */
    public void onTouchDown()
    {
        List<FlappyHokie> birds = this.getObjects(FlappyHokie.class);
        if (birds.size() != 0)
        {
            FlappyHokie bird = birds.get(0);
            bird.setFlapping(true);
        }
    }
    
    
    // ----------------------------------------------------------
    /**
     * Creates a scoreboard in the upper left hand corner.
     */
    public void createScoreboard()
    {
        List<FlappyHokie> birds = this.getObjects(FlappyHokie.class);
        FlappyHokie bird = birds.get(0);
        text = new TextShape("Score: " + bird.getPoints());
        this.add(text, 110, 30);
        text.setTypeSize(50);
        text.setColor(Color.rgb(0xff, 0xaa, 0x88));
    }
    
    
    // ----------------------------------------------------------
    /**
     * Ends the game and creates a game over message.
     */
    public void lose()
    {
        List<FlappyHokie> birds = this.getObjects(FlappyHokie.class);
        FlappyHokie bird = birds.get(0);
        this.remove(this.getMessage());
        text = new TextShape(
            "Game Over!!! Your score is: " + bird.getPoints());
        this.add(text, this.getWidth() / 2, this.getHeight() / 2);
        text.setTypeSize(70);
        text.setColor(Color.white);
    }
        
    
    // ----------------------------------------------------------
    /**
     * Returns the TextShape representing the scoreboard.
     * @return the scoreboard
     */
    public TextShape getMessage()
    {
        return text;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Returns an EasyButton object.
     * @return button1
     */
    public EasyButton getEasy()
    {
        return button1;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Returns a MediumButton object.
     * @return button2
     */
    public MediumButton getMedium()
    {
        return button2;
    }
    
    
    // ----------------------------------------------------------
    /**
     * Returns a HardButton object.
     * @return button3
     */
    public HardButton getHard()
    {
        return button3;
    }
}
