package frc.robot.commands.buttons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ButtonTest extends CommandBase {
    private int button;
    public ButtonTest(int num) {
        addRequirements(Robot.BUTTON_TESTING);
        button = num;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.BUTTON_TESTING.test(button);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
