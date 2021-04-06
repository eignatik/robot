package space.eignatik.robotcommandsapp.domain.command;

public class Left extends Command {

    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Left;
    }

}
