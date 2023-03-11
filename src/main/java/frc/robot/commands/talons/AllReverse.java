package frc.robot.commands.talons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AllReverse extends CommandBase {
  public AllReverse() {
    addRequirements(Robot.MOTOR_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.MOTOR_TESTING.one(false);
    Robot.MOTOR_TESTING.two(false);
    Robot.MOTOR_TESTING.three(false);
    Robot.MOTOR_TESTING.four(false);
    Robot.MOTOR_TESTING.five(false);
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
