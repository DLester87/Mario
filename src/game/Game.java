package game;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
/**
 * @author The New Boston Youtube vidoes slick2d tutorial
 * Game Class to Set up the Game Container and Window.
 * 
 */
public class Game extends StateBasedGame{

	/**
	 * Creates new instances of String for window title,
	 * int for menu state, and int for play state.
	 */
	public static final String gamename = "Drew's Mario Bros";
	public static final int menu = 0;
	public static final int play = 1;
	/**
	 * Game constructor. Adds menu and PlayMario States.
	 * @param gamename
	 */
	public Game(String gamename) {
		super(gamename);//adds title to window
		this.addState(new Menu(menu));
		this.addState(new PlayMario(play));
	}
	/**
	 * initStatesList method to initiate the states.
	 * Decides which state to enter into first.
	 * @param gc
	 */
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}
	/**
	 * Main method to start the game.
	 * Has a game container to hold evertything in window.
	 * @param args
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(640, 360, false);//fullScreen is true.
			appgc.setShowFPS(false);
			appgc.start();
			//Display.setResizable(true);
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}
	
}