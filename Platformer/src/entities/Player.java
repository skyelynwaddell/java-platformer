package entities;

import static utils.Constants.Directions.DOWN;
import static utils.Constants.Directions.LEFT;
import static utils.Constants.Directions.RIGHT;
import static utils.Constants.Directions.UP;
import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.IDLE;
import static utils.Constants.PlayerConstants.RUNNING; 
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import static utils.Constants.Game.*;

public class Player extends Entity {
	
	private int image_timer, image_index, image_speed = 5;
	private int playerAction = IDLE;
	private int direction = -1;
 	
	private boolean moving   = false;
	private int left,right,up,down;
	
	private int width   = 16;
	private int height  = 16;
	
	private int image_xscale = 1;
	private int image_yscale = 1;
	private int dirx = 0;
	private int diry = 0;
	private int spd  = 1;
	private double grvty = 0.001;
	
	private int state  = IDLE;
	private BufferedImage[][] animations;
	
	public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		UpdateAnimationTick();
		setAnimation();
		updatePos();
	}
	
	public void render(Graphics g) {
		int scaledWidth = SPRITE_SCALE * image_xscale;
	    int scaledHeight = SPRITE_SCALE * image_yscale;
	    g.drawImage(animations[0][image_index], (int)x - scaledWidth/2, (int)y - scaledHeight/2, scaledWidth, scaledHeight, null);
	}
	
	private void loadAnimations() {
		
		InputStream is = getClass().getResourceAsStream("/player.png");
		
		//load player sprite
		try {
			BufferedImage img = ImageIO.read(is);
			animations = new BufferedImage[1][6];
			
			for (int j = 0; j < animations.length; j++) 
				for (int i = 0; i < animations[j].length; i++) 
					animations[j][i] = img.getSubimage(i * SPRITE_SIZE, j * SPRITE_SIZE, width, height);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void PlayerMovement() {
		
		switch(state) {
		case (0): //IDLE
			//AnimateSprite(0,0);
			//System.out.println("idle");
		break;
		
		case (1): //RUN
			//AnimateSprite(0,5);
			//System.out.println("run");
		break;
		}
	}
	
	private void setAnimation() {
		// TODO Auto-generated method stub
		if (moving) {
			playerAction = RUNNING;
		}
		else {
			playerAction = IDLE;
		}
		
	}
	
	
	private void updatePos() {
		int dirx = right - left;
		int diry = down  - up;
		
		x += dirx;
		//y += diry;
	}
	
	private void UpdateAnimationTick() {
		// TODO Auto-generated method stub
		image_timer++;
		
		if(image_timer >= image_speed) {
			image_timer = 0;
			image_index++;
			
			if (image_index >= GetSpriteAmount(playerAction)) {
				image_index = 0;
			}
		}
	}
	
	public void setImageXscale(int dir) {
		this.image_xscale = dir;
	}

	public int isLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int isRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int isUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int isDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}
	
	
}
