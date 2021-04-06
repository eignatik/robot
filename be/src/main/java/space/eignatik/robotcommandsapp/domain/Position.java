package space.eignatik.robotcommandsapp.domain;

import java.util.Objects;

public class Position {
    private static final int MAX_DIRECTION = 4;
    private static final int MIN_DIRECTION = 1;

    private int x;
    private int y;
    private int direction;

    private Position(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    static Position create(int x, int y, int direction) {
        return new Position(x, y, direction);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getDirection() {
        return direction;
    }

    void turn(Turn turnDirection) {
        if (turnDirection == Turn.LEFT) {
            direction = direction == MIN_DIRECTION ? MAX_DIRECTION : --direction;
        } else if (turnDirection == Turn.RIGHT) {
            direction = direction == MAX_DIRECTION ? MIN_DIRECTION : ++direction;
        } else {
            direction = MAX_DIRECTION - direction;
        }
    }

    void changePosition(int value) {
        switch (direction) {
            case 1: y -= value; break;
            case 2: x += value; break;
            case 3: y += value; break;
            case 4: x -= value; break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y &&
                direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    enum Turn {
        LEFT,
        RIGHT,
        AROUND;
    }
}
