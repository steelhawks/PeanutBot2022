
package frc.robot.commands.solenoids;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class ToggleSolTwo extends CommandBase {

  public ToggleSolTwo() {
    addRequirements(Robot.SOLENOID_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.SOLENOID_TESTING.toggleSolTwo();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {
  }
}