package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants.ExtendAutoAction;
import frc.robot.Constants.IntakeConstants.RollerState;
import frc.robot.subsystems.IntakeExtendSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;

public class IntakeSafety extends Command {
    private IntakeExtendSubsystem intakeExtendSubsystem;
    private IntakeRollerSubsystem intakeRollerSubsystem;
    private boolean safe = true;

    public IntakeSafety(IntakeExtendSubsystem intakeExtendSubsystem, IntakeRollerSubsystem intakeRollerSubsystem) {
        this.intakeExtendSubsystem = intakeExtendSubsystem;
        this.intakeRollerSubsystem = intakeRollerSubsystem;
        addRequirements(intakeExtendSubsystem, intakeRollerSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        safe = SmartDashboard.getBoolean("safe", safe);
        if (safe == false) {
            intakeExtendSubsystem.setExtendState(ExtendAutoAction.kDefault);
            intakeRollerSubsystem.setRollerAction(RollerState.kStop);
        }
    }

    @Override
    public void end(boolean interrupted) {
        intakeExtendSubsystem.setExtendState(ExtendAutoAction.kDefault);
        intakeRollerSubsystem.setRollerAction(RollerState.kStop);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
