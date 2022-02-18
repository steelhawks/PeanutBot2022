package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class MotorTesting extends SubsystemBase {

    WPI_TalonSRX two;
    WPI_TalonSRX fourteen;
    WPI_TalonSRX six;
    WPI_TalonSRX three;

    public MotorTesting() {
        two = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonIdTwo());
        fourteen = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonIdFourteen());
        six = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonIdSix());
        three = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonIdThree());

        configureMotors();
    }

    public void two(boolean isForward) {
        if(isForward) {
            two.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            two.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void fourteen(boolean isForward) {
        if(isForward) {
            fourteen.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            fourteen.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void six(boolean isForward) {
        if(isForward) {
            six.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            six.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    } 

    public void three(boolean isForward) {
        if(isForward) {
            three.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            three.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void configureMotors() {
        two.configFactoryDefault();
        fourteen.configFactoryDefault();
        six.configFactoryDefault();
        three.configFactoryDefault();

        two.setNeutralMode(NeutralMode.Coast);
        fourteen.setNeutralMode(NeutralMode.Coast);
        six.setNeutralMode(NeutralMode.Coast);
        three.setNeutralMode(NeutralMode.Coast);
    }

    public void stop() {
        two.stopMotor();
        fourteen.stopMotor();
        six.stopMotor();
        three.stopMotor();
    }
}
