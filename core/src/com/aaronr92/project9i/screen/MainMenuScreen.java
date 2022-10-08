package com.aaronr92.project9i.screen;

import com.aaronr92.project9i.GameMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenuScreen implements Screen {

    private final int BUTTON_WIDTH = 128;
    private final int BUTTON_HEIGHT = 32;

    private GameMain game;
    private Sprite background;

    // Scene2d setup
    private Stage stage;
    private Table table;

    private Texture buttonPlayInactive;
    private Texture buttonPlayActive;

    public MainMenuScreen(GameMain gameMain) {
        this.game = gameMain;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        // adding textures
        buttonPlayInactive = new Texture(Gdx.files.internal("button/inactive_play.png"));

        // table
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.setDebug(true);

        ButtonStyle playButtonStyle = new ButtonStyle();
        playButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonPlayInactive));

        Button buttonPlay = new Button(playButtonStyle);
        addClickEventListener(buttonPlay, new GameScreen(game));

        table.add(buttonPlay);
        table.row();

        background = new Sprite(new Texture(Gdx.files.internal("Castle.png")));

        stage.addActor(table);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void addClickEventListener(Button button, final Screen screen) {
        button.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, final Actor actor) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        blockInput(actor);
                    }
                }).start();
                game.setScreen(screen);
            }
        });
    }

    private void blockInput(Actor actor) {
        actor.setTouchable(Touchable.disabled);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.setTouchable(Touchable.enabled);
    }
}
