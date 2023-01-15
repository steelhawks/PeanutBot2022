
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class Drivetrain extends SubsystemBase
{
  //SPARK MAX LEFT MOTORS
  public final WPI_TalonSRX LEFT_M_ONE;
  
  //SPARK MAX RIGHT MOTOR
  public final WPI_TalonSRX RIGHT_M_ONE;

  //SPEED CONTROLLER GROUPS
  public final MotorControllerGroup LEFT_M_GROUP;
  public final MotorControllerGroup RIGHT_M_GROUP;

  //DIFFERENTIAL DRIVE
  public final DifferentialDrive DIFF_DRIVE;

  //VARIABLE RPM ELECTRO-SHIFT
  public int shiftStatus;
  public double rPMCoefficient;

  //NAVX MXP GYRO
  private final Pigeon2 gyro;

  //DRIVETRAIN CONSTRUCTOR
  public Drivetrain() 
  {
    //SPARK MAX LEFT MOTORS
    this.LEFT_M_ONE = new WPI_TalonSRX(Robot.ROBOTMAP.getLeftMotorPortOne());
    
    //SPARK MAX RIGHT MOTORS
    this.RIGHT_M_ONE = new WPI_TalonSRX(Robot.ROBOTMAP.getRightMotorPortOne());

    //SPEED CONTROLLER GROUPS
    this.LEFT_M_GROUP = new MotorControllerGroup(this.LEFT_M_ONE);
    this.RIGHT_M_GROUP = new MotorControllerGroup(this.RIGHT_M_ONE);

    //DIFFERENTIAL DRIVE
    this.DIFF_DRIVE = new DifferentialDrive(this.LEFT_M_GROUP, this.RIGHT_M_GROUP);

    //NAVX MXP GYRO
    this.gyro = new Pigeon2(5);

    //VARIABLE RPM ELECTRO-SHIFT
    this.shiftStatus = 1;
    this.rPMCoefficient = 1.75;
  }

  //DRIVING METHOD
  public void arcadeDrive(Joystick stick) 
  {
    this.DIFF_DRIVE.arcadeDrive(stick.getY() / this.rPMCoefficient, -stick.getTwist(), false);
  }

  //SHIFTING METHOD
  public void shiftGear() 
  {
    if (this.shiftStatus == 1) 
    {
      this.shiftStatus = 2;
      this.rPMCoefficient = 1.5;
    } 
    else if (this.shiftStatus == 2)
    {
      this.shiftStatus = 3;
      this.rPMCoefficient = 1;
    }
    else if (this.shiftStatus == 3)
    {
      this.shiftStatus = 1;
      this.rPMCoefficient = 1.75;
    }
  }

  //MOVING STRAIGHT USING THE GYRO METHOD
  public void gyroMoveStraight(double speed)
  {
    this.DIFF_DRIVE.arcadeDrive(speed, -this.gyro.getYaw());
  }

  //MOVING STRAIGHT USING GYRO AND ANGLE VALUE METHOD
  public void gyroMoveStraight(double speed, double angle)
  {
    this.DIFF_DRIVE.arcadeDrive(-speed, -angle);
  }

  //ROTATE ROBOT
  public void rotate(double speed)
  {
    this.LEFT_M_GROUP.set(speed);
    this.RIGHT_M_GROUP.set(speed);
  }

  //STOP ROBOT
  public void stop()
  {
    rotate(0);
  }

  //CONVERT AN INT SPEED INTO A DECIMAL SPEED
  public double decimalSpeed(double speed)
  {
    return ((int)(((speed + 350) / 700.0) * 100) / 100.0);
  }

  public void configureMotors() {
    this.LEFT_M_ONE.configFactoryDefault();
    this.RIGHT_M_ONE.configFactoryDefault();

    this.LEFT_M_ONE.setNeutralMode(NeutralMode.Coast);
    this.RIGHT_M_ONE.setNeutralMode(NeutralMode.Coast);
  }


  public Pigeon2 getGyro()
  {
    return this.gyro;
  }

  public void resetGyro() 
  {
    this.gyro.setYaw(0);
    System.out.println("RESET GYROOOOOO");
  }

  @Override
  public void periodic() {
    // SmartDashboard.putNumber("Yaw", getGyro().getYaw());
    // NetworkTableEntry entry = Shuffleboard.getTab("SmartDashboard")
    //   .add("Yaw", gyro.getYaw())
    //   .getEntry();
    // Shuffleboard.update();
    //System.out.println(gyro.getYaw());
  }

}