package GameEngine;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public final class GameCredits extends BasicGameState
{
    /**
     * Background for this state
     */
    private Image background;

    /**
     * Const with path to resources
     */
    private final String PATH_RESOURCES = "AlienShooter/resources/";

    /**
     *  Constructor for game credits
     *
     * @param gameCredits int
     */
    public GameCredits(int gameCredits)
    {

    }

    /**
     * Get state id
     *
     * @return int
     */
    @Override
    public int getID()
    {
        return 2;
    }

    /**
     * Prepare elements for subtitles state
     *
     * @param gameContainer     {@link GameContainer}
     * @param stateBasedGame    {@link StateBasedGame}
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        // set background
        this.background = new Image(this.PATH_RESOURCES + "backgrounds/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());
    }

    /**
     * Rendering, draw images, text or other elements
     *
     * @param gameContainer     {@link GameContainer}
     * @param stateBasedGame    {@link StateBasedGame}
     * @param graphics          {@link Graphics}
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        graphics.drawImage(this.background, 0, 0);
    }

    /**
     * AI, game logic
     *
     * @param gameContainer     {@link GameContainer}
     * @param stateBasedGame    {@link StateBasedGame}
     * @param delta             int
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException
    {
        Input myInput = gameContainer.getInput();

        // if pressed key ESC then will return to main menu
        if(myInput.isKeyDown(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(0);
        }
    }
}
