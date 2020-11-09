package com.leanmentors.martianrobots;

import org.junit.Test;

import static com.leanmentors.martianrobots.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void testCorrectNextOrientationsForLeftTurns(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.E, originalCoordinates);
        Position firstChange = validateRotatedPoistions(originalCoordinates, position, Instruction.L, N);
        Position secondChange = validateRotatedPoistions(originalCoordinates, firstChange, Instruction.L, W);
        Position thirdChange = validateRotatedPoistions(originalCoordinates, secondChange, Instruction.L, S);
        validateRotatedPoistions(originalCoordinates, thirdChange, Instruction.L, E);
    }

    @Test
    public void testCorrectNextOrientationsForRightTurns(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.E, originalCoordinates);
        Position firstChange = validateRotatedPoistions(originalCoordinates, position, Instruction.R, S);
        Position secondChange = validateRotatedPoistions(originalCoordinates, firstChange, Instruction.R, W);
        Position thirdChange = validateRotatedPoistions(originalCoordinates, secondChange, Instruction.R, N);
        validateRotatedPoistions(originalCoordinates, thirdChange, Instruction.R, E);
    }

    @Test
    public void testThatMovingForwardEastwardsIncreasesX(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.E, originalCoordinates);
        Position secondPosition = position.process(Instruction.F);
        assertThat(secondPosition.getOrientation()).isEqualTo(position.getOrientation());
        assertThat(secondPosition.getCoordinate()).isEqualTo(new Coordinate(6,5));
    }

    @Test
    public void testThatMovingForwardWestwardsDecreasesX(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.W, originalCoordinates);
        Position secondPosition = position.process(Instruction.F);
        assertThat(secondPosition.getOrientation()).isEqualTo(position.getOrientation());
        assertThat(secondPosition.getCoordinate()).isEqualTo(new Coordinate(4,5));
    }


    @Test
    public void testThatMovingForwardNorthwardsIncreasesY(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.N, originalCoordinates);
        Position secondPosition = position.process(Instruction.F);
        assertThat(secondPosition.getOrientation()).isEqualTo(position.getOrientation());
        assertThat(secondPosition.getCoordinate()).isEqualTo(new Coordinate(5,6));
    }

    @Test
    public void testThatMovingForwardSouthwardsDecreasesY(){
        Coordinate originalCoordinates = new Coordinate(5,5);
        Position position = new Position(Orientation.S, originalCoordinates);
        Position secondPosition = position.process(Instruction.F);
        assertThat(secondPosition.getOrientation()).isEqualTo(position.getOrientation());
        assertThat(secondPosition.getCoordinate()).isEqualTo(new Coordinate(5,4));
    }

    private Position validateRotatedPoistions(Coordinate originalCoordinates, Position firstChange, Instruction instruction, Orientation orientation) {
        Position newPosition = firstChange.process(instruction);
        assertThat(newPosition.getOrientation()).isEqualTo(orientation);
        assertThat(newPosition.getCoordinate()).isEqualTo(originalCoordinates);
        return newPosition;
    }
}
