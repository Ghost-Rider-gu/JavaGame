package GameEngine;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public final class GameMenu extends BasicGameState
{
    /**
     * Constant for resources path
     */
    private final String RESOURCE_PATH = "AlienShooter/resources/";

    /**
     * Main cursor for game
     */
    private Image cursor;

    /**
     * Background game
     */
    private Image background;

    /**
     * Constructor for menu screen
     *
     * @param gameMenu int
     */
    public GameMenu(int gameMenu)
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
        return 0;
    }

    /**
     * Prepare main menu elements
     *
     * @param gameContainer     {@link GameContainer}
     * @param stateBasedGame    {@link StateBasedGame}
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        this.background = new Image(this.RESOURCE_PATH + "background/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());
        this.cursor     = new Image(this.RESOURCE_PATH + "UI_Elements/cursor.png");

        gameContainer.setMouseCursor(this.cursor, 1,1);
    }

    /**
     * Rendering, draw images, text and other elements
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

    }
}
