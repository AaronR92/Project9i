package com.aaronr92.project9i.object;

import com.aaronr92.project9i.util.Movable;
import com.aaronr92.project9i.util.MovementController;
import com.aaronr92.project9i.util.SpriteSize;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private Sprite sprite;
    private final Rectangle bounds;
    private MovementController movementController;

    public Player(Sprite sprite, SpriteSize spriteSize, float x, float y) {
        this.sprite = sprite;
        int size = spriteSize.getValue();
        sprite.setBounds(x, y, size, size);
        this.bounds = new Rectangle(x, y, size, size);
    }

    public void handleMovement() {
        // Diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.W)) {
            movementController.moveLeft(true);
            movementController.moveUp(true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.S)) {
            movementController.moveLeft(true);
            movementController.moveDown(true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.W)) {
            movementController.moveRight(true);
            movementController.moveUp(true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.S)) {
            movementController.moveRight(true);
            movementController.moveDown(true);
        }
        // Normal
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            movementController.moveLeft(false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            movementController.moveRight(false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            movementController.moveUp(false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            movementController.moveDown(false);
        }
    }

    public void setMovementController(MovementController movementController) {
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
