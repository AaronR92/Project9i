package com.aaronr92.project9i.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovementController implements Movable {

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

    @Override
    public void moveRight() {
        player.translateX(Gdx.graphics.getDeltaTime() * speed);
//        camera.translate(Gdx.graphics.getDeltaTime() * speed, 0);
    }

    @Override
    public void moveLeft() {
        player.translateX(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier);
//        camera.translate(-1f * Gdx.graphics.getDeltaTime() * speed * speedMultiplier, 0);
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
