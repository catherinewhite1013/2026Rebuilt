// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.IntakeConstants.ExtendManualAction;
import frc.robot.Constants.IntakeConstants.ExtendAutoAction;
import frc.robot.Constants.IntakeConstants.RollerState;
import frc.robot.commands.IntakeManual;
import frc.robot.commands.IntakeRoller;
import frc.robot.commands.IntakeAuto;
import frc.robot.subsystems.IntakeExtendSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;

public class RobotContainer {
  private final IntakeExtendSubsystem intakeExtendSubsystem = new IntakeExtendSubsystem();
  private final IntakeRollerSubsystem intakeRollerSubsystem = new IntakeRollerSubsystem();

  private static CommandXboxController m_operatorController = new CommandXboxController(1);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_operatorController.pov(0).whileTrue(new IntakeManual(intakeExtendSubsystem, ExtendManualAction.kUP));
    m_operatorController.pov(180).whileTrue(new IntakeManual(intakeExtendSubsystem, ExtendManualAction.kDown));
    m_operatorController.a().onTrue(new IntakeRoller(intakeRollerSubsystem)); //測試用
    m_operatorController.b().toggleOnTrue(new IntakeAuto(intakeExtendSubsystem, intakeRollerSubsystem, ExtendAutoAction.kGetBall, RollerState.kGet));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
