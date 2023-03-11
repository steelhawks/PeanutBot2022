/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.ButtonTesting;
import frc.robot.subsystems.MotorTesting;
import frc.robot.subsystems.SolenoidTesting;


public class Robot extends TimedRobot
{
  /*****
   * Robot Objects
   *****/
  public static final RobotMap ROBOTMAP = new RobotMap();
  
  public static final CommandLinker COMMAND_LINKER = new CommandLinker();
  public double count = -0.99;
  
  public static final ButtonTesting BUTTON_TESTING = new ButtonTesting();
  public static final SolenoidTesting SOLENOID_TESTING = new SolenoidTesting();
  public static final MotorTesting MOTOR_TESTING = new MotorTesting();
  public static final Compressor compressor = new Compressor(PneumaticsModuleType.REVPH);    
  
  
  @Override
  public void robotInit() 
  {
    Robot.COMMAND_LINKER.configureRegisteredSubsystems();  
    Robot.COMMAND_LINKER.configureCommands();
    // compressor.disable();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() 
  {
    CommandScheduler.getInstance().enable();
    //MUSIC.playMusic();

  }

  @Override
  public void teleopPeriodic() 
  {
    CommandScheduler.getInstance().run();
    // SOLENOID_TESTING.triggerPistonIfHit();
  }

  @Override
  public void testPeriodic() {}
}
