package com.game.tank_wars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.MathUtils;


public class Main_Screen extends ApplicationAdapter {
	private Music music;
	private Texture playerTexture, wallTexture1; //shotTexture;
	private PlayerTank player;
	private Array<Wall> wallArray;
	private OrthographicCamera camera;
	
	//private Array<Shot> shotArray;
	
	SpriteBatch batch;

	
	@Override
	public void create () {
		loadData();
		initialization();
	}
	
	//initialize music, player and walls randomly.
	private void initialization() {
		batch = new SpriteBatch();
		music.play();
		camera = new OrthographicCamera(1000,1000);
		player = new PlayerTank(playerTexture);
		wallArray = new Array<Wall>();
		
		for(int i = 1; i<200; i++){
			Wall w = new Wall(wallTexture1);
			w.x = MathUtils.randomTriangular(-1000.0f, 1000.0f);
			w.y = MathUtils.randomTriangular(-1000.0f, 1000.0f);
			wallArray.add(w);
		}
	}
	
	
	// insert player and wall images
	private void loadData() {
		playerTexture = new Texture ("Player1.png");
		wallTexture1 = new Texture ("Wall1.png");
		//wallTeture2 = new Texture ("wall2 image wstawic");
		music = Gdx.audio.newMusic(Gdx.files.internal("07-hans zimmer - all of them.mp3"));
	}



	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(10, 150, 38, 100);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		for(Wall w : wallArray){
			w.draw(batch);
		}
		player.draw(batch);
		batch.end();
	}
	
	private void update() {
		handleInput();
		
	}

	private void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.A)){
			player.x -= 250 * Gdx.graphics.getDeltaTime();				
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			player.x += 250 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.W)){
			player.y += 250 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			player.y -= 250 * Gdx.graphics.getDeltaTime();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
