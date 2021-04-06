package space.eignatik.robotcommandsapp.domain.enums;

public enum Direction {
    NORTH(1),
    EAST(2),
    SOUTH(3),
    WEST(4);

    private final int number;

    Direction(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}