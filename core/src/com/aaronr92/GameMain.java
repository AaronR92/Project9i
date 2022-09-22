package com.aaronr92;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class GameMain extends Game {

	private GameScreen gameScreen;
	
	@Override
	public void create () {
		gameScreen = new GameScreen();

		setScreen(gameScreen);
	}

	@Override
	public void render () {
		float delta = Gdx.graphics.getDeltaTime();
		gameScreen.render(delta);
	}
	
	@Override
	public void dispose () {
	}


}
