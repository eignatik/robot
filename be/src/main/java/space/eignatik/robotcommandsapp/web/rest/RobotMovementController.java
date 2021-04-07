package space.eignatik.robotcommandsapp.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import space.eignatik.robotcommandsapp.domain.Robot;
import space.eignatik.robotcommandsapp.exceptions.IncorrectScriptingException;
import space.eignatik.robotcommandsapp.service.RobotCommandService;

@RestController
public class RobotMovementController {

    private final RobotCommandService robotCommandService;

    RobotMovementController(RobotCommandService robotCommandService) {
        this.robotCommandService = robotCommandService;
    }

    @PostMapping(value = "/apply-script")
    public @ResponseBody Robot applyScript(@RequestBody String script) {
        try {
            return robotCommandService.applyScript(script);
        } catch (IncorrectScriptingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping(value = "/health")
    public String health() {
        return "UP";
    }
}
