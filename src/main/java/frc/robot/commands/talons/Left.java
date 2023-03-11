package frc.robot.commands.talons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Left extends CommandBase {
  public Left() {
    addRequirements(Robot.MOTOR_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.MOTOR_TESTING.one(true);
    Robot.MOTOR_TESTING.two(true);
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    if(interrupted) {
      Robot.MOTOR_TESTING.stop();
    }
  }
}
