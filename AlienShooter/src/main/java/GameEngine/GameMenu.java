package GameEngine;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.input.Mouse;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.ResourceLoader;

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
     * MenuTheme music
     */
    private Music menuTheme;

    /**
     * Main font for menu
     */
    private TrueTypeFont menuFont;

    /**
     * Animation background
     */
    private Animation backgroundAnim;

    // Start play button (inactive and active)
    private Image playButton;
    private Image playButtonActive;

    // Show credits button (inactive and active)
    private Image creditsButton;
    private Image creditsButtonActive;

    // Exit button (inactive and active)
    private Image exitButton;
    private Image exitButtonActive;

    // Changing buttons
    private Image playIsActive;
    private Image creditIsActive;
    private Image exitIsActive;

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
        // hide FPS
        gameContainer.setShowFPS(false);

        this.cursor = new Image(this.RESOURCE_PATH + "ui_elements/Cursor.png");

        // array of Image (all sprites for our background)
        Image backAnimation[] = { new Image(this.RESOURCE_PATH + "backgrounds/animBack/0.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/1.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/2.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/3.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/4.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/5.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/6.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/7.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/8.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/9.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/10.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/11.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/12.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/13.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/14.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/15.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/16.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/17.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/18.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/19.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/20.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/21.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/22.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/23.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/24.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/25.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/26.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/27.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/28.png"),
                                  new Image(this.RESOURCE_PATH + "backgrounds/animBack/29.png") };

        int animDuration[] = { 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200,
                               200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200 };

        this.backgroundAnim = new Animation(backAnimation, animDuration, true);

        // prepare our buttons
        this.playButton             = new Image(this.RESOURCE_PATH + "ui_elements/buttons/PlayInactive.png");
        this.playButtonActive       = new Image(this.RESOURCE_PATH + "ui_elements/buttons/PlayActive.png");
        this.creditsButton          = new Image(this.RESOURCE_PATH + "ui_elements/buttons/CreditsInactive.png");
        this.creditsButtonActive    = new Image(this.RESOURCE_PATH + "ui_elements/buttons/CreditsActive.png");
        this.exitButton             = new Image(this.RESOURCE_PATH + "ui_elements/buttons/ExitInactive.png");
        this.exitButtonActive       = new Image(this.RESOURCE_PATH + "ui_elements/buttons/ExitActive.png");

        // set starting buttons
        this.playIsActive   = this.playButton;
        this.creditIsActive = this.creditsButton;
        this.exitIsActive   = this.exitButton;

        // set default font for main menu
        InputStream menuFont = ResourceLoader.getResourceAsStream(this.RESOURCE_PATH + "fonts/MainFont.ttf");

        try {
            Font mainFont = Font.createFont(Font.TRUETYPE_FONT, menuFont);
            mainFont = mainFont.deriveFont(64f);

            this.menuFont = new TrueTypeFont(mainFont, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // set theme music
        this.menuTheme = new Music(this.RESOURCE_PATH + "sounds/MenuTheme.ogg");
        this.menuTheme.setVolume(0.5f);
        this.menuTheme.loop();

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

        // Our animated background
        this.backgroundAnim.draw(0,0, gameContainer.getScreenWidth(), gameContainer.getScreenHeight());

        // draw game name string
        this.menuFont.drawString(xPos - 450, 200, "A L I E N   S H O O T E R", Color.white);

        // buttons (play, credits, exit)
        graphics.drawImage(this.playIsActive, xPos - (this.playButton.getWidth() / 2), yPos - 100);
        graphics.drawImage(this.creditIsActive, xPos - (this.creditsButton.getWidth() / 2), yPos);
        graphics.drawImage(this.exitIsActive, xPos - (this.exitButton.getWidth() / 2), yPos + 100);
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
        // update animation
        this.backgroundAnim.update(delta);

        // getting mouse position
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();

        // get X position first button (play)
        int xStart  = (gameContainer.getScreenWidth() / 2) - (this.playButton.getWidth() /2) - 25;
        int xEnd    = xStart + 146;

        // get Y position first button (play)
        int yStart  = ((gameContainer.getScreenHeight() / 2) + 100) - 25;
        int yEnd    = yStart + 48;

        // if a mouse cursor hovers the play button
        if((xPos > xStart && xPos < xEnd) && (yPos > yStart && yPos < yEnd)) {
            this.playIsActive = this.playButtonActive;

            if(Mouse.isButtonDown(0)) {
                stateBasedGame.enterState(1);
            }
        } else {
            this.playIsActive = this.playButton;
        }

        // if a mouse cursor hovers the credits button
        if((xPos > xStart && xPos < xEnd) && (yPos > yStart - 100 && yPos < yEnd - 100)) {
            this.creditIsActive = this.creditsButtonActive;

            if(Mouse.isButtonDown(0)) {
                stateBasedGame.enterState(2);
            }
        } else {
            this.creditIsActive = this.creditsButton;
        }

        // if a mouse cursor hovers the exit button
        if((xPos > xStart && xPos < xEnd) && (yPos > yStart - 200 && yPos < yEnd - 200)) {
            this.exitIsActive = this.exitButtonActive;

            if(Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        } else {
            this.exitIsActive = this.exitButton;
        }
    }
}
