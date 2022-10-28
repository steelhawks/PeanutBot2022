package frc.robot.commands.talons;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class EncoderComm extends CommandBase {

  public EncoderComm() {
    addRequirements(Robot.ENCODER_TESTING);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.ENCODER_TESTING.move();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    if(interrupted) {
      Robot.ENCODER_TESTING.stop();
    }
  }
}
