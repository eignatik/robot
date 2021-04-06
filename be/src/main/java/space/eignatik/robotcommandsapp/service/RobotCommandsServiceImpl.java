package space.eignatik.robotcommandsapp.service;

import org.springframework.stereotype.Service;
import space.eignatik.robotcommandsapp.domain.Robot;
import space.eignatik.robotcommandsapp.domain.command.*;
import space.eignatik.robotcommandsapp.exceptions.IncorrectScriptingException;
import space.eignatik.robotcommandsapp.util.ScriptParser;

import java.util.List;

@Service
public class RobotCommandsServiceImpl implements RobotCommandService {

    @Override
    public Robot applyScript(String predefinedScript) {
        List<Command> commands = ScriptParser.parseScript(predefinedScript);
        Robot robot = null;
        if (!commands.isEmpty()) {
            Command command = commands.get(0);
            if (command instanceof PositionCommand) {
                PositionCommand positionCommand = (PositionCommand) command;
                robot = new Robot(positionCommand.getX(), positionCommand.getY(), positionCommand.getDirection());
            }
        }
        if (robot == null) {
            throw new IncorrectScriptingException("Script has to contain POSITION as a first command.");
        }
        for (Command command : commands) {
            if (command instanceof Forward) {
                Forward forward = (Forward) command;
                robot.move(forward.getValue());
                continue;
            }
            if (command instanceof Left) {
                robot.turnLeft();
                continue;
            }
            if (command instanceof Right) {
                robot.turnRight();
                continue;
            }
            if (command instanceof Turnaround) {
                robot.turnAround();
                continue;
            }
            if (command instanceof Wait) {
                // Do nothing
            }
        }
        return robot;
    }
}
