package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.IntakeConstants.ExtendAutoAction;
import frc.robot.Constants.IntakeConstants.ExtendManualAction;

public class IntakeExtendSubsystem extends SubsystemBase {
    private SparkFlex angleMotor = new SparkFlex(IntakeConstants.kEXTEND_MOTOR_ID, MotorType.kBrushless);
    private SparkFlexConfig angleConfig = new SparkFlexConfig();
    
    private RelativeEncoder angleRelativeEncoder = angleMotor.getEncoder();
    private SparkClosedLoopController anglePIDcontroller = angleMotor.getClosedLoopController();

    public IntakeExtendSubsystem(){
        angleConfig.softLimit
        .forwardSoftLimitEnabled(true)
        .reverseSoftLimitEnabled(true)
        .forwardSoftLimit(IntakeConstants.kEXTEND_FOWARD_LIMIT)
        .reverseSoftLimit(IntakeConstants.kEXTEMD_REVERSE_LIMIT);

        angleConfig
        .inverted(false)    //待測試
        .idleMode(IdleMode.kBrake)
        .closedLoop
        .pid(IntakeConstants.kP, IntakeConstants.kI, IntakeConstants.kP)
        .iZone(IntakeConstants.kIZ)
        .maxOutput(IntakeConstants.kEXTEND_MAX_OUTPUT)
        .minOutput(IntakeConstants.kEXTEND_MIN_OUTPUT);

        angleMotor.configure(angleConfig, com.revrobotics.ResetMode.kResetSafeParameters, com.revrobotics.PersistMode.kPersistParameters);
    }

    public double getAnglePosition(){
        return angleRelativeEncoder.getPosition();
    }

    public void setExtendAction(ExtendManualAction action){
        angleMotor.set(action.rate);
    }

    public void setExtendState(ExtendAutoAction state){
        anglePIDcontroller.setSetpoint(state.state*IntakeConstants.kINTAKE_GEAR_RATIO, ControlType.kPosition);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("REL EncoderPOS", getAnglePosition());
    }
}
