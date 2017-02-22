import GameEngine.GameMenu;
import GameEngine.GamePlay;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public final class Core extends StateBasedGame
{
    /**
     * Game name
     */
    public static final String GAME_NAME = "Alien Shooter - the space adventure";

    /**
     * Game state MENU
     */
    public static final int GAME_MENU = 0;

    /**
     * Game state PLAY
     */
    public static final int GAME_PLAY = 1;

    /**
     * Constant for resources path
     */
    private final String RESOURCE_PATH = "AlienShooter/resources/";

    /**
     * Background game (image)
     */
    private Image background;

    /**
     * Main player
     */
    private Image shipMaster;

    /**
     * Main cursor for game
     */
    private Image cursor;

    // Parameters for main player
    private float x = 200.0f;
    private float y = 200.0f;
    private float speed = 0.2f;

    /**
     * Constructor
     *
     * @param gameName
     */
    public Core(String gameName)
    {
        super(gameName);

        this.addState(new GameMenu(GAME_MENU));
        this.addState(new GamePlay(GAME_PLAY));
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
        this.background = new Image(this.RESOURCE_PATH + "background/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());
        this.shipMaster = new Image(this.RESOURCE_PATH + "sprites/MainPlayer.png");
        this.cursor     = new Image(this.RESOURCE_PATH + "UI_Elements/cursor.png");

        gameContainer.setMouseCursor(this.cursor, 1,1);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {

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
            this.x += this.speed * delta;
        }

        if (mainInput.isKeyDown(Input.KEY_LEFT)) {
            this.x -= this.speed * delta;
        }

        if (mainInput.isKeyDown(Input.KEY_UP)) {
            this.y -= this.speed * delta;
        }

        if (mainInput.isKeyDown(Input.KEY_DOWN)) {
            this.y += this.speed * delta;
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
