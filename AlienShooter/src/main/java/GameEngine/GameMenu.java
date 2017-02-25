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

    // Start play button (inactive and active)
    private Image playButton;
    private Image playButtonActive;

    // Show credits button (inactive and active)
    private Image creditsButton;
    private Image creditsButtonActive;

    // Exit button (inactive and active)
    private Image exitButton;
    private Image exitButtonActive;

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
        this.background = new Image(this.RESOURCE_PATH + "backgrounds/MenuBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());
        this.cursor     = new Image(this.RESOURCE_PATH + "ui_elements/Cursor.png");

        // prepare our buttons
        this.playButton             = new Image(this.RESOURCE_PATH + "ui_elements/buttons/PlayInactive.png");
        this.playButtonActive       = new Image(this.RESOURCE_PATH + "ui_elements/buttons/PlayActive.png");
        this.creditsButton          = new Image(this.RESOURCE_PATH + "ui_elements/buttons/CreditsInactive.png");
        this.creditsButtonActive    = new Image(this.RESOURCE_PATH + "ui_elements/buttons/CreditsActive.png");
        this.exitButton             = new Image(this.RESOURCE_PATH + "ui_elements/buttons/ExitInactive.png");
        this.exitButtonActive       = new Image(this.RESOURCE_PATH + "ui_elements/buttons/ExitActive.png");

        gameContainer.setMouseCursor(this.cursor, 0, 0);
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
        // get half screen (width and height)
        int xPos = gameContainer.getScreenWidth() / 2;
        int yPos = gameContainer.getScreenHeight() / 2;

        // background
        graphics.drawImage(this.background, 0, 0);

        // buttons (play, credits, exit)
        graphics.drawImage(this.playButton, xPos - (this.playButton.getWidth() / 2), yPos - 100);
        graphics.drawImage(this.creditsButton, xPos - (this.creditsButton.getWidth() / 2), yPos);
        graphics.drawImage(this.exitButton, xPos - (this.exitButton.getWidth() / 2), yPos + 100);
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
