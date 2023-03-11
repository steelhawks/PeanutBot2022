package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class SolenoidTesting extends SubsystemBase {

  private final PneumaticsModuleType type = PneumaticsModuleType.REVPH;

  public DoubleSolenoid solenoidOne;
  public DoubleSolenoid solenoidTwo;
  public DoubleSolenoid solenoidThree;
  public DoubleSolenoid solenoidFour;

  public DigitalInput triggerHit;

  public Button releasePiston;

  public SolenoidTesting(){
      this.solenoidOne = new DoubleSolenoid(type, 0, 1);
      this.solenoidTwo = new DoubleSolenoid(type, 2, 3);
      this.solenoidThree = new DoubleSolenoid(type, 4, 5);
      this.solenoidFour = new DoubleSolenoid(type, 6, 7);

      this.triggerHit = new DigitalInput(Robot.ROBOTMAP.LIMIT_SWITCH_ONE_PORT);

      this.releasePiston = new JoystickButton(Robot.COMMAND_LINKER.DRIVE_JOYSTICK, Robot.ROBOTMAP.RELEASE_SWITCH_BUTTON);
  }

  public void toggleSolenoid() {
      if (this.solenoidOne.get().equals(DoubleSolenoid.Value.kForward)) {
          retractSolenoid();
      } else {
          extendSolenoid();
      }
    }
  
  public void extendSolenoid() {
    this.solenoidOne.set(DoubleSolenoid.Value.kForward);
    this.solenoidTwo.set(DoubleSolenoid.Value.kForward);
    this.solenoidThree.set(DoubleSolenoid.Value.kForward);
    this.solenoidFour.set(DoubleSolenoid.Value.kForward);
  }

  public void retractSolenoid() {
    this.solenoidOne.set(DoubleSolenoid.Value.kReverse);
    this.solenoidTwo.set(DoubleSolenoid.Value.kReverse);
    this.solenoidThree.set(DoubleSolenoid.Value.kReverse);
    this.solenoidFour.set(DoubleSolenoid.Value.kReverse);
  }

  public void toggleSolOne() {
    if (this.solenoidOne.get().equals(DoubleSolenoid.Value.kForward)) {
      this.solenoidOne.set(DoubleSolenoid.Value.kReverse);
    } else {
      this.solenoidOne.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void toggleSolTwo() {
    if (this.solenoidTwo.get().equals(DoubleSolenoid.Value.kForward)) {
      this.solenoidTwo.set(DoubleSolenoid.Value.kReverse);
    } else {
      this.solenoidTwo.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void toggleSolThree() {
    if (this.solenoidThree.get().equals(DoubleSolenoid.Value.kForward)) {
      this.solenoidThree.set(DoubleSolenoid.Value.kReverse);
    } else {
      this.solenoidThree.set(DoubleSolenoid.Value.kForward);
    }
  }

  // public void triggerPistonIfHit() {
  //   if(releasePiston.get()) {
  //     retractSolenoid();
  //   } else if (!triggerHit.get()) {
  //     System.out.println("Limit Switch Hit");
  //     extendSolenoid();
  //   }
  // }

}
