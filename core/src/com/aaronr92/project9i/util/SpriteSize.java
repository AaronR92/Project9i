package com.aaronr92.project9i.util;

public enum SpriteSize {
    SPRITE_8x8(8),
    SPRITE_16x16(16),
    SPRITE_32x32(16),
    SPRITE_64x64(16);

    private final int value;

    SpriteSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
