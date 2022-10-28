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
import frc.robot.commands.talons.EncoderComm;
import frc.robot.subsystems.ButtonTesting;
import frc.robot.subsystems.EncoderTesting;
import frc.robot.subsystems.MotorTesting;
import frc.robot.subsystems.SolenoidTesting;


public class Robot extends TimedRobot //BRIAN WAS HERE
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
  public static final EncoderTesting ENCODER_TESTING = new EncoderTesting();
  // public static final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);    
  
  @Override
  public void robotInit() 
  { 
    Robot.COMMAND_LINKER.configureRegisteredSubsystems();  
    Robot.COMMAND_LINKER.configureCommands();
    //System.out.println(compressor.enabled());
    //compressor.disable();
  }

  @Override
  public void robotPeriodic() {
    Robot.ENCODER_TESTING.shuffleBoard();
  }

  @Override
  public void disabledInit() {
    Robot.ENCODER_TESTING.resetEncoder();
  }

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

  }

  @Override
  public void testPeriodic() {}
}
