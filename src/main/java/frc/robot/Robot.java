/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotController;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
//import com.revrobotics.AnalogInput;
import com.revrobotics.ColorMatch;
import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Util.ColorSensor;

public class Robot extends TimedRobot 
{
  /*****
   * Robot Objects
   *****/
  public static final RobotMap ROBOTMAP = new RobotMap();
  public static final Drivetrain DRIVETRAIN = new Drivetrain();
  public static final CommandLinker COMMAND_LINKER = new CommandLinker();
  public WPI_TalonSRX light = new WPI_TalonSRX(ROBOTMAP.getLightPort());
  public double count = -0.99;


  //color sensor testing

  public static final ColorSensor COLOR_SENSOR = new ColorSensor();

  /*
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();
  
  // private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  // private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  // private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  // private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  private final Color kBlueTarget = Color.kBlue;
  private final Color kGreenTarget = Color.kGreen;
  private final Color kRedTarget = Color.kRed;
  private final Color kYellowTarget = Color.kYellow;
  
  ShuffleboardTab tab = Shuffleboard.getTab("colors");
  private NetworkTableEntry red;
  private NetworkTableEntry green;
  private NetworkTableEntry blue;
  private NetworkTableEntry confidence ;
  private NetworkTableEntry colorfound ;
  */

  //ultrasonic
  final AnalogInput ultrasonic = new AnalogInput(0);
  

  @Override
  public void robotInit() 
  {
    //COMMAND_LINKER.configureCommands();
    light.configContinuousCurrentLimit(1);
    light.enableCurrentLimit(true);

    CommandScheduler.getInstance().setDefaultCommand(Robot.DRIVETRAIN, new DiffDrive());

    //CommandScheduler.getInstance().registerSubsystem(Robot.DRIVETRAIN);
    //CommandScheduler.getInstance().registerSubsystem(Robot.ULTRA);
    //CommandScheduler.getInstance().registerSubsystem(Robot.VISION);

    //Button SHIFT_BUTTON = new JoystickButton(Robot.COMMAND_LINKER.DRIVE_JOYSTICK, Robot.ROBOTMAP.getShiftButton());
    //Button ALIGN_BUTTON = new JoystickButton(Robot.COMMAND_LINKER.DRIVE_JOYSTICK, Robot.ROBOTMAP.getAlignButton());

    //SHIFT_BUTTON.whenPressed(new ShiftGear());
    //ALIGN_BUTTON.whenPressed(new Align());

    //colorsensortest

    /*
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

    ShuffleboardTab tab = Shuffleboard.getTab("colors");
    tab.add("Red", 0).getEntry();
    tab.add("Green", 0).getEntry();
    tab.add("Blue", 0).getEntry();
    tab.add("Confidence", 0).getEntry();
    tab.add("Detected Color", "").getEntry();
    */

    COLOR_SENSOR.matchfixedcolors();

    //tab.add("currentDistanceCentimeters", currentDistanceCentimeters).getEntry();
    //tab.add("currentDistanceInches", currentDistanceInches).getEntry();
    
    //ultrasonic testing


  }

  @Override
  public void robotPeriodic() 
  {
    
    /*
    double raw_value = ultrasonic.getValue();
    //voltage_scale_factor allows us to compensate for differences in supply voltage.
    double voltage_scale_factor = 5/RobotController.getVoltage5V();
    double currentDistanceCentimeters = raw_value * voltage_scale_factor * 0.125;
    double currentDistanceInches = raw_value * voltage_scale_factor * 0.0492;
    System.out.println(currentDistanceCentimeters + "cm");
    System.out.println(currentDistanceInches + "in");
    */

    /*
    Color detectedColor = m_colorSensor.getColor();

    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    String colorString;

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    
    red.setDouble(detectedColor.red);
    green.setDouble(detectedColor.green);
    blue.setDouble(detectedColor.blue);
    confidence.setDouble(match.confidence);
    colorfound.setString(colorString);
    
    

      
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    */
    COLOR_SENSOR.detectColor();
    COLOR_SENSOR.updatecolortable();
  }

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


    
  }
  public void teleopPeriodic() 
  {
    CommandScheduler.getInstance().run();
    light.set(1.0);
  }

  @Override
  public void testPeriodic() {}


}
