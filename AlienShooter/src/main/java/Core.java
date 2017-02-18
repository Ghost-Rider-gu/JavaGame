import org.newdawn.slick.*;

public class Core extends BasicGame
{
    /**
     * Background game (image)
     */
    private Image background;

    /**
     * Constructor
     *
     * @param title
     */
    public Core(String title)
    {
        super(title);
    }

    /**
     * Game entry point
     *
     * @param args
     */
    public static void main(String[] args)
    {
        try {
            AppGameContainer alienShooter;

            alienShooter = new AppGameContainer(new Core("Alien Shooter - the space adventure"));
            alienShooter.setDisplayMode(800, 600, false);
            alienShooter.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Prepare game elements
     */
    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        this.background = new Image("AlienShooter/resources/background/SpaceBack.png");
    }

    /**
     * Update state
     *
     * @param gameContainer
     * @param i
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException
    {

    }

    /**
     * Rendering, draw game elements
     *
     * @param gameContainer
     * @param graphics
     * @throws SlickException
     */
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.drawImage(this.background, 0,0);
    }
}
