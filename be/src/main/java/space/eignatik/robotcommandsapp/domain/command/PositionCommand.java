package space.eignatik.robotcommandsapp.domain.command;

import space.eignatik.robotcommandsapp.domain.enums.Direction;

import java.util.Objects;

public class PositionCommand extends Command {
    private final int x;
    private final int y;
    private final Direction direction;

    public PositionCommand(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionCommand positionCommand = (PositionCommand) o;
        return x == positionCommand.x &&
                y == positionCommand.y &&
                direction == positionCommand.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
