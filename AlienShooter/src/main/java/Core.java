import org.newdawn.slick.*;

public class Core extends BasicGame
{
    /**
     * Constant for resources path
     */
    private final String resourcePath = "AlienShooter/resources/";

    /**
     * Background game (image)
     */
    private Image background;

    /**
     * Main player
     */
    private Image shipMaster;

    // Parameters for main player
    private float x = 200.0f;
    private float y = 200.0f;
    private float speed = 0.2f;

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
        this.background = new Image(this.resourcePath + "background/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());
        this.shipMaster = new Image(this.resourcePath + "sprites/MainPlayer.png");
    }

    /**
     * AI, game logic
     *
     * @param gameContainer
     * @param delta
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        Input mainInput = gameContainer.getInput();

        if (mainInput.isKeyDown(Input.KEY_RIGHT)) {
            x += this.speed * delta;
        }

        if (mainInput.isKeyDown(Input.KEY_LEFT)) {
            x -= this.speed * delta;
        }
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
        graphics.drawImage(this.shipMaster, this.x, this.y);
    }
}
