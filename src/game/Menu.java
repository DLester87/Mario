package game;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
/**
 * @author The New Boston Youtube vidoes slick2d tutorial
 * @author Drew Lester
 * Menu class that sets up the look up the main menu.
 */
public class Menu extends BasicGameState{
	/**
	 * Creates new instances of Images and floats.
	 */
	Image playNow;
	Image exitGame;
	Image start;
	Image mario;
	float dy = -360;
	float mdy = -85;
	/**
	 * Menu constructor.
	 * @param state
	 */
	public Menu(int state) {
	}
	/**
	 * init method to initiate the menu screen.
	 * @param gc
	 * @param sbg
	 * @throws SlickException
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
		start = new Image("res/start.png");
		mario = new Image("res/BigMarioRight.png");
	}
	/**
	 * render method to draw images on the menu screen.
	 * @param gc
	 * @param sbg
	 * @param g
	 * @throws SlickException
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		//g.drawString("Welcome to Bucky Land!", 100, 50);
		//playNow.draw(100,100);
		//exitGame.draw(100,200);
		start.draw(0,dy);
		mario.draw(270, mdy);
	}
	/**
	 * update method to make changes on menu screen.
	 * @param gc
	 * @param sbg
	 * @param delta
	 * @throws SlickException
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
		if(dy <= 0) {
			dy += .1f;
		}
		if(mdy <= 275) {
			mdy += .1f;
		}
		/**
		 * Listens for input on the keyboard.
		 * Enters PlayMario state if Enter key is pressed.
		 */
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(1);
		}
	}
	/**
	 * getID method to return the state of the menu.
	 */
	public int getID() {
		return 0;
	}

}