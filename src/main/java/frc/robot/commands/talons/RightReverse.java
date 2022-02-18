package frc.robot.commands.talons;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;


public class RightReverse extends CommandBase {
  public RightReverse() {
    addRequirements(Robot.MOTOR_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.MOTOR_TESTING.six(false);
    Robot.MOTOR_TESTING.three(false);
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