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
        int width = 20;
        return new Trap()
                .setWidth(width)
                .setDistance(random.nextInt(width) + width)
                .setShape(random.nextInt(1))
                .setTriangleDirection(random.nextInt(1));
    }
}
