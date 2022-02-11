package frc.robot.Util;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Util.*;
import frc.robot.commands.DiffDrive;

import java.util.function.Supplier;

public class FollowPath{

    Trajectory trajectory;
    Supplier<Pose2d> pose;
    RamseteController follower;
    DifferentialDriveKinematics kinematics;
    BiConsumer<Double, Double> outputMetersPerSecond;
    Subsystem requirements;

    double leftMotorSpeed = 0; //change to match drivetrain encoders, not constants
    double rightMotorSpeed = 0;//change to match drivetrain encoders, not constants
    
    public FollowPath(String path){
        this.trajectory = Robot.PATH_TRAJECTORY.generateTrajectoryfromToolJson(path);
        this.pose = () -> Robot.DRIVETRAIN.getGyroPosition();
        this.follower = new RamseteController();
        //this.kinematics = 
        this.outputMetersPerSecond = (leftMotorSpeed, rightMotorSpeed) -> new DiffDrive();
        this.requirements = Robot.DRIVETRAIN;

    }

    
}
