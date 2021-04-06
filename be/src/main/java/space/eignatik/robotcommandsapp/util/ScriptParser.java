package space.eignatik.robotcommandsapp.util;

import space.eignatik.robotcommandsapp.domain.command.*;
import space.eignatik.robotcommandsapp.domain.enums.Direction;
import space.eignatik.robotcommandsapp.exceptions.IncorrectScriptingException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ScriptParser {

    private static final Pattern POSITION_PATTERN = Pattern.compile("POSITION\\s\\d\\s\\d\\s(EAST|NORTH|WEST|SOUTH)");
    private static final Pattern FORWARD_PATTERN = Pattern.compile("FORWARD\\s\\d");
    private static final Pattern LEFT_PATTERN = Pattern.compile("LEFT");
    private static final Pattern RIGHT_PATTERN = Pattern.compile("RIGHT");
    private static final Pattern TURNAROUND_PATTERN = Pattern.compile("TURNAROUND");
    private static final Pattern WAIT_PATTERN = Pattern.compile("WAIT");

    private ScriptParser() {}

    public static List<Command> parseScript(String script) {
        if (script == null || script.isEmpty()) {
            return List.of();
        }
        String[] scriptLines = script.split("\n");
        //TODO(eignatik): add validation on POSITION (only one occurrence and only at the beginning)
        return Stream.of(scriptLines)
                .map(ScriptParser::createCommand)
                .collect(Collectors.toList());
    }

    private static Command createCommand(String scriptLine) {
        if (POSITION_PATTERN.matcher(scriptLine).find()) {
            String[] command = scriptLine.split("\\s");
            int x = Integer.parseInt(command[1]);
            int y = Integer.parseInt(command[2]);
            Direction direction = Direction.valueOf(command[3]);
            return new PositionCommand(x, y, direction);
        }
        if (FORWARD_PATTERN.matcher(scriptLine).find()) {
            String[] command = scriptLine.split("\\s");
            int value = Integer.parseInt(command[1]);
            return new Forward(value);
        }
        if (TURNAROUND_PATTERN.matcher(scriptLine).find()) {
            return new Turnaround();
        }
        if (LEFT_PATTERN.matcher(scriptLine).find()) {
            return new Left();
        }
        if (RIGHT_PATTERN.matcher(scriptLine).find()) {
            return new Right();
        }
        if (WAIT_PATTERN.matcher(scriptLine).find()) {
            return new Wait();
        }
        throw new IncorrectScriptingException(String.format("Script '%s' hasn't been parsed", scriptLine));
    }

}
