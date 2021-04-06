package space.eignatik.robotcommandsapp.domain.command;

import java.util.Objects;

public class Forward extends Command {
    private final int value;

    public Forward(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forward forward = (Forward) o;
        return value == forward.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Forward{" +
                "value=" + value +
                '}';
    }
}
