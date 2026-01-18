package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.RollerState;

public class IntakeRollerSubsystem extends SubsystemBase{
    private final SparkFlex intakeMotor;
    private final SparkFlexConfig intakeConfig;

    public IntakeRollerSubsystem(){
        intakeMotor = new SparkFlex(IntakeConstants.kROLLER_MOTOR_ID, MotorType.kBrushless);
        intakeConfig = new SparkFlexConfig();

        intakeConfig
        .inverted(true)
        .idleMode(IdleMode.kBrake)
        .smartCurrentLimit(70); //不確定多少

        intakeMotor.configure(intakeConfig, com.revrobotics.ResetMode.kResetSafeParameters, com.revrobotics.PersistMode.kPersistParameters);
    }

    public void setRollerAction(RollerState state){
        intakeMotor.set(state.state);
    }

    @Override
    public void periodic(){
        //null
    }
}
