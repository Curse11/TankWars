package com.game.tank_wars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class PlayerTank extends Rectangle {
	private Sound shotSound;
	private Texture texture;
	public boolean canShot = true;
	
	public PlayerTank(Texture texture){
		this.texture = texture;
		this.height = texture.getHeight();
		this.width = texture.getWidth();
		shotSound = Gdx.audio.newSound(Gdx.files.internal("Gun_Shot.mp3"));
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(texture, x, y);
	}
	
	/* jesli wcisniemy spacje i przerwa 
	 miedzy strzalem jest wieksza niz 0,5sekundy to ma byc strzal
	 do zaimplementowania*/
	
	/*public void shot(){
		if(Gdx.input.isKeyPressed(Keys.SPACE)) && {
			;
			shotSound.play();
		}
	}*/
}
