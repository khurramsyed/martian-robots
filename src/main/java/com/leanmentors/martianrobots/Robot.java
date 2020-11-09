package com.leanmentors.martianrobots;

import java.util.List;

public class Robot {

    private Position position;
    private World world;

    public Robot(World world, Position startingPosition) {
        this.world = world;
        this.position = startingPosition;
    }

    public String process(List<Character> instructions) {
        instructions.stream()
                .map(str -> Instruction.valueOf(str.toString()))
                .forEach(instruction -> position.process(instruction));
        return position + (world.isInBound(position.getCoordinate())?"":" LOST");
    }
}