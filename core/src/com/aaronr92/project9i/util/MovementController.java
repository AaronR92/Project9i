package com.aaronr92.project9i.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovementController implements Movable {

    private final OrthographicCamera camera;
    private final Sprite player;
    private float speed;
    private float speedMultiplier;
    private float diagonalMultiplier;
    private boolean lookingLeft;
    private boolean lookingRight;
    private boolean lookingUp;
    private boolean lookingDown;

    public MovementController(Sprite player, OrthographicCamera camera) {
        this.camera = camera;
        this.player = player;
        speed = 65f;
        speedMultiplier = 1f;
        diagonalMultiplier = 0.7f;
        lookingLeft = false;
        lookingRight = true;
        lookingDown = true;
        lookingUp = false;
    }

    @Override
    public void moveRight(boolean isDiagonal) {
        // Flipping player
        if (!lookingRight) {
            lookingRight = true;
            lookingLeft = false;
            player.flip(true, false);
        }

        if (isDiagonal) {
            player.translateX(Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
            camera.translate(Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier, 0);
        } else {
            player.translateX(Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(Gdx.graphics.getDeltaTime() * speed * speedMultiplier, 0);
        }
    }

    @Override
    public void moveLeft(boolean isDiagonal) {
        // Flipping player
        if (!lookingLeft) {
            lookingLeft = true;
            lookingRight = false;
            player.flip(true, false);
        }

        if (isDiagonal) {
            player.translateX(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
            camera.translate(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier, 0);
        } else {
            player.translateX(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier, 0);
        }
    }

    @Override
    public void moveUp(boolean isDiagonal) {
        if (isDiagonal) {
            player.translateY(Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
            camera.translate(0, Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
        } else {
            player.translateY(Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(0, Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }
    }

    @Override
    public void moveDown(boolean isDiagonal) {
        if (isDiagonal) {
            player.translateY(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
            camera.translate(0, -1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier * diagonalMultiplier);
        } else {
            player.translateY(-1f * Gdx.graphics.getDeltaTime() * speedMultiplier * speed);
            camera.translate(0, -1f * Gdx.graphics.getDeltaTime() * speedMultiplier * speed);
        }
    }

    public void updateSpeedMultiplier(float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public float getSpeed() {
        return speed;
    }

}
