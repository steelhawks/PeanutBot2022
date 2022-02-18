/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap 
{
  /*****
   * Drivetrain instance variables
   *****/

  //Motor IDs
  private final int TALON_ID_TWO = 2;
  private final int TALON_ID_FOURTEEN = 14;
  private final int TALON_ID_SIX = 6; 
  private final int TALON_ID_THREE = 3;

  //Motor Speed
  private final double motorSpeed = 1;
  
  //Joystick Port
  private final int JOYSTICK_PORT_ONE = 0; 

  /*****
   * Constructor methods
   *****/
  public RobotMap() {}

  /*****
   * Getter methods
   *****/
  public int getJoystickPortOne() {
    return this.JOYSTICK_PORT_ONE;
  }

  public int getTalonIdTwo() {
    return this.TALON_ID_TWO;
  }

  public int getTalonIdFourteen() {
    return this.TALON_ID_FOURTEEN;
  }

  public int getTalonIdSix() {
    return this.TALON_ID_SIX;
  }

  public int getTalonIdThree() {
    return this.TALON_ID_THREE;
  }

  public double getMotorSpeed() {
    return this.motorSpeed;
  }
}
