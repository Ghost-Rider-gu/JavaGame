package GameEngine;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.Font;
import java.io.InputStream;

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
     * Main font for CREDITS
     */
    private TrueTypeFont menuFont;

    /**
     * Main text for CREDITS
     */
    private final String creditsText = "Game name: A L I E N  S H O O T E R" + System.lineSeparator() +
                                       "Authors: Ghost Rider aka Golubnichenko Yuriy & Mary Golubnichenko" + System.lineSeparator() +
                                       "Main programmer: Golubnichenko Yuriy & Main designer: Mary Golubnichenko" + System.lineSeparator() +
                                       "HAVE FUN!!! ))";

    // params for render string (char by char)
    private int count = 0;
    private int index = 0;

    /**
     * Rendering text
     */
    private String renderText = "";

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

        // set default font for main menu
        InputStream menuFont = ResourceLoader.getResourceAsStream(this.PATH_RESOURCES + "fonts/CreditsFont.ttf");

        try {
            Font mainFont = Font.createFont(Font.TRUETYPE_FONT, menuFont);
            mainFont = mainFont.deriveFont(32f);

            this.menuFont = new TrueTypeFont(mainFont, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

        this.menuFont.drawString((gameContainer.getScreenWidth() / 2) - 400, (gameContainer.getScreenHeight() / 2) - 300, this.renderText, Color.white);
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
        Input creditInput = gameContainer.getInput();

        // if pressed key ESC then return to main menu
        if(creditInput.isKeyDown(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(0);
        }

        // update rendering string
        if(count < 50) {
            count += delta;
        } else {
            count = 0;
            if(index < this.creditsText.length()) {
                this.renderText += this.creditsText.charAt(index++);
            }
        }
    }
}
