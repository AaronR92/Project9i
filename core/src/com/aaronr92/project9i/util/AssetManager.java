package com.aaronr92.project9i.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {

    private Map<String, Sprite> sprites;
    private Texture texture;
    private final int spriteSize;

    /**
     * @param path path to the texture
     * @param spriteSize size of one sprite in sprite-sheet
     */
    public AssetManager(String path, SpriteSize spriteSize) {
        sprites = new HashMap<>();
        texture = new Texture(Gdx.files.internal(path));
        this.spriteSize = spriteSize.getValue();
    }

    public void updateTexture(String path) {
        texture = new Texture(Gdx.files.internal(path));
    }

    public Texture getTexture() {
        return texture;
    }

    public void addSprite(String name, int row, int column) {
        sprites.put(name, new Sprite(texture, spriteSize * column, spriteSize * row, spriteSize, spriteSize));
    }

    public void dispose() {
        texture.dispose();
        sprites.clear();
    }

    public Sprite getSprite(String name) {
        return sprites.get(name);
    }
}
