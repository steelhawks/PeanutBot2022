package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import java.lang.Math;

public class EncoderTesting extends SubsystemBase {

    WPI_TalonFX TALON_ONE;
    WPI_TalonFX TALON_TWO;
    WPI_TalonFX TALON_THREE;

    private final double gearRatio = ((50/12)*(50/34));

    public EncoderTesting() {
        TALON_ONE = new WPI_TalonFX(1);
        TALON_TWO = new WPI_TalonFX(2);
        TALON_THREE = new WPI_TalonFX(3);
        TALON_ONE.getSensorCollection().setIntegratedSensorPosition(0, 0);

        configureMotors();
    }

    public void move() {
        TALON_ONE.set(0.05);
        TALON_TWO.set(0.05);
        TALON_THREE.set(0.05);
    }

    private double getRotations() {
        return getEncoderVal() / 2048;
    }

    private double getEncoderVal() {
        return TALON_ONE.getSensorCollection().getIntegratedSensorPosition();
    }

    private void configureMotors() {
        TALON_ONE.configFactoryDefault();
        TALON_TWO.configFactoryDefault();
        TALON_THREE.configFactoryDefault();

        TALON_ONE.setNeutralMode(NeutralMode.Brake);
        TALON_TWO.setNeutralMode(NeutralMode.Brake);
        TALON_THREE.setNeutralMode(NeutralMode.Brake);
    }

    public void resetEncoder() {
        TALON_ONE.getSensorCollection().setIntegratedSensorPosition(0, 0);
    }

    public double calculateRotationsGB() {
        return getRotations() * gearRatio;// * Math.PI * 1/12;
    }

    public void shuffleBoard() {
        SmartDashboard.putNumber("encoder", getEncoderVal());
        SmartDashboard.putNumber("Rotations", getRotations());
        SmartDashboard.putNumber("rotations GB", calculateRotationsGB());
    }

    public void stop() {
        TALON_ONE.stopMotor();
        TALON_TWO.stopMotor();
        TALON_THREE.stopMotor();
    }
}

