package game;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;

/**
 * @author The New Boston Youtube vidoes slick2d tutorial
 * @author Drew Lester
 * PlayMario class that gives the main Play window.
 */
public class PlayMario extends BasicGameState{
	/**
	 * Makes new instances of all the variables needed.
	 */
	private Animation mario, jumpingRight, jumpingLeft, movingLeft, movingRight, marioFaceRight, marioFaceLeft;
	private Animation moveEnemy1, plantMove, e2L, e2R, e3L, e3R;
	private Image worldMap, flag, QBlock1, QBlock2, brick1, brick2, brick3, pipe, coin1, coin2, coin3, coin4, coin5;
	private Image deadQ1, deadQ2, coin6, coin7, coin8, coin9, coin10, coin11, coin12, coin13, coin14, coin15;
	private Image coin16, coin17, coin18, coin19, coin20;
	private int[] duration = {200, 200, 200};
	private int[] duration2 = {200, 200};
	private float marioPosX = 0;
	private float marioPosY = 0;
	private float dx = .03f;
	private float e2dx = .03f;
	private float e3dx = .03f;
	private float enemy1XPos = 718;
	private float enemy1YPos = 285;
	private float enemy2XPos = 3959;
	private float enemy2YPos = 295;
	private float enemy3XPos = 4275;
	private float enemy3YPos = 295;
	private float plant1YPos = 250;
	private float flagX = 4737;
	private float flagY = 70;
	private float shiftX = marioPosX + 280;
	private float shiftY = marioPosY + 280;
	private float verticalSpeed = 0.0f;
	private float pdy = .03f;
	private int lives = 4;
	private boolean quit = false;
	private boolean jumping = false;
	private boolean goingRight = false;
	private boolean goingLeft = false;
	private boolean falling = false;
	private boolean reachedGoal = false;
	private boolean reachedFlag = false;
	private boolean flagDown = false;
	private boolean isEnemy1Alive = true;
	private boolean isE2Alive = true;
	private boolean b1Show = true;
	private boolean b2Show = true;
	private boolean br1Show = true;
	private boolean br2Show = true;
	private boolean br3Show = true;
	private double score = 0;
	private int coins = 0;
	private int timeInt;
	private int showScore;
	private double timer = 100.00;
	private boolean onPlatform = false;
	private boolean c1Show = true;
	private boolean c2Show = true;
	private boolean c3Show = true;
	private boolean c4Show = true;
	private boolean c5Show = true;
	private boolean c6Show = true;
	private boolean c7Show = true;
	private boolean c8Show = true;
	private boolean c9Show = true;
	private boolean c10Show = true;
	private boolean c11Show = true;
	private boolean c12Show = true;
	private boolean c13Show = true;
	private boolean c14Show = true;
	private boolean c15Show = true;
	private boolean c16Show = true;
	private boolean c17Show = true;
	private boolean c18Show = true;
	private boolean c19Show = true;
	private boolean c20Show = true;
	private String screenScore;
	private Rectangle mRect, eRect, p1Rect, c1Rect, c2Rect, c3Rect, c4Rect, c5Rect;
	private Rectangle c6Rect, c7Rect, c8Rect, c9Rect, c10Rect, c11Rect, c12Rect, c13Rect, c14Rect, c15Rect;
	private Rectangle c16Rect, c17Rect, c18Rect, c19Rect, c20Rect, e2Rect;
	private Music music;
	private Sound coinSound;
	private Sound brickBreak;
	private Sound jumpSound;
	private Sound finished;
	private Sound flagPole;
	private Sound gameOver;
	private Sound dying;
	private Sound bump;
	private Sound stomp;
	private Sound oneUp;
	
	/**
	 * PlayMarion Constructor
	 * @param state
	 */
	public PlayMario(int state) {
	}
	
	/**
	 * init method to initalize all the variables.
	 * @param gc
	 * @param sbg
	 * @throws SlickException
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		initRect();
		initNoise();
		music.loop();
		initImages();

		Image[] jumpRight = {new Image("res/BigMarioRightJump.png"), new Image("res/BigMarioRightJump.png"), new Image("res/BigMarioRightJump.png")};
		Image[] jumpLeft = {new Image("res/BigMarioLeftJump.png"), new Image("res/BigMarioLeftJump.png"),new Image("res/BigMarioLeftJump.png")};
		Image[] walkLeft = {new Image("res/BigMarioLeftWalk1.png"), new Image("res/BigMarioLeftWalk2.png"), new Image("res/BigMarioLeftWalk3.png")};
		Image[] walkRight = {new Image("res/BigMarioRightWalk1.png"), new Image("res/BigMarioRightWalk2.png"),  new Image("res/BigMarioRightWalk3.png")};
		Image[] faceRight = {new Image("res/BigMarioRight.png"), new Image("res/BigMarioRight.png"),  new Image("res/BigMarioRight.png")};
		Image[] faceLeft = {new Image("res/BigMarioLeft.png"), new Image("res/BigMarioLeft.png"),  new Image("res/BigMarioLeft.png")};
		Image[] enemy1Move = {new Image("res/enemy2Pic1.png"), new Image("res/enemy2Pic2.png")};
		Image[] movePlant = {new Image("res/plant1.png"), new Image("res/plant2.png")};
		Image[] e2Left = {new Image("res/e2L1.png"), new Image("res/e2L2.png")};
		Image[] e2Right = {new Image("res/e2R1.png"), new Image("res/e2R2.png")};
		Image[] e3Left = {new Image("res/e2L1.png"), new Image("res/e2L2.png")};
		Image[] e3Right = {new Image("res/e2R1.png"), new Image("res/e2R2.png")};
		
		jumpingRight = new Animation(jumpRight, duration, false);
		jumpingLeft = new Animation(jumpLeft, duration, false);
		movingLeft = new Animation(walkLeft, duration, true);
		movingRight = new Animation(walkRight, duration, true);
		marioFaceLeft = new Animation(faceLeft, duration, false);
		marioFaceRight = new Animation(faceRight, duration, false);
		moveEnemy1 = new Animation(enemy1Move, duration2, true);
		plantMove = new Animation(movePlant, duration2, true);
		e2L = new Animation(e2Left, duration2, true);
		e2R = new Animation(e2Right, duration2, true);
		e3L = new Animation(e3Left, duration2, true);
		e3R = new Animation(e3Right, duration2, true);
		mario = marioFaceRight;
	}
	/**
	 * initRect method to initialize the Rectangles
	 */
	public void initRect() {
		mRect = new Rectangle(280,280,19,36);
		p1Rect = new Rectangle(926, plant1YPos +2, 19, 26);
		eRect = new Rectangle(enemy2XPos, enemy2YPos, 20,20);
		e2Rect = new Rectangle(enemy3XPos, enemy3YPos, 20, 20);
		c1Rect = new Rectangle(474, 110, 15, 20);
		c2Rect = new Rectangle(500, 110, 15, 20);
		c3Rect = new Rectangle(526, 110, 15, 20);
		c4Rect = new Rectangle(552, 110, 15, 20);
		c5Rect = new Rectangle(578, 110, 15, 20);
		c6Rect = new Rectangle(3500, 170, 15, 20);
		c7Rect = new Rectangle(3526, 170, 15, 20);
		c8Rect = new Rectangle(3552, 170, 15, 20);
		c9Rect = new Rectangle(3578, 170, 15, 20);
		c10Rect = new Rectangle(3600, 170, 15, 20);
		c11Rect = new Rectangle(3200, 170, 15, 20);
		c12Rect = new Rectangle(3226, 170, 15, 20);
		c13Rect = new Rectangle(3252, 170, 15, 20);
		c14Rect = new Rectangle(3278, 170, 15, 20);
		c15Rect = new Rectangle(3300, 170, 15, 20);
		c16Rect = new Rectangle(2300, 170, 15, 20);
		c17Rect = new Rectangle(2326, 170, 15, 20);
		c18Rect = new Rectangle(2352, 170, 15, 20);
		c19Rect = new Rectangle(2378, 170, 15, 20);
		c20Rect = new Rectangle(2400, 170, 15, 20);
	}
	/**
	 * initNoise method to initialize sounds and music
	 * @throws SlickException
	 */
	public void initNoise() throws SlickException{
		music = new Music("res/Ground.wav");
		coinSound = new Sound("res/smb_coin.wav");
		brickBreak = new Sound("res/smb_breakblock.wav");
		jumpSound = new Sound("res/smb_jump-super.wav");
		finished = new Sound("res/smb_stage_clear.wav");
		flagPole = new Sound("res/smb_flagpole.wav");
		gameOver = new Sound("res/smb_gameover.wav");
		dying = new Sound("res/smb_mariodie.wav");
		bump = new Sound("res/smb_bump.wav");
		stomp = new Sound("res/smb_stomp.wav");
		oneUp = new Sound("res/smb_1-up.wav");
	}
	/**
	 * initImages method to initialize images.
	 * @throws SlickException
	 */
	public void initImages() throws SlickException {
		worldMap = new Image("res/MarioLevel1-1.png");
		flag = new Image("res/flag.png");
		QBlock1 = new Image("res/QBlock.png");
		QBlock2 = new Image("res/QBlock.png");
		brick1 = new Image("res/brick.png");
		brick2 = new Image("res/brick.png");
		brick3 = new Image("res/brick.png");
		pipe = new Image("res/pipe2.png");
		coin1 = new Image("res/coin.png");
		coin2 = new Image("res/coin.png");
		coin3 = new Image("res/coin.png");
		coin4 = new Image("res/coin.png");
		coin5 = new Image("res/coin.png");
		coin6 = new Image("res/coin.png");
		coin7 = new Image("res/coin.png");
		coin8 = new Image("res/coin.png");
		coin9 = new Image("res/coin.png");
		coin10 = new Image("res/coin.png");
		coin11 = new Image("res/coin.png");
		coin12 = new Image("res/coin.png");
		coin13 = new Image("res/coin.png");
		coin14 = new Image("res/coin.png");
		coin15 = new Image("res/coin.png");
		coin16 = new Image("res/coin.png");
		coin17 = new Image("res/coin.png");
		coin18 = new Image("res/coin.png");
		coin19 = new Image("res/coin.png");
		coin20 = new Image("res/coin.png");
		deadQ1 = new Image("res/deadQ.png");
		deadQ2 = new Image("res/deadQ.png");
	}
	/**
	 * render method to draw the views on the screen.
	 * @param gc
	 * @param sbg
	 * @param g
	 * @throws SlickException
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		/*
		 * View you see if you lose a life.
		 */
		if(dying.playing()) {
			g.drawString("Lives: " + lives, 280, 160);
			music.pause();
		}
		/*
		 * Main view while the game is playing.
		 */
		else if(lives > 0 && !reachedGoal && !quit && !dying.playing()) {
			renderImages();
			dying.stop();
			if(!music.playing()) {
				music.resume();
			}
			g.setColor(Color.black);
			g.drawString("Lives: " + lives, 20, 30);
			g.drawString(" Score: " + screenScore, 150, 30);
			g.drawString(" Coins: " + coins, 350, 30);
			g.drawString("Time: " + timeInt, 500, 30);
			g.setColor(Color.white);
		}
		/*
		 * View you see if you hit esc key.
		 */
		else if(quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if(quit == false) {
				g.clear();
			}
		}
		/*
		 * View you see if you reach the end of the level.
		 */
		else if(reachedGoal) {
			g.drawString("You Beat The Level!!!" + "\nScore: " + screenScore +
					"\nCoins: " + coins + "\nLives: " + lives, 280, 160);
			finished.stop();
			music.pause();
					
		}
		/*
		 * View you see if you lose all lives.
		 */
		else {
			g.drawString("GAME OVER!!! \nScore: " + screenScore +
					"\nCoins: " + coins, 270, 160);
			music.stop();
		}
		if(timeInt == 0){
			g.drawString("GAME OVER!!! \nScore: " + screenScore +
					"\nCoins: " + coins, 270, 160);
			music.stop();
		}
	}
	
	/**
	 * update method to make changes to the game.
	 * @param gc
	 * @param sbg
	 * @param delta
	 * @throws SlickException
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		/*
		 * Stores and keyboard or mouse inputs.
		 */
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(0);
		}
		mRect.setBounds(-marioPosX+280, shiftY, 19,36);
		p1Rect.setBounds(926, plant1YPos + 2, 18, 26);
		c1Rect.setBounds(474, 110, 15,20);
		c2Rect.setBounds(500, 110, 15, 20);
		c3Rect.setBounds(526, 110, 15, 20);
		c4Rect.setBounds(552, 110, 15, 20);
		c5Rect.setBounds(578, 110, 15, 20);
		eRect.setBounds(enemy2XPos, enemy2YPos, 20, 20);
		e2Rect.setBounds(enemy3XPos, enemy3YPos, 20, 20);
		/*
		 * Calls the getTime() method to get time on the screen.
		 */
		getTime();
		/*
		 * checks to see if the flag is reached.
		 * If not, gets input of keyboard and moves screen.
		 */
		if(!reachedFlag) {
			/*
			 * Gets the left key input to move screen.
			 * Checks the pipes in the level.
			 */
			if(input.isKeyDown(Input.KEY_LEFT)) {
				mario = movingLeft;
				marioPosX += delta * .1f;
				if(marioPosX > 0) {
					marioPosX -= delta * .1f;
				}
				goingLeft = true;
				goingRight = false;
				if(jumping) {
					mario = jumpingLeft;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 655 && mRect.getX() < 718)) {
					marioPosX -= delta * .1f;
				}
				if((mRect.getY() >= 210 && mRect.getY() <= 280) && (mRect.getX() > 895 && mRect.getX() < 956)) {
					marioPosX -= delta * .1f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1087 && mRect.getX() < 1148)) {
					marioPosX -= delta * .1f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1351 && mRect.getX() < 1412)) {
					marioPosX -= delta * .1f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 3894 && mRect.getX() < 3958)) {
					marioPosX -= delta * .1f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 4277 && mRect.getX() < 4341)) {
					marioPosX -= delta * .1f;
				}
			}
		    /*
		     * Gets the right key input on keyboard
		     * Checks the pipes in the level
		     */
			if(input.isKeyDown(Input.KEY_RIGHT)) {
				if(mRect.getX() <= 4752) {
					mario = movingRight;
					marioPosX -= delta * .1f;
				}
				else if(mRect.getX() > 4752) {
					shiftX += delta * .1f;
				}
				
				goingRight = true;
				goingLeft = false;
				if(jumping) {
					mario = jumpingRight;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 655 && mRect.getX() < 718)) {
					marioPosX += delta * .1f;
				}
				if((mRect.getY() >= 210 && mRect.getY() <= 280) && (mRect.getX() > 895 && mRect.getX() <956)) {
					marioPosX += delta * .1f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1087 && mRect.getX() < 1148)) {
					marioPosX += delta * .1f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1351 && mRect.getX() < 1412)) {
					marioPosX += delta * .1f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 3894 && mRect.getX() < 3958)) {
					marioPosX += delta * .1f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 4277 && mRect.getX() < 4341)) {
					marioPosX += delta * .1f;
				}
			}
			/*
			 * Gets the d and right key of keyboard
			 * Checks pipes in the level.
			 */
			if(input.isKeyDown(input.KEY_D) && input.isKeyDown(input.KEY_RIGHT)) {
				mario = movingRight;
				marioPosX -= delta * .1001f;
			
				goingRight = true;
				goingLeft = false;
				if(jumping) {
					mario = jumpingRight;
				}
				if((mRect.getY() >=232 && mRect.getY() <=280) && (mRect.getX() > 655 && mRect.getX() < 718)) {
					marioPosX += delta * .1001f;
				}
				if((mRect.getY() >= 210 && mRect.getY() <= 280) && (mRect.getX() > 895 && mRect.getX() <956)) {
					marioPosX += delta * .1001f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1087 && mRect.getX() < 1148)) {
					marioPosX += delta * .1001f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1351 && mRect.getX() < 1412)) {
					marioPosX += delta * .1001f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 3894 && mRect.getX() < 3958)) {
					marioPosX += delta * .1001f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 4277 && mRect.getX() < 4341)) {
					marioPosX += delta * .1001f;
				}
			}
			/*
			 * Gets the d and Left key inputs on keyboard
			 * Checks the pipes in the level
			 */
			if(input.isKeyDown(input.KEY_D) && input.isKeyDown(input.KEY_LEFT)) {
				mario = movingLeft;
				marioPosX += delta * .1001f;
				if(marioPosX > 0) {
					marioPosX -= delta * .1001f;
				}
				
				goingLeft = true;
				goingRight = false;
				if(jumping) {
					mario = jumpingLeft;
				}
				if((mRect.getY() >=232 && mRect.getY() <=280) && (mRect.getX() > 655 && mRect.getX() < 718)) {
					marioPosX -= delta * .1001f;
				}
				if((mRect.getY() >= 210 && mRect.getY() <= 280) && (mRect.getX() > 895 && mRect.getX() <956)) {
					marioPosX -= delta * .1001f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1087 && mRect.getX() < 1148)) {
					marioPosX -= delta * .1001f;
				}
				if((mRect.getY() >= 186 && mRect.getY() <= 280) && (mRect.getX() > 1351 && mRect.getX() < 1412)) {
					marioPosX -= delta * .1001f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 3894 && mRect.getX() < 3958)) {
					marioPosX -= delta * .1001f;
				}
				if((mRect.getY() >= 232 && mRect.getY() <=280) && (mRect.getX() > 4277 && mRect.getX() < 4341)) {
					marioPosX -= delta * .1001f;
				}
			}
			/*
			 * Gets the space key input on the keyboard.
			 */
			if(input.isKeyPressed(Input.KEY_SPACE) && !jumping) {
			
				jumpSound.play();
				verticalSpeed = delta * -.8f;
				jumping = true;
				if(mario.equals(movingRight)) {
					mario = jumpingRight;
				}
				else if(mario.equals(movingLeft)) {
					mario = jumpingLeft;
				}
			}
		}
		moveEnemy();
		movePlant();
		/*
		 * checks the pipes in the level.
		 */
		if((mRect.getX() > 656 && mRect.getX() < 717)) {
			onPlatform = true;
			if(mRect.getY() < 231) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 231) {
				verticalSpeed = 0;
				shiftY = 231;
				jumping = false;
			}
		}
		else if((mRect.getX() > 896 && mRect.getX() < 955)) {
			onPlatform = true;
			if(mRect.getY() < 209) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 209) {
				verticalSpeed = 0;
				shiftY = 209;
				jumping = false;
			}
		}
		else if((mRect.getX() > 1088 && mRect.getX() < 1147)) {
			onPlatform = true;
			if(mRect.getY() < 185) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 185) {
				verticalSpeed = 0;
				shiftY = 185;
				jumping = false;
			}
		}
		else if((mRect.getX() > 1352 && mRect.getX() < 1411)) {
			onPlatform = true;
			if(mRect.getY() < 185) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 185) {
				verticalSpeed = 0;
				shiftY = 185;
				jumping = false;
			}
		}
		else if((mRect.getX() > 3895 && mRect.getX() < 3957)) {
			onPlatform = true;
			if(mRect.getY() < 231) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 231) {
				verticalSpeed = 0;
				shiftY = 231;
				jumping = false;
			}
		}
		else if((mRect.getX() > 4278 && mRect.getX() < 4340)) {
			onPlatform = true;
			if(mRect.getY() < 231) {
				verticalSpeed += delta * .001f;
			}
			if(mRect.getY() > 231) {
				verticalSpeed = 0;
				shiftY = 231;
				jumping = false;
			}
		}
		
		else {
			falling = false;
		}
		
		checkPlatform();
		/*
		 * Checks if mario is under or on top of the first platform.
		 */
		if((jumping) &&((mRect.getX() >=464 && mRect.getX() <= 495 && br1Show) ||
				(mRect.getX() > 495 && mRect.getX() <= 520) ||
				(mRect.getX() > 520 && mRect.getX() <= 540 && br2Show) ||
				(mRect.getX() > 540 && mRect.getX() <= 560) ||
				(mRect.getX() > 560 && mRect.getX() <= 594 && br3Show))){
			
				if(shiftY <= 184) {
					verticalSpeed += delta * .001f;
				}
				else if(shiftY <= 280 && shiftY > 242) {
					verticalSpeed += delta * .00563f;
					checkBlocks();
				}
				else if(shiftY > 184 && shiftY < 186) {
					jumping = false;
					verticalSpeed = 0;
					shiftY = 184;
				}
				else if(shiftY > 200) {
					jumping = false;
					verticalSpeed = 0;
					shiftY = 280;
				}
		}
		
		if(!jumping && !onPlatform) {
			falling = true;
		}
		else{
			onPlatform = false;
		}
		/*
		 * Checks to see if mario falls down a hole.
		 */
		if((!jumping) && ((mRect.getX() > 1652 && mRect.getX() < 1695))){
				verticalSpeed += .1f;
			
				if(mRect.getY() > 360) {
					lives--;
					if(lives > 0) {
						music.pause();
						dying.play();
					}
					marioPosX = -1144;
					marioPosY = 0;
					shiftX = 280;
					shiftY = 280;
					verticalSpeed = 0;
					score -= 50;
				}
		}
		else if(!jumping && (mRect.getX() > 2060 && mRect.getX() < 2122)) {
				verticalSpeed += .1f;
			
			if(mRect.getY() > 360) {
				lives--;
				if(lives > 0) {
					music.pause();
					dying.play();
				}
				marioPosX = -1424;
				marioPosY = 0;
				shiftX = 280;
				shiftY = 280;
				verticalSpeed = 0;
				score -= 50;
			}
		}
		else if(!jumping &&  (mRect.getX() > 3670 && mRect.getX() < 3704)) {
			verticalSpeed += .1f;
			
			if(mRect.getY() > 360) {
				lives--;
				if(lives > 0) {
					music.pause();
					dying.play();
				}
				marioPosX = -3012;
				marioPosY = 0;
				shiftX = 280;
				shiftY = 280;
				verticalSpeed = 0;
				score -= 50;
			}
		}
		else if(shiftY > 280) {
				verticalSpeed = 0;
				shiftY = 280;
				jumping = false;
				falling = false;
				onPlatform = true;
		}
		else if((jumping || falling) && !onPlatform) {
			if(shiftY < 280) {
			verticalSpeed += delta * .003f;
			}
		}
				
		shiftY += verticalSpeed;
		getJumpingImg();
		/*
		 * checks to see if mario reaches the flag.
		 */
		if(mRect.getX() > 4752) {
			reachedFlag = true;
			
			if(timer >= 0) {
				timer -= .05f;
				score += 5;
			}
			if(flagY <= 268) {
				music.stop();
				flagPole.play();
				flagY += delta * .1f;
			}
			if(flagY >= 267) {
				flagDown = true;
				flagPole.stop();
				finished.play();
			}
			if(flagDown && mRect.getY() == 280) {
				if(shiftX < 427) {
					shiftX += delta * .1f;
				}
			}
		}
		if(lives == 0) {
			gameOver.play();
		}
		if(!jumping &&goingRight && !input.isKeyDown(input.KEY_RIGHT)) {
			mario = marioFaceRight;
		}
		if(!jumping && goingLeft && !input.isKeyDown(input.KEY_LEFT)) {
			mario = marioFaceLeft;
		}
		showScore = (int) score;
		screenScore = String.format("%06d", showScore);
		
		if(coins == 100) {
			oneUp.play();
			lives++;
			coins = 0;
		}
		
		//escape key
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		//when menu is up
		if(quit == true) {
			if(input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
	}
	 /**
	  * moveEnemy method to move the enemies on the screen.
	  */
	public void moveEnemy() {
		if(isEnemy1Alive) {
			enemy1XPos += dx;
				if(enemy1XPos >= 888 || enemy1XPos <= 718) {
					dx = -dx;
				}
				if(((-(marioPosX - 296) >= (getEnemy1XPos())) &&
						(-(marioPosX - 280) <= (getEnemy1XPos() + 28))) &&
						(shiftY < 280 && shiftY >= 274)) {
						stomp.play();
						score += 100;
						isEnemy1Alive = false;
				}		
		}
		if(isEnemy1Alive && ((-(marioPosX - 296) >= (getEnemy1XPos())) &&
				(-(marioPosX - 280) <= (getEnemy1XPos() + 28))) &&
				(shiftY == 280)) {
				lives--;
				if(lives > 0) {
					music.pause();
					dying.play();
				}
				marioPosX = 0;
				score -= 50;
		}
		if(isE2Alive) {
			enemy2XPos += e2dx;
			if(enemy2XPos >= 4112 || enemy2XPos <= 3958) {
				e2dx = -e2dx;
			}
		
			if(mRect.intersects(eRect)) {
				lives--;
				if(lives > 0) {
					music.pause();
					dying.play();
				}
				marioPosX = -3500;
				score -= 50;
			}
		}
		if(isE2Alive) {
			enemy3XPos += e3dx;
			if(enemy3XPos >= 4277 || enemy3XPos <= 4127) {
				e3dx = -e3dx;
			}
			
			if(mRect.intersects(e2Rect)) {
				lives--;
				if(lives > 0) {
					music.pause();
					dying.play();
				}
				marioPosX = -3500;
				score -=50;
			}
		}
	}
	/**
	 * movePlant method to move the plant in pipe
	 */
	public void movePlant() {
		plant1YPos += pdy;
		if(plant1YPos > 270 || plant1YPos < 214) {
			pdy = -pdy;
		}

		if(mRect.intersects(p1Rect)) {
			lives--;
			if(lives > 0) {
				music.pause();
				dying.play();
			}
			marioPosX = 0;
			marioPosY = 0;
			shiftX = 280;
			shiftY = 280;
			score -= 50;
		}
	}
	/**
	 * renderImages method to draw images on screen.
	 */
	public void renderImages() {
		worldMap.draw(marioPosX, marioPosY);
		flag.draw(marioPosX + flagX, flagY);
		mario.draw(shiftX, shiftY);
		if(br1Show) {
			brick1.draw(marioPosX + 476, 214);
		}
		if(b1Show) {
			QBlock1.draw(marioPosX + 504, 216);
		}
		else if(!b1Show) {
			deadQ1.draw(marioPosX + 504, 216);
		}
		if(br2Show) {
			brick2.draw(marioPosX + 523, 214);
		}
		if(b2Show) {
			QBlock2.draw(marioPosX + 551, 216);
		}
		else if(!b2Show) {
			deadQ2.draw(marioPosX + 551, 216);
		}
		if(br3Show) {
			brick3.draw(marioPosX + 570, 214);
		}
		
		if(isEnemy1Alive) {
			moveEnemy1.draw(marioPosX + enemy1XPos + dx, marioPosY + enemy1YPos);
		}
		if(isE2Alive && e2dx == .03f) {
			e2R.draw(marioPosX + enemy2XPos + e2dx, marioPosY + enemy2YPos);
		}
		else if(isE2Alive && e2dx == -.03f) {
			e2L.draw(marioPosX + enemy2XPos + e2dx, marioPosY + enemy2YPos);
		}
		if(isE2Alive && e3dx == .03f) {
			e3R.draw(marioPosX + enemy3XPos + e3dx, marioPosY + enemy3YPos);
		}
		else if(isE2Alive && e3dx == -.03f) {
			e3L.draw(marioPosX + enemy3XPos + e3dx, marioPosY + enemy3YPos);
		}
		
		plantMove.draw(marioPosX + 924, marioPosY + plant1YPos);
		pipe.draw(marioPosX + 907, marioPosY + 235);
		
		if(c1Show) {
			coin1.draw(marioPosX + 474, marioPosY + 110);
			if(mRect.intersects(c1Rect)) {
				coinSound.play();
				coins += 5;
				c1Show = false;
			}
		}
		if(c2Show) {
			coin2.draw(marioPosX + 500, marioPosY + 110);
			if(mRect.intersects(c2Rect)) {
				coinSound.play();
				coins += 5;
				c2Show = false;
			}
		}
		if(c3Show) {
			coin3.draw(marioPosX + 526, marioPosY + 110);
			if(mRect.intersects(c3Rect)) {
				coinSound.play();
				coins += 5;
				c3Show = false;
			}
		}
		if(c4Show) {
			coin4.draw(marioPosX + 552, marioPosY + 110);
			if(mRect.intersects(c4Rect)) {
				coinSound.play();
				coins += 5;
				c4Show = false;
			}
		}
		if(c5Show) {
			coin5.draw(marioPosX + 578, marioPosY + 110);
			if(mRect.intersects(c5Rect)) {
				coinSound.play();
				coins += 5;
				c5Show = false;
			}
		}
		if(c6Show) {
			coin6.draw(marioPosX + 3500, marioPosY + 170);
			if(mRect.intersects(c6Rect)) {
				coinSound.play();
				coins += 5;
				c6Show = false;
			}
		}
		if(c7Show) {
			coin7.draw(marioPosX + 3526, marioPosY + 170);
			if(mRect.intersects(c7Rect)) {
				coinSound.play();
				coins += 5;
				c7Show = false;
			}
		}
		if(c8Show) {
			coin8.draw(marioPosX + 3552, marioPosY + 170);
			if(mRect.intersects(c8Rect)) {
				coinSound.play();
				coins += 5;
				c8Show = false;
			}
		}
		if(c9Show) {
			coin9.draw(marioPosX + 3578, marioPosY + 170);
			if(mRect.intersects(c9Rect)) {
				coinSound.play();
				coins += 5;
				c9Show = false;
			}
		}
		if(c10Show) {
			coin10.draw(marioPosX + 3600, marioPosY + 170);
			if(mRect.intersects(c10Rect)) {
				coinSound.play();
				coins += 5;
				c10Show = false;
			}
		}
		if(c11Show) {
			coin11.draw(marioPosX + 3200, marioPosY + 170);
			if(mRect.intersects(c11Rect)) {
				coinSound.play();
				coins += 5;
				c11Show = false;
			}
		}
		if(c12Show) {
			coin12.draw(marioPosX + 3226, marioPosY + 170);
			if(mRect.intersects(c12Rect)) {
				coinSound.play();
				coins += 5;
				c12Show = false;
			}
		}
		if(c13Show) {
			coin13.draw(marioPosX + 3252, marioPosY + 170);
			if(mRect.intersects(c13Rect)) {
				coinSound.play();
				coins += 5;
				c13Show = false;
			}
		}
		if(c14Show) {
			coin14.draw(marioPosX + 3278, marioPosY + 170);
			if(mRect.intersects(c14Rect)) {
				coinSound.play();
				coins += 5;
				c14Show = false;
			}
		}
		if(c15Show) {
			coin15.draw(marioPosX + 3300, marioPosY + 170);
			if(mRect.intersects(c15Rect)) {
				coinSound.play();
				coins += 5;
				c15Show = false;
			}
		}
		if(c16Show) {
			coin16.draw(marioPosX + 2300, marioPosY + 170);
			if(mRect.intersects(c16Rect)) {
				coinSound.play();
				coins += 5;
				c16Show = false;
			}
		}
		if(c17Show) {
			coin17.draw(marioPosX + 2326, marioPosY + 170);
			if(mRect.intersects(c17Rect)) {
				coinSound.play();
				coins += 5;
				c17Show = false;
			}
		}
		if(c18Show) {
			coin18.draw(marioPosX + 2352, marioPosY + 170);
			if(mRect.intersects(c18Rect)) {
				coinSound.play();
				coins += 5;
				c18Show = false;
			}
		}
		if(c19Show) {
			coin19.draw(marioPosX + 2378, marioPosY + 170);
			if(mRect.intersects(c19Rect)) {
				coinSound.play();
				coins += 5;
				c19Show = false;
			}
		}
		if(c20Show) {
			coin20.draw(marioPosX + 2400, marioPosY + 170);
			if(mRect.intersects(c20Rect)) {
				coinSound.play();
				coins += 5;
				c20Show = false;
			}
		}
	}
	/**
	 * checkBlocks method for the first platform.
	 * If mario is below blocks and jumps, they change.
	 */
	public void checkBlocks() {
		if(mRect.getX() >= 464 && mRect.getX() <= 495 && mRect.getY() <= 244) {
			brickBreak.play();
			br1Show = false;
			score += 100;
		}
		if(mRect.getX() > 495 && mRect.getX() <= 520 && mRect.getY() <= 244 && b1Show) {
			bump.play();
			coinSound.play();
			
			b1Show = false;
			coins += 5;
			score += 100;
		}
		else if(mRect.getX() > 495 && mRect.getX() <= 520 && mRect.getY() <= 244 && !b1Show) {
			bump.play();
		}
		if(mRect.getX() > 520 && mRect.getX() <= 540 && mRect.getY() <= 244) {
			brickBreak.play();
			br2Show = false;
			score += 100;
		}
		if(mRect.getX() > 540 && mRect.getX() <= 560 && mRect.getY() <= 244 && b2Show) {
			bump.play();
			coinSound.play();
			b2Show = false;
			coins += 5;
			score += 100;
		}
		else if(mRect.getX() > 540 && mRect.getX() <= 560 && mRect.getY() <= 244 && !b2Show) {
			bump.play();
		}
		if(mRect.getX() > 560 && mRect.getX() <= 594 && mRect.getY() <= 244) {
			brickBreak.play();
			br3Show = false;
			score += 100;
		}
	}
	/**
	 * checkPlatform method to see if mario is standing on platform
	 */
	public void checkPlatform(){
		if(mRect.getX() >=460 && mRect.getX() <= 495 && br1Show){
			onPlatform = true;
		}
		if (mRect.getX() > 495 && mRect.getX() <= 520) {
			onPlatform = true;
		}
		if (mRect.getX() > 520 && mRect.getX() <= 540 && br2Show){
			onPlatform = true;
		}
		if (mRect.getX() > 540 && mRect.getX() <= 560){
			onPlatform = true;
		}
		if (mRect.getX() > 560 && mRect.getX() <= 597 && br3Show) {
			onPlatform = true;
		}
	}
	/**
	 * getJumpingImg method to get which animation is shown when
	 * mario jumps going left and going right.
	 */
	public void getJumpingImg() {
		if(jumping) {
			if(goingRight && shiftY < 280) {
				mario = jumpingRight;
			}
			if(goingLeft && shiftY < 280) {
				mario = jumpingLeft;
			}
		}
	}
	/**
	 * getTime method checks to see if mario has reached the goal.
	 * If not, runs the timer down on the screen.
	 */
	public void getTime() {
		if(shiftX > 424 && shiftX < 428 && timeInt == 0) {
			reachedGoal = true;
		}
		if(timer >= 0.00) {
			timer -= .003f;
		}
		timeInt = (int) timer;
	}
	/**
	 * getId method to return the state of the PlayMario
	 */
	public int getID() {
		return 1;
	}
	/**
	 * getEneemy1XPos method to see where the first enemy is.
	 * @return enemy1XPos + dx
	 */
	public float getEnemy1XPos() {
		return (enemy1XPos + dx);
	}

}