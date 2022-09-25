package com.aaronr92.project9i.object;

import com.aaronr92.project9i.util.Movable;
import com.aaronr92.project9i.util.SpriteSize;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private Sprite sprite;
    private final Rectangle bounds;
    private Movable movementController;

    public Player(Sprite sprite, SpriteSize size) {
        this.sprite = sprite;
        this.bounds = new Rectangle(0, 0, size.getValue(), size.getValue());
    }

    public void handleMovement() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            movementController.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            movementController.moveRight();
        }
    }

    public void setMovementController(Movable movementController) {
        this.movementController = movementController;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
