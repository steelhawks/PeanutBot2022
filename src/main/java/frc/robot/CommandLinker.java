package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.button.ButtonTest;
import frc.robot.commands.intake.ExtendSolenoid;

import frc.robot.commands.intake.RetractSolenoid;
import frc.robot.commands.intake.ToggleSolenoid;
import frc.robot.commands.talons.*;


public class CommandLinker 
{
  /*****
   * Joystick Objects
   *****/
  public final Joystick DRIVE_JOYSTICK = new Joystick(Robot.ROBOTMAP.getJoystickPortOne());

  public CommandLinker() 
  {
    //configureCommands();
  }

  public void configureRegisteredSubsystems() {
    CommandScheduler.getInstance().registerSubsystem(Robot.SOLENOID_TESTING);
    CommandScheduler.getInstance().registerSubsystem(Robot.BUTTON_TESTING);
    CommandScheduler.getInstance().registerSubsystem(Robot.MOTOR_TESTING);
  }

  public void configureCommands()
  {
    Button one = new JoystickButton(this.DRIVE_JOYSTICK, 1);
    Button two = new JoystickButton(this.DRIVE_JOYSTICK, 2);
    Button three = new JoystickButton(this.DRIVE_JOYSTICK, 3);
    Button four = new JoystickButton(this.DRIVE_JOYSTICK, 4);
    Button five = new JoystickButton(this.DRIVE_JOYSTICK, 5);
    Button six = new JoystickButton(this.DRIVE_JOYSTICK, 6);
    Button seven = new JoystickButton(this.DRIVE_JOYSTICK, 7);
    Button eight = new JoystickButton(this.DRIVE_JOYSTICK, 8);
    Button nine = new JoystickButton(this.DRIVE_JOYSTICK, 9);
    Button ten = new JoystickButton(this.DRIVE_JOYSTICK, 10);
    Button eleven = new JoystickButton(this.DRIVE_JOYSTICK, 11);
    Button twelve = new JoystickButton(this.DRIVE_JOYSTICK, 12);

    one.whileHeld(new ButtonTest(1));
    two.whileHeld(new ButtonTest(2));
    three.whileHeld(new ButtonTest(3));
    four.whileHeld(new ButtonTest(4));
    five.whileHeld(new ButtonTest(5));
    six.whileHeld(new ButtonTest(6));
    seven.whileHeld(new ButtonTest(7));
    eight.whileHeld(new ButtonTest(8));
    nine.whileHeld(new ButtonTest(9));
    ten.whileHeld(new ButtonTest(10));
    eleven.whileHeld(new ButtonTest(11));
    twelve.whileHeld(new ButtonTest(12));
   
    //Talons
    Button LEFT_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 5);
    Button REVERSE_LEFT_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 3);
    Button RIGHT_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 6);
    Button REVERSE_RIGHT_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 4);
    Button ALL_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 1);
    Button REVERSE_ALL_BUTTON = new JoystickButton(this.DRIVE_JOYSTICK, 2);

    LEFT_BUTTON.whileHeld(new Right());
    REVERSE_LEFT_BUTTON.whileHeld(new RightReverse());
    RIGHT_BUTTON.whileHeld(new Left());
    REVERSE_RIGHT_BUTTON.whileHeld(new LeftReverse());
    ALL_BUTTON.whileHeld(new All());
    REVERSE_ALL_BUTTON.whileHeld(new AllReverse());

    //Solenoids
    Button TOGGLE_SOLENOID = new JoystickButton(this.DRIVE_JOYSTICK, 10);
    Button EXTEND_SOLENOID = new JoystickButton(this.DRIVE_JOYSTICK, 11);
    Button RETRACT_SOLENOID = new JoystickButton(this.DRIVE_JOYSTICK, 12);

    TOGGLE_SOLENOID.whenPressed(new ToggleSolenoid());
    EXTEND_SOLENOID.whenPressed(new ExtendSolenoid());
    RETRACT_SOLENOID.whenPressed(new RetractSolenoid());
  }
}
