package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Robot;

import java.util.HashSet;
import java.util.Set;

public class ZeroGyro implements Command 
{
  public ZeroGyro() {}

  @Override
  public Set<Subsystem> getRequirements() 
  {
    Set<Subsystem> list = new HashSet<Subsystem>();
    list.add(Robot.DRIVETRAIN);
    return list;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() 
  {
    Robot.DRIVETRAIN.resetGyro();
  }

  @Override
  public boolean isFinished() 
  {
    return false;
  }

  @Override
  public void end(boolean interrupted) {}
}