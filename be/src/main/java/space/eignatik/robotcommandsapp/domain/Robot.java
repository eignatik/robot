package space.eignatik.robotcommandsapp.domain;

import space.eignatik.robotcommandsapp.domain.enums.Direction;

import java.util.Objects;

public class Robot {
    private Position position;

    private Robot() {
    }

    public Robot(int x, int y, Direction direction) {
        this.position = Position.create(x, y, direction.getNumber());
    }

    public void move(int value) {
        this.position.changePosition(value);
    }

    public void turnLeft() {
        this.position.turn(Position.Turn.LEFT);
    }

    public void turnRight() {
        this.position.turn(Position.Turn.RIGHT);
    }

    public void turnAround() {
        this.position.turn(Position.Turn.AROUND);
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public int getDirection() {
        return this.position.getDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(position, robot.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "position=" + position.getX() + ":" + position.getY() +
                '}';
    }
}
