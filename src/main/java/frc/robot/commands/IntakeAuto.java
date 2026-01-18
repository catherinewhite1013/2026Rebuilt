package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeExtendSubsystem;
import frc.robot.subsystems.IntakeRollerSubsystem;
import frc.robot.Constants.IntakeConstants.ExtendAutoAction;
import frc.robot.Constants.IntakeConstants.ExtendManualAction;
import frc.robot.Constants.IntakeConstants.RollerState;

public class IntakeAuto extends Command {
    private IntakeExtendSubsystem intakeExtendSubsystem;
    private IntakeRollerSubsystem intakeRollerSubsystem;
    private ExtendAutoAction extendState;
    private RollerState rollerState;

    public IntakeAuto(IntakeExtendSubsystem intakeExtendSubsystem,
                      IntakeRollerSubsystem intakeRollerSubsystem,
                      ExtendAutoAction state,
                      RollerState rollerState){

        this.intakeExtendSubsystem = intakeExtendSubsystem;
        this.intakeRollerSubsystem = intakeRollerSubsystem;
        this.extendState = state;
        this.rollerState = rollerState;
        addRequirements(intakeExtendSubsystem, intakeRollerSubsystem);
    }

    @Override
    public void initialize() {
        intakeExtendSubsystem.setExtendState(extendState);
        intakeRollerSubsystem.setRollerAction(rollerState);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean isInterrupted) {
        intakeExtendSubsystem.setExtendAction(ExtendManualAction.kStop);
        intakeRollerSubsystem.setRollerAction(RollerState.kStop);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
