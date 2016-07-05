package com.dobbby.obsession.bean;

/**
 * Created by Dobbby on 16/7/5.
 */
public class Trap {
    public static final int RECTANGLE = 0;
    public static final int TRIANGLE = 1;
    public static final int LEFT_TRIANGLE = 0;
    public static final int RIGHT_TRIANGLE = 1;
    /**
     * shape receive para: RECTANGLE or TRIANGLE.
     */
    private int shape;
    /**
     * triangleDirection receive para: LEFT_TRIANGLE or RIGHT_TRIANGLE.
     */
    private int triangleDirection;
    /**
     * width of the trap.
     */
    private int width;
    /**
     * height of the trap.
     */
    private int height;
    /**
     * distance from the former trap.
     */
    private int distance;

    public int getWidth() {
        return width;
    }

    public Trap setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Trap setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getShape() {
        return shape;
    }

    public Trap setShape(int shape) {
        this.shape = shape;
        return this;
    }

    public int getTriangleDirection() {
        return triangleDirection;
    }

    public Trap setTriangleDirection(int triangleDirection) {
        this.triangleDirection = triangleDirection;
        return this;
    }

    public int getDistance() {
        return distance;
    }

    public Trap setDistance(int distance) {
        this.distance = distance;
        return this;
    }
}
