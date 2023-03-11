package frc.robot.commands.talons;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;


public class Right extends CommandBase {
  public Right() {
    addRequirements(Robot.MOTOR_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.MOTOR_TESTING.three(true);
    Robot.MOTOR_TESTING.four(true);
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