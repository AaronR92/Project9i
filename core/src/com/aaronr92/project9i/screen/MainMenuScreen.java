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

    private Texture buttonPlay;
    private Texture buttonPlayHover;
    private Texture buttonSettings;
    private Texture buttonSettingsHover;
    private Texture buttonExit;
    private Texture buttonExitHover;

    public MainMenuScreen(GameMain gameMain) {
        this.game = gameMain;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        // adding textures
        buttonPlay = new Texture(Gdx.files.internal("button/play.png"));
        buttonPlayHover = new Texture(Gdx.files.internal("button/play_hover.png"));

        buttonSettings = new Texture(Gdx.files.internal("button/settings.png"));
        buttonSettingsHover = new Texture(Gdx.files.internal("button/settings_hover.png"));

        buttonExit = new Texture(Gdx.files.internal("button/exit.png"));
        buttonExitHover = new Texture(Gdx.files.internal("button/exit_hover.png"));

        // table
        table = new Table();
        table.setPosition(Gdx.graphics.getWidth() / -3f,  0);
        table.setFillParent(true);
        stage.addActor(table);

        ButtonStyle playButtonStyle = new ButtonStyle();
        playButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonPlay));
        playButtonStyle.over = new TextureRegionDrawable(new TextureRegion(buttonPlayHover));

        ButtonStyle settingsButtonStyle = new ButtonStyle();
        settingsButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonSettings));
        settingsButtonStyle.over = new TextureRegionDrawable(new TextureRegion(buttonSettingsHover));

        ButtonStyle exitButtonStyle = new ButtonStyle();
        exitButtonStyle.up = new TextureRegionDrawable(new TextureRegion(buttonExit));
        exitButtonStyle.over = new TextureRegionDrawable(new TextureRegion(buttonExitHover));

        Button buttonPlay = new Button(playButtonStyle);
        Button buttonSettings = new Button(settingsButtonStyle);
        Button buttonExit = new Button(exitButtonStyle);
        addClickEventListener(buttonPlay, new GameScreen(game));
        addClickEventListener(buttonSettings, null);
        addClickEventListener(buttonExit, null);

        table.add(buttonPlay).size(BUTTON_WIDTH * 4, BUTTON_HEIGHT * 4);
        table.row().pad(8f);
        table.add(buttonSettings).size(BUTTON_WIDTH * 4, BUTTON_HEIGHT * 4);
        table.row().pad(8f);
        table.add(buttonExit).size(BUTTON_WIDTH * 4, BUTTON_HEIGHT * 4);

        table.setDebug(false);

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
                if (screen == null) {
                    Gdx.app.exit();
                    return;
                }
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
