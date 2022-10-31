package com.aaronr92.project9i.world;

import com.aaronr92.project9i.object.Player;
import com.aaronr92.project9i.util.AssetManager;
import com.aaronr92.project9i.util.SpriteSize;
import com.aaronr92.project9i.util.World;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameWorld implements World {

    private Player player;

    private AssetManager groundTileSet;
    private SpriteBatch batch;

    public GameWorld(Player player, SpriteBatch batch) {
        this.player = player;
        this.batch = batch;
    }

    @Override
    public void init() {
        groundTileSet = new AssetManager("/tileset/ground.png", SpriteSize.SPRITE_16x16);
    }

    @Override
    public void render() {
        batch.begin();
        //batching
        player.getSprite().draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        groundTileSet.dispose();
    }
}
