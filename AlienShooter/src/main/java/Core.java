import GameEngine.GameMenu;
import GameEngine.GamePlay;
import GameEngine.GameCredits;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The Game Core (include game states, configuration game)
 */
public final class Core extends StateBasedGame
{
    /**
     * Game name
     */
    private static final String GAME_NAME = "Alien Shooter - the space adventure";

    /**
     * Screen width (pixels)
     */
    private static final int SCREEN_WIDTH = 1600;

    /**
     * Screen height (pixels)
     */
    private static final int SCREEN_HEIGHT = 900;

    /**
     * Game state MENU
     */
    private static final int GAME_MENU = 0;

    /**
     * Game state PLAY
     */
    private static final int GAME_PLAY = 1;

    /**
     * Game state CREDITS
     */
    private static final int GAME_CREDITS = 2;


    /**
     * Constructor (prepare the elements game)
     *
     * @param gameName String
     */
    public Core(String gameName)
    {
        super(gameName);

        // add all the game states
        this.addState(new GameMenu(GAME_MENU));
        this.addState(new GamePlay(GAME_PLAY));
        this.addState(new GameCredits(GAME_CREDITS));
    }

    /**
     * Game entry point
     *
     * @param args String[]
     */
    public static void main(String[] args)
    {
        AppGameContainer alienShooter;

        try {
                alienShooter = new AppGameContainer(new Core(GAME_NAME));
                alienShooter.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, true);
                alienShooter.setTargetFrameRate(60);
                alienShooter.setShowFPS(false);
                alienShooter.setAlwaysRender(true);
                alienShooter.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initial all game screen
     *
     * @param gameContainer     {@link GameContainer}
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException
    {
        // Init screens
        this.getState(GAME_MENU).init(gameContainer, this);
        this.getState(GAME_PLAY).init(gameContainer, this);
        this.getState(GAME_CREDITS).init(gameContainer, this);

        // Starter screen
        this.enterState(GAME_MENU);
    }
}
