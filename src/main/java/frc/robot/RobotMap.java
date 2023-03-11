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
  private final int TALON_ONE_ID = 16;
  private final int TALON_TWO_ID = 14;
  private final int TALON_THREE_ID = 12; 
  private final int TALON_FOUR_ID = 13;
  private final int VICTOR_ONE_ID = 1;

  //Motor Speed
  private final double motorSpeed = 0.3;
  
  //Joystick Port
  private final int JOYSTICK_PORT_ONE = 0;

  //Limit Switch Port
  public final int LIMIT_SWITCH_ONE_PORT = 9;

  public final int RELEASE_SWITCH_BUTTON = 7;

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

  public int getTalonOneId() {
    return this.TALON_ONE_ID;
  }

  public int getTalonTwoId() {
    return this.TALON_TWO_ID;
  }

  public int getTalonThreeId() {
    return this.TALON_THREE_ID;
  }

  public int getTalonFourId() {
    return this.TALON_FOUR_ID;
  }

  public double getMotorSpeed() {
    return this.motorSpeed;
  }

  public int getVictorOneId() {
    return this.VICTOR_ONE_ID;
  }

}
