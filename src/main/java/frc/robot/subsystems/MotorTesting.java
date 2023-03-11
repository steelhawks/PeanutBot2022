package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class MotorTesting extends SubsystemBase {

    WPI_TalonSRX TALON_ONE;
    WPI_TalonSRX TALON_TWO;
    WPI_TalonSRX TALON_THREE;
    WPI_TalonSRX TALON_FOUR;
    VictorSPX VICTOR_ONE;

    public MotorTesting() {
        TALON_ONE = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonOneId());
        TALON_TWO = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonTwoId());
        TALON_THREE = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonThreeId());
        TALON_FOUR = new WPI_TalonSRX(Robot.ROBOTMAP.getTalonFourId());
        VICTOR_ONE = new VictorSPX(Robot.ROBOTMAP.getVictorOneId());

        configureMotors();
    }

    public void one(boolean isForward) {
        if(isForward) {
            TALON_ONE.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            TALON_ONE.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void two(boolean isForward) {
        if(isForward) {
            TALON_TWO.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            TALON_TWO.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void three(boolean isForward) {
        if(isForward) {
            TALON_THREE.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            TALON_THREE.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    } 

    public void four(boolean isForward) {
        if(isForward) {
            TALON_FOUR.set(Robot.ROBOTMAP.getMotorSpeed());
        } else {
            TALON_FOUR.set(-Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void five(boolean isForward) {
        if(isForward) {
            VICTOR_ONE.set(ControlMode.PercentOutput, Robot.ROBOTMAP.getMotorSpeed());
        } else {
            VICTOR_ONE.set(ControlMode.PercentOutput, -Robot.ROBOTMAP.getMotorSpeed());
        }
    }

    public void configureMotors() {
        TALON_ONE.configFactoryDefault();
        TALON_TWO.configFactoryDefault();
        TALON_THREE.configFactoryDefault();
        TALON_FOUR.configFactoryDefault();
        VICTOR_ONE.configFactoryDefault();

        TALON_ONE.setNeutralMode(NeutralMode.Coast);
        TALON_TWO.setNeutralMode(NeutralMode.Coast);
        TALON_THREE.setNeutralMode(NeutralMode.Coast);
        TALON_FOUR.setNeutralMode(NeutralMode.Coast);
        VICTOR_ONE.setNeutralMode(NeutralMode.Coast);
    }

    public void stop() {
        TALON_ONE.stopMotor();
        TALON_TWO.stopMotor();
        TALON_THREE.stopMotor();
        TALON_FOUR.stopMotor();
        VICTOR_ONE.set(ControlMode.PercentOutput, 0);
        
    }
}
