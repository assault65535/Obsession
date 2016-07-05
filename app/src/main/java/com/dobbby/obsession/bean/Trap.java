package com.dobbby.obsession.bean;

/**
 * Created by Dobbby on 16/7/5.
 */
public class Trap {
    public static final int RECTANGLE = 0;
    public static final int TRIANGLE = 1;
    public static final int LEFT_TRIANGLE = 0;
    public static final int RIGHT_TRANGLE = 1;
    private int width;
    private int shape;
    private int triangleDiretion;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getTriangleDiretion() {
        return triangleDiretion;
    }

    public void setTriangleDiretion(int triangleDiretion) {
        this.triangleDiretion = triangleDiretion;
    }
}
