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
     * Sprite - main player
     */
    private Image mainPlayer;

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

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException
    {
        // set the background
        this.backgroung = new Image(this.PATH_RESOURCES + "backgrounds/SpaceBack.png").getScaledCopy(gameContainer.getScreenWidth(), gameContainer.getScreenHeight());

        // main player
        this.mainPlayer = new Image(this.PATH_RESOURCES + "sprites/MainPlayer.png");

        this.xPosPlayer = (gameContainer.getScreenWidth() / 2) - this.mainPlayer.getWidth();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException
    {
        // set y position for main player
        int yPos = gameContainer.getScreenHeight() - (this.mainPlayer.getHeight() + 10);

        graphics.drawImage(this.backgroung, 0, 0);

        graphics.drawImage(this.mainPlayer, this.xPosPlayer, yPos);
    }

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
