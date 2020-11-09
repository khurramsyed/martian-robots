package com.leanmentors.martianrobots;

import lombok.Getter;

public class Position {
    @Getter
    private Orientation orientation;
    @Getter
    private Coordinate coordinate;

    public Position(Orientation orientation, Coordinate coordinate) {
        this.orientation = orientation;
        this.coordinate = coordinate;
    }

    public Position process(Instruction instruction) {
        switch (instruction) {
            case F:
                processX();
                processY();
                break;
            case L:
                orientation = orientation.rotateLeft();
                break;
            case R:
                orientation = orientation.rotateRight();

        }
        return this.clone();
    }

    public Position clone(){
        return new Position(orientation, new Coordinate(coordinate.getX(), coordinate.getY()));
    }

    public String toString(){
        return  coordinate.getX()+" "+coordinate.getY() +" "+orientation ;
    }

    private void processX() {
        switch (orientation) {
            case E:
                coordinate.setX(coordinate.getX() + 1);
                break;
            case W:
                coordinate.setX(coordinate.getX() - 1);
        }
    }

    private void processY() {
        switch (orientation) {
            case N:
                coordinate.setX(coordinate.getY() + 1);
                break;
            case S:
                coordinate.setX(coordinate.getY() - 1);
        }
    }
}
