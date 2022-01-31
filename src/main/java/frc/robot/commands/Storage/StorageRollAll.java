package frc.robot.commands.Storage;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.subsystems.StorageTest;

public class StorageRollAll extends CommandBase {

  private final StorageTest m_intakeTest;

  public StorageRollAll(StorageTest subsystem) {
    m_intakeTest = subsystem;
    addRequirements(m_intakeTest);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.INTAKETEST.rollUp(true);
    Robot.INTAKETEST.rollDown(true);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      Robot.INTAKETEST.stopUp();
    }
  }
}