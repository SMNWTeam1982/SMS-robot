package frc.robot.Subsystems.Intake;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANBUS;
import frc.robot.Constants.Tunables;

public class Intake extends SubsystemBase{
    private final TalonSRX intakeMotor = new TalonSRX(CANBUS.intakIds.INTAKE_MOTOR_ID);

    public Intake() {
        intakeMotor.configFactoryDefault();
    }

    public Command runIntake() {
        return runOnce(() -> intakeMotor.set(TalonSRXControlMode.PercentOutput, Tunables.intakeTunables.INTAKE_SPEED));
    }

    public Command runOuttake() {
        return runOnce(() -> intakeMotor.set(TalonSRXControlMode.PercentOutput, Tunables.intakeTunables.OUTTAKE_SPEED));
    }

    public Command stopIntake() {
        return runOnce(() -> intakeMotor.set(TalonSRXControlMode.PercentOutput, 0));
    }
    
}
