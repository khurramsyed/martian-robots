package com.leanmentors.martianrobots;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class WorldTest {

    @Test
    public void checkCoordinatesWithValidBound(){
        World world = new World(10,10);
        assertThat(world.isInBound(new Coordinate(10,10))).isTrue();
        assertThat(world.isInBound(new Coordinate(5,5))).isTrue();
        assertThat(world.isInBound(new Coordinate(0,0))).isTrue();
    }

    @Test
    public void checkCoordinatesWithInValidBound(){
        World world = new World(10,10);
        assertThat(world.isInBound(new Coordinate(9,11))).isFalse();
        assertThat(world.isInBound(new Coordinate(11,10))).isFalse();
        assertThat(world.isInBound(new Coordinate(-1,10))).isFalse();
        assertThat(world.isInBound(new Coordinate(5,-1))).isFalse();

    }

    @Test
    public void testThatWorldCreatedWithCorrectParameters(){
        World world = World.createWorld(new String[]{"5", "5"});
        assertThat(world).isNotNull();
        assertThat(world.isInBound(new Coordinate(5,5))).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatWorldCannotBeCreatedWithTooManyParameter(){
        World world = World.createWorld(new String[]{"5", "5", "5"});
        fail("World Should not have created with too many parameter");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatWorldCannotBeCreatedWithTooFewParameter(){
        World world = World.createWorld(new String[]{"5"});
        fail("World Should not have created with too few parameter");
    }

    @Test
    public void robotShouldBeCreatedWithCorrectData(){
        World world = World.createWorld(new String[]{"5", "5"});
        Robot robot = World.createRobot("5 3 N", world);
        assertThat(robot).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void robotShouldNotBeCreatedWithTooFewParameters(){
        World world = World.createWorld(new String[]{"5", "5"});
        Robot robot = World.createRobot("5 N", world);
        fail("Robot should not have been created with just two parameters");
    }

    @Test(expected = IllegalArgumentException.class)
    public void robotShouldNotBeCreatedWithTooManyParameters(){
        World world = World.createWorld(new String[]{"5", "5"});
        Robot robot = World.createRobot("5 5 5 N", world);
        fail("Robot should not have been created with too many parameters");
    }
}
