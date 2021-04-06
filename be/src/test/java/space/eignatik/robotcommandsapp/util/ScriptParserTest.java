package space.eignatik.robotcommandsapp.util;

import org.testng.Assert;
import org.testng.annotations.Test;
import space.eignatik.robotcommandsapp.domain.command.*;
import space.eignatik.robotcommandsapp.domain.enums.Direction;
import space.eignatik.robotcommandsapp.exceptions.IncorrectScriptingException;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ScriptParserTest {

    @Test
    public void testParseScript_withSingleLine_shouldReturnOnlyOneCommand() {
        List<Command> commands = ScriptParser.parseScript("POSITION 1 2 EAST");
        assertThat(commands).containsExactly(new PositionCommand(1, 2, Direction.EAST));
    }

    @Test
    public void testParseScript_withFewLines_shouldReturnCorrectList() {
        List<Command> commands = ScriptParser.parseScript(getScript());
        assertThat(commands).containsExactly(
                new PositionCommand(1, 3, Direction.EAST),
                new Forward(3),
                new Wait(),
                new Turnaround(),
                new Forward(1),
                new Right(),
                new Left(),
                new Forward(2)
        ).inOrder();
    }

    @Test
    public void testParseScript_withEmptyScript_shouldReturnEmptyList() {
        List<Command> commands = ScriptParser.parseScript("");
        assertThat(commands).isEmpty();
    }

    @Test
    public void testParseScript_withWrongScript_shouldThrowException() {
        try {
            ScriptParser.parseScript("NOTEXISTINGCOMMAND\nANOTHERCOMMAND\n");
            Assert.fail("Exception has to be thrown");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IncorrectScriptingException.class);
        }
    }

    @Test
    public void testParseScript_withPositionWithIncorrectArguments_shouldThrowException() {
        try {
            ScriptParser.parseScript("POSITION 1 EAST");
            Assert.fail("Exception has to be thrown");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IncorrectScriptingException.class);
        }
    }

    private static String getScript() {
        return "POSITION 1 3 EAST\n" +
                "FORWARD 3\n" +
                "WAIT\n" +
                "TURNAROUND\n" +
                "FORWARD 1\n" +
                "RIGHT\n" +
                "LEFT\n" +
                "FORWARD 2\n";
    }

}