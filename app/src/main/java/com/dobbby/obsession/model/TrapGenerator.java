package com.dobbby.obsession.model;

import com.dobbby.obsession.bean.Trap;

import java.util.Random;

/**
 * Created by Dobbby on 16/7/5.
 */
public class TrapGenerator implements ITrapGenerator {
    @Override
    public Trap generateTrap() {
        Random random = new Random();
        final int width = 20;
        final int height = 20;
        return new Trap()
                .setWidth(width)
                .setHeight(height)
                .setDistance(random.nextInt(width) + width)
                .setShape(random.nextInt(2))
                .setTriangleDirection(random.nextInt(2));
    }
}
