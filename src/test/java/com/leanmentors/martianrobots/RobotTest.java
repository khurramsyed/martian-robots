package com.leanmentors.martianrobots;

import org.junit.Test;

import java.util.Arrays;

import static com.leanmentors.martianrobots.Orientation.E;
import static com.leanmentors.martianrobots.Orientation.N;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RobotTest {

    @Test
    public void ensureWiring() {

        Position position = mock(Position.class);
        World world = mock(World.class);
        when(position.process(Instruction.F)).thenReturn(new Position(E, new Coordinate(5, 6)));
        when(position.getCoordinate()).thenReturn(new Coordinate(5, 6));
        when(world.isInBound(any(Coordinate.class))).thenReturn(false);
        Robot robot = new Robot(world, position);
        verify(position).process(Instruction.F);
        verify(position).getCoordinate();
        verify(world).isInBound(new Coordinate(5, 6));
    }


    @Test
    public void testGivenScenarioWithRealObjects() {
        Robot robot1 = new Robot(new World(5, 1), new Position(E, new Coordinate(1, 1)));
        assertThat(robot1.process(
                Arrays.asList(new Character[]{'R', 'F', 'R', 'F', 'R', 'F', 'R', 'F'})
        )).isEqualTo("3 1 E");

        Robot robot2 = new Robot(new World(5, 1), new Position(N, new Coordinate(3, 2)));
        assertThat(robot2.process(
                Arrays.asList(new Character[]{'F', 'R', 'R', 'F', 'L', 'L', 'F', 'F', 'R', 'R', 'F', 'L', 'L'})
        )).isEqualTo("1 2 N LOST");

        Robot robot3 = new Robot(new World(5, 1), new Position(N, new Coordinate(0, 3)));
        assertThat(robot3.process(
                Arrays.asList(new Character[]{'L', 'L', 'F', 'F', 'F', 'L', 'F', 'L', 'F', 'L'})
        )).isEqualTo("4 3 W LOST");
    }
}
