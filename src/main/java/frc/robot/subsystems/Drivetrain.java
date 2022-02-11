
package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Robot;


public class Drivetrain extends SubsystemBase
{
  //SPARK MAX LEFT MOTORS
  public final CANSparkMax LEFT_M_ONE;
  public final CANSparkMax LEFT_M_TWO;
  public final CANSparkMax LEFT_M_THREE;
  
  //SPARK MAX RIGHT MOTOR
  public final CANSparkMax RIGHT_M_ONE;
  public final CANSparkMax RIGHT_M_TWO;
  public final CANSparkMax RIGHT_M_THREE;


  //SPEED CONTROLLER GROUPS
  public final MotorControllerGroup LEFT_M_GROUP;
  public final MotorControllerGroup RIGHT_M_GROUP;

  //DIFFERENTIAL DRIVE
  public final DifferentialDrive DIFF_DRIVE;

  //VARIABLE RPM ELECTRO-SHIFT
  public int shiftStatus;
  public double rPMCoefficient;

  //NAVX MXP GYRO
  private final AHRS GYRO;
  private final double KP_GYRO;

  //DRIVETRAIN CONSTRUCTOR
  public Drivetrain() 
  {
    //SPARK MAX LEFT MOTORS
    this.LEFT_M_ONE = new CANSparkMax(Robot.ROBOTMAP.LeftMotorPortOne, MotorType.kBrushless);
    this.LEFT_M_TWO = new CANSparkMax(Robot.ROBOTMAP.LeftMotorPortTwo, MotorType.kBrushless);
    this.LEFT_M_THREE = new CANSparkMax(Robot.ROBOTMAP.LeftMotorPortThree, MotorType.kBrushless);
    
    //SPARK MAX RIGHT MOTORS
    this.RIGHT_M_ONE = new CANSparkMax(Robot.ROBOTMAP.RightMotorPortOne, MotorType.kBrushless);
    this.RIGHT_M_TWO = new CANSparkMax(Robot.ROBOTMAP.RightMotorPortTwo, MotorType.kBrushless);
    this.RIGHT_M_THREE = new CANSparkMax(Robot.ROBOTMAP.RightMotorPortThree, MotorType.kBrushless);


    //SPEED CONTROLLER GROUPS
    this.LEFT_M_GROUP = new MotorControllerGroup(this.LEFT_M_ONE, this.LEFT_M_TWO, this.LEFT_M_THREE);
    this.RIGHT_M_GROUP = new MotorControllerGroup(this.RIGHT_M_ONE, this.RIGHT_M_TWO, this.RIGHT_M_THREE);

    //DIFFERENTIAL DRIVE
    this.DIFF_DRIVE = new DifferentialDrive(this.LEFT_M_GROUP, this.RIGHT_M_GROUP);

    //NAVX MXP GYRO
    this.GYRO = new AHRS(SPI.Port.kMXP);
    this.KP_GYRO = Robot.ROBOTMAP.getKPGyro();

    //VARIABLE RPM ELECTRO-SHIFT
    this.shiftStatus = 1;
    this.rPMCoefficient = 1.75;

    this.LEFT_M_ONE.setInverted(true);
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
    this.DIFF_DRIVE.arcadeDrive(speed, -this.GYRO.getAngle() * this.KP_GYRO);
  }

  //MOVING STRAIGHT USING GYRO AND ANGLE VALUE METHOD
  public void gyroMoveStraight(double speed, double angle)
  {
    this.DIFF_DRIVE.arcadeDrive(-speed, -angle * this.KP_GYRO);
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
    this.LEFT_M_ONE.restoreFactoryDefaults();
    this.LEFT_M_TWO.restoreFactoryDefaults();
    this.LEFT_M_THREE.restoreFactoryDefaults();
    this.RIGHT_M_ONE.restoreFactoryDefaults();
    this.RIGHT_M_TWO.restoreFactoryDefaults();
    this.RIGHT_M_THREE.restoreFactoryDefaults();

    this.LEFT_M_ONE.setIdleMode(IdleMode.kBrake);
    this.LEFT_M_TWO.setIdleMode(IdleMode.kCoast);
    this.LEFT_M_THREE.setIdleMode(IdleMode.kCoast);
    this.RIGHT_M_ONE.setIdleMode(IdleMode.kBrake);
    this.RIGHT_M_TWO.setIdleMode(IdleMode.kCoast);
    this.RIGHT_M_THREE.setIdleMode(IdleMode.kCoast);

  }


  public AHRS getGyro()
  {
    return this.GYRO;
  }

  public double getGyroAngle() 
  {
    return this.GYRO.getAngle(); 
  }

  public double getGyroAxis() 
  {
    return this.GYRO.getBoardYawAxis().board_axis.getValue();
  }

  public void resetGyro() 
  {
    this.GYRO.reset();
    this.GYRO.zeroYaw();
  }
}