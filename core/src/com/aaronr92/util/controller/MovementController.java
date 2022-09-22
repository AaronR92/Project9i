package com.aaronr92.util.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovementController {

    private final OrthographicCamera camera;
    private final Sprite player;
    private float speed;
    private float speedMultiplier;

    public MovementController(Sprite player, OrthographicCamera camera) {
        this.camera = camera;
        this.player = player;
        speed = 65f;
        speedMultiplier = 1f;
    }

    public void handleMovement() {
        // Normal movement
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(Gdx.graphics.getDeltaTime() * speed * speedMultiplier, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.translateY(Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(0, Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.translateY(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            camera.translate(0, -1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }

        // Diagonal movement
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            player.translateY(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);

            camera.translate(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier,
                    -0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            player.translateY(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);

            camera.translate(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier,
                    -0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            player.translateY(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);

            camera.translate(-0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier,
                    0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
            player.translateY(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);

            camera.translate(0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier,
                    0.3f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
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
