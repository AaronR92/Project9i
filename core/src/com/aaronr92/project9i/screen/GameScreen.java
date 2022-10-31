package com.aaronr92.project9i.screen;

import com.aaronr92.project9i.GameMain;
import com.aaronr92.project9i.object.Player;
import com.aaronr92.project9i.util.AssetManager;
import com.aaronr92.project9i.util.MovementController;
import com.aaronr92.project9i.util.SpriteSize;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    //screen
    private OrthographicCamera camera;
    private GameMain game;

    //graphics
    private AssetManager assetManager;

    //player
    private Player player;

    // Values
    private final int WIDTH = 512;
    private final int HEIGHT = 288;

    public GameScreen(GameMain game) {

        // Setting up main
        this.game = game;

        // Camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);

        // AssetManager
        assetManager = new AssetManager("tileset/frozen_level_tileset.png", SpriteSize.SPRITE_16x16);

        assetManager.addSprite("floor_1", 0, 0);
        assetManager.addSprite("floor_2", 0, 1);
        assetManager.addSprite("floor_3", 0, 2);
        assetManager.addSprite("wall_1", 4, 3);
        assetManager.addSprite("wall_2", 4, 4);
        assetManager.addSprite("top_wall_1", 3, 0);
        assetManager.addSprite("top_wall_2", 3, 1);
        assetManager.addSprite("player", 0, 6);

        player = new Player(assetManager.getSprite("player"), SpriteSize.SPRITE_16x16,
                WIDTH / 2, HEIGHT / 2);
        player.setMovementController(new MovementController(this.player.getSprite(), camera));
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.update();

        // Handling input
        player.handleMovement();

        // Rendering
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(assetManager.getSprite("floor_1"), 0, 0);
        game.batch.draw(assetManager.getSprite("floor_2"), 16, 0);
        game.batch.draw(assetManager.getSprite("floor_1"), 16, 16);
        game.batch.draw(assetManager.getSprite("floor_2"), 0, 16);
        game.batch.draw(assetManager.getSprite("floor_1"), 32, 16);
        game.batch.draw(assetManager.getSprite("wall_1"), 0, 32);
        game.batch.draw(assetManager.getSprite("wall_2"), 16, 32);
        game.batch.draw(assetManager.getSprite("wall_1"), 32, 32);
        game.batch.draw(assetManager.getSprite("top_wall_1"), 0, 48);
        game.batch.draw(assetManager.getSprite("top_wall_2"), 16, 48);
        game.batch.draw(assetManager.getSprite("top_wall_1"), 32, 48);
//        assetManager.getSprite("top_wall_1").draw(batch);
        player.getSprite().draw(game.batch);
        game.batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }
}
