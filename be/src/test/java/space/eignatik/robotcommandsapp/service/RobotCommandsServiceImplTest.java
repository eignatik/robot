package space.eignatik.robotcommandsapp.service;

import com.google.common.truth.Truth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import space.eignatik.robotcommandsapp.domain.Position;
import space.eignatik.robotcommandsapp.domain.Robot;
import space.eignatik.robotcommandsapp.domain.enums.Direction;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.*;

public class RobotCommandsServiceImplTest {

    private RobotCommandService service;

    @BeforeClass
    public void setUp() {
        service = new RobotCommandsServiceImpl();
    }

    @Test
    public void testApplyScript() {
        Robot robot = service.applyScript(getPredefinedScript());
        assertThat(robot).isEqualTo(new Robot(3, 1, Direction.NORTH));
    }

    private static String getPredefinedScript() {
        return "POSITION 1 2 EAST\nFORWARD 2\nLEFT\nFORWARD 1\n";
    }
}