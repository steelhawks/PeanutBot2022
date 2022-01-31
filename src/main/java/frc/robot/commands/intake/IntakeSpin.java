package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class IntakeSpin extends CommandBase {

  private final Intake m_intakeTest;

  public IntakeSpin(Intake subsystem) {
    m_intakeTest = subsystem;
    addRequirements(m_intakeTest);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.INTAKE.spinRoller(Robot.ROBOTMAP.speedIntake);
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {
    if (interrupted) {
      Robot.INTAKE.stopRoll();
    }
  }
}