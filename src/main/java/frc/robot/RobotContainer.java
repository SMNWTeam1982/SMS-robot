// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Arm.Arm;
import frc.robot.Subsystems.Drive.Drive;
import frc.robot.Subsystems.Intake.Intake;


public class RobotContainer {

  private final CommandXboxController controller = new CommandXboxController(0);
  private final Intake intake = new Intake();
  private final Arm arm = new Arm();
  private final Drive driveTrain = new Drive();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    controller.y().debounce(0.1).whileTrue(intake.runIntake()).onFalse(intake.stopIntake());
    controller.a().debounce(0.1).whileTrue(intake.runOuttake()).onFalse(intake.stopIntake());

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
