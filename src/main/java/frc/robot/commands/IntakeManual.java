package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants.ExtendManualAction;
import frc.robot.subsystems.IntakeExtendSubsystem;

public class IntakeManual extends Command{
    private IntakeExtendSubsystem intakeExtendSubsystem;
    private ExtendManualAction extendManualAction;

    public IntakeManual(IntakeExtendSubsystem intakeExtendSubsystem,ExtendManualAction extendManualAction){
        this.intakeExtendSubsystem = intakeExtendSubsystem;
        this.extendManualAction = extendManualAction;

        addRequirements(intakeExtendSubsystem);
    }


@Override
public void initialize(){
    intakeExtendSubsystem.setExtendAction(extendManualAction);
}

@Override
public void execute(){
}

@Override
public void end(boolean isInterrupted){
    intakeExtendSubsystem.setExtendAction(ExtendManualAction.kStop);
}

@Override
public boolean isFinished(){
    return false;
}
}
