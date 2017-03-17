package GameEngine;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GamePlay extends BasicGameState
{
    /**
     * Const for resources
     */
    private final String PATH_RESOURCES = "AlienShooter/resources/";

    /**
     * Background for this state
     */
    private Image backgroung;

    /**
     * Game play music
     */
    private Music playTheme;

    /**
     * Sprite - main player
     */
    private Image mainPlayer;

    private Image playerLife;
    private Image countLife;
    private Image xImage;

    // Parameters for main player
    private float xPosPlayer;
    private float speedPlayer = 0.2f;

    /**
     * Constructor for play screen
     *
     * @param gamePlay int
     */
    public GamePlay(int gamePlay)
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
        return 1;
    }

    /**
     * Prepare the GamePlay
     *
     * @param gameContainer     {@link GameContainer}
     * @param stateBasedGame    {@link StateBasedGame}
     *
     * @throws SlickException   {@link SlickException}
     */
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        // set the background
        this.backgroung = new Image(this.PATH_RESOURCES + "backgrounds/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());

        // main player
        this.mainPlayer = new Image(this.PATH_RESOURCES + "sprites/MainPlayer.png");

        this.playerLife = new Image(this.PATH_RESOURCES + "ui_elements/PlayerLife.png");

        this.xImage = new Image(this.PATH_RESOURCES + "ui_elements/numbers/X.png");

        this.xPosPlayer = (gameContainer.getScreenWidth() / 2) - this.mainPlayer.getWidth();

        if (!gameContainer.isMouseGrabbed()) {
            gameContainer.setMouseGrabbed(true);
        }
    }

    /**
     * Rendering, draw images etc.
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
        // set y position for main player
        int yPos = gameContainer.getScreenHeight() - (this.mainPlayer.getHeight() + 10);

        graphics.drawImage(this.backgroung, 0, 0);

        graphics.drawImage(this.playerLife, gameContainer.getScreenWidth() - 100, 20);

        graphics.drawImage(this.xImage, gameContainer.getScreenWidth() - 60, 25);

        graphics.drawImage(this.mainPlayer, this.xPosPlayer, yPos);
    }

    /**
     * AI game
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
        Input playInput = gameContainer.getInput();

        // if pressed key ESC then return to main menu
        if (playInput.isKeyDown(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(0);
        }

        // move left
        if (playInput.isKeyDown(Input.KEY_LEFT)) {
            this.xPosPlayer -= this.speedPlayer * delta;
        }

        // move right
        if (playInput.isKeyDown(Input.KEY_RIGHT)) {
            this.xPosPlayer += this.speedPlayer * delta;
        }
    }
}
