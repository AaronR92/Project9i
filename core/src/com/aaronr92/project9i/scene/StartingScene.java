package com.aaronr92.project9i.scene;

import com.aaronr92.project9i.util.AssetManager;
import com.aaronr92.project9i.util.SpriteSize;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartingScene {

    private SpriteBatch batch;
    private AssetManager assetManager;

    public StartingScene(SpriteBatch batch) {
        this.batch = batch;
        assetManager = new AssetManager("tileset/greetLevel.png", SpriteSize.SPRITE_16x16);
    }

    public void init() {

    }

    public void render() {

    }

    public void dispose() {

    }

}
