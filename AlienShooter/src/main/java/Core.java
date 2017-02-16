import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Core extends BasicGame
{

    public Core(String title)
    {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException
    {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
    {

    }

    public static void main(String[] args)
    {
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new Core("Simple Game"));
            appgc.setDisplayMode(640, 480, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
