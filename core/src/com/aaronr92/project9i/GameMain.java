package com.aaronr92.project9i;

import com.aaronr92.project9i.screen.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMain extends Game {
	public SpriteBatch batch;

	float delta;
	
	@Override
	public void create () {
		screen = new MainMenuScreen(this);
		batch = new SpriteBatch();

		setScreen(screen);
	}

	@Override
	public void render () {
		delta = Gdx.graphics.getDeltaTime();
		screen.render(delta);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
