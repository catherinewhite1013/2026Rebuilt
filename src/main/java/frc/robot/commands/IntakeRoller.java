package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants.RollerState;
import frc.robot.subsystems.IntakeRollerSubsystem;

public class IntakeRoller extends Command{
    private IntakeRollerSubsystem intakeRollerSubsystem;

    public IntakeRoller(IntakeRollerSubsystem intakeRollerSubsystem){
        this.intakeRollerSubsystem = intakeRollerSubsystem;

        addRequirements(intakeRollerSubsystem);
    }

@Override
public void initialize(){
    intakeRollerSubsystem.setRollerAction(RollerState.kGet);
}

@Override
public void execute(){
}

@Override
public void end(boolean isInterrupted){
    intakeRollerSubsystem.setRollerAction(RollerState.kStop);
}

@Override
public boolean isFinished(){
    return false;
}
}
