
package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class ToggleSolOne extends CommandBase {

  public ToggleSolOne() {
    addRequirements(Robot.SOLENOID_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.SOLENOID_TESTING.toggleSolOne();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {
  }
}