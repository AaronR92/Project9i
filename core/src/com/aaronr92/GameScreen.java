package com.aaronr92;

import com.aaronr92.util.AssetManager;
import com.aaronr92.util.SpriteSize;
import com.aaronr92.util.controller.MovementController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private Logger log;

    //screen
    private OrthographicCamera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch batch;
    private Stage stage;
    private AssetManager assetManager;

    //player
    private Sprite player;  // TEMPORARY
    private MovementController movementController;

    public GameScreen() {
        // Logger
        log = new Logger("GameScreen", Logger.DEBUG);

        // Camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 256, 144);

        // Sprite renderer setup
        batch = new SpriteBatch();

        // AssetManager
        assetManager = new AssetManager("tileset/frozen_level_tileset.png", SpriteSize.SPRITE_16x16);

        assetManager.addSprite("floor_1", 0, 0);
        assetManager.addSprite("floor_2", 0, 1);
        assetManager.addSprite("floor_3", 0, 2);
        assetManager.addSprite("wall_1", 4, 3);
        assetManager.addSprite("wall_2", 4, 4);
        assetManager.addSprite("top_wall_1", 3, 0);
        assetManager.addSprite("top_wall_2", 3, 1);

        // Player init
        /* TODO
        *   MOVE CODE BELOW INTO YAML FILE OR ETC
        *   AND ALSO MOVE ALL CONST VALUES THERE (e.g. screen size)
        */
        int playerX = (256 / 2) - 8;
        int playerY = (144 / 2) - 8;

        player = new Sprite(new Texture(Gdx.files.internal("Char.png")), 0, 0, 32, 32);
        player.scale(-0.2f);
        player.setPosition(playerX, playerY);                   // WORLD MUST SPECIFY THIS VALUE
        movementController = new MovementController(player, camera);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.update();

        // Handling input
        movementController.handleMovement();

        // Rendering
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(assetManager.getSprite("floor_1"), 0, 0);
        batch.draw(assetManager.getSprite("floor_2"), 16, 0);
        batch.draw(assetManager.getSprite("floor_1"), 16, 16);
        batch.draw(assetManager.getSprite("floor_2"), 0, 16);
        batch.draw(assetManager.getSprite("floor_1"), 32, 16);
        batch.draw(assetManager.getSprite("wall_1"), 0, 32);
        batch.draw(assetManager.getSprite("wall_2"), 16, 32);
        batch.draw(assetManager.getSprite("wall_1"), 32, 32);
        batch.draw(assetManager.getSprite("top_wall_1"), 0, 48);
        batch.draw(assetManager.getSprite("top_wall_2"), 16, 48);
        batch.draw(assetManager.getSprite("top_wall_1"), 32, 48);
//        assetManager.getSprite("top_wall_1").draw(batch);
        player.draw(batch);
        batch.end();
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
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }
}
