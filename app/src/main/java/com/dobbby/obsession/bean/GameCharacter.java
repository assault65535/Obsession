package com.dobbby.obsession.bean;

/**
 * Created by Dobbby on 16/7/5.
 */
public class GameCharacter {
    public static final int UP = 0;
    public static final int DOWN = 1;
    /**
     * position receive para: UP or DOWN.
     */
    private int position;
    private int x;
    private int y;

    public int getPosition() {
        return position;
    }

    public GameCharacter setPosition(int position) {
        this.position = position;
        return this;
    }

    public int getX() {
        return x;
    }

    public GameCharacter setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public GameCharacter setY(int y) {
        this.y = y;
        return this;
    }
}
