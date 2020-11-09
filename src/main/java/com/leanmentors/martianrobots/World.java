package com.leanmentors.martianrobots;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class World {
    private Coordinate maxCoordinate;

    public World(int maxX, int maxY) {
        this.maxCoordinate = new Coordinate(maxX, maxY);
    }

    public boolean isInBound(Coordinate coordinate) {
        return isValidX(coordinate.getX()) && isValidY(coordinate.getY());
    }

    private boolean isValidX(int x) {
        return x >= 0 && x <= maxCoordinate.getX();
    }

    private boolean isValidY(int y) {
        return y >= 0 && y <= maxCoordinate.getY();
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(System.in)) {
            String[] worldCoordinates = scanner.nextLine().split(" ");
            World mars = createWorld(worldCoordinates);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    Robot robot = createRobot(line, mars);
                    System.out.println(robot.process(parseInstructions(scanner.nextLine())));
                }
            }
        }
    }

    static World createWorld(String[] worldCoordinates) {
        if (worldCoordinates.length != 2) {
            throw new IllegalArgumentException("World should have only two max co-ordinates");
        }
        return new World(Integer.parseInt(worldCoordinates[0]), Integer.parseInt(worldCoordinates[1]));
    }

    static Robot createRobot(String input, World world) {
        String[] parameters = input.split(" ");
        if(parameters.length != 3) {
            throw new IllegalArgumentException("Correct usage X-Coordinate Y-Coordiate Orientation e.g. 2 3 E");
        }
        Orientation orientation = Orientation.valueOf(parameters[2]);
        Position startPosition = new Position(orientation, new Coordinate(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1])) );

        return new Robot(world, startPosition);
    }

    static List<Character> parseInstructions(String input) {
        return input.chars().mapToObj(item -> Character.valueOf((char)item)).collect(Collectors.toList());
    }
}
