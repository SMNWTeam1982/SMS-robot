package frc.robot.Subsystems.Drive;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANBUS;
import frc.robot.Constants.CANBUS.DriveIDs;
import frc.robot.Constants.Tunables.driveTunables;

public class TankDrive extends SubsystemBase {
    private final TalonSRX leftLead = new TalonSRX(CANBUS.DriveIDs.LEFT_LEAD_ID);
    private final TalonSRX leftFollower = new TalonSRX(CANBUS.DriveIDs.LEFT_FOLLOWER_ID);
    private final TalonSRX rightLead = new TalonSRX(CANBUS.DriveIDs.RIGHT_LEAD_ID);
    private final TalonSRX rightFollower = new TalonSRX(CANBUS.DriveIDs.RIGHT_FOLLOWER_ID);

    private final DifferentialDrive tankDrive = new DifferentialDrive(
    new WPI_TalonSRX(DriveIDs.LEFT_LEAD_ID), new WPI_TalonSRX(DriveIDs.RIGHT_LEAD_ID)
        );
    public void addFollower() {
        leftFollower.follow(leftLead);
        rightFollower.follow(rightLead);
    }

     public Command drive(Supplier<ChassisSpeeds> speeds) {
        return run(
        () -> {
        DifferentialDriveWheelSpeeds wheelSpeeds = driveTunables.driveTrainKinematics.toWheelSpeeds(speeds.get());
        tankDrive.tankDrive(wheelSpeeds.leftMetersPerSecond, wheelSpeeds.rightMetersPerSecond);
    });
}

    public void drive(double leftSpeed, double rightSpeed) {
        tankDrive.tankDrive(leftSpeed, rightSpeed);
    }

    public Command driveCommand(DoubleSupplier forward, DoubleSupplier rotation) {  
        return run(
        () -> {
        tankDrive.tankDrive(forward.getAsDouble(), 
        rotation.getAsDouble());
        }
        ); 
   
    }



    public Command stop() {
        return runOnce(() -> tankDrive.stopMotor()
        );
    }














    
}
