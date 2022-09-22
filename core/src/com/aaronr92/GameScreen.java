package com.aaronr92;

import com.aaronr92.util.AssetManager;
import com.aaronr92.util.SpriteSize;
import com.aaronr92.util.controller.MovementController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
        assetManager = new AssetManager("Tileset_ores.png", SpriteSize.SPRITE_16x16);

        assetManager.addSprite("emerald", 0, 0);
        assetManager.addSprite("rock", 1, 2);
        assetManager.addSprite("chest", 4, 0);

        // Player init
        /* TODO
        *   MOVE CODE BELOW INTO YAML FILE OR ETC
        *   AND ALSO MOVE ALL CONST VALUES THERE (e.g. screen size)
        */
        int playerX = (256 / 2) - 8;
        int playerY = (144 / 2) - 8;

        player = assetManager.getSprite("chest");
        player.setPosition(playerX, playerY);                   // WORLD MUST SPECIFY THIS VALUE
        movementController = new MovementController(player, camera);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.WHITE);

        camera.update();

        // Handling input
        movementController.handleMovement();

        // Rendering
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(assetManager.getSprite("emerald"), 0, 0);
        batch.draw(assetManager.getSprite("emerald"), 16, 0);
        batch.draw(assetManager.getSprite("rock"), 16, 16);
        assetManager.getSprite("chest").draw(batch);
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
