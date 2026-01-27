package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.FeedbackSensor;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SafetyConstants;
import frc.robot.Constants.SafetyConstants.*;

public class IntakeSafetySubsystem extends SubsystemBase{
    private final SparkMax angleMotor = new SparkMax(SafetyConstants.kEXTEND_MOTOR_ID, MotorType.kBrushless);
    private final SparkMaxConfig angleConfig = new SparkMaxConfig();
    
    private final RelativeEncoder angleRelativeEncoder = angleMotor.getEncoder();
    private final AbsoluteEncoder angleAbsoluteEncoder = angleMotor.getAbsoluteEncoder();
    private final SparkClosedLoopController anglePIDcontroller = angleMotor.getClosedLoopController();

    public IntakeSafetySubsystem(){

        angleRelativeEncoder.setPosition(angleAbsoluteEncoder.getPosition());
        
        angleConfig.softLimit
        .forwardSoftLimitEnabled(true)
        .reverseSoftLimitEnabled(true)
        .forwardSoftLimit(SafetyConstants.kEXTEND_FOWARD_LIMIT)
        .reverseSoftLimit(SafetyConstants.kEXTEMD_REVERSE_LIMIT);

        angleConfig
        .inverted(false)//待測試
        .smartCurrentLimit(60)
        .idleMode(IdleMode.kBrake)
        .closedLoop
        .feedbackSensor(FeedbackSensor.kAbsoluteEncoder)
        .pid(SafetyConstants.kP, SafetyConstants.kI, SafetyConstants.kD)
        .maxOutput(SafetyConstants.kEXTEND_MAX_OUTPUT)
        .minOutput(SafetyConstants.kEXTEND_MIN_OUTPUT);

        angleMotor.configure(angleConfig, com.revrobotics.ResetMode.kResetSafeParameters, com.revrobotics.PersistMode.kPersistParameters);
    }

    public double getExtendPosition(){
        return angleAbsoluteEncoder.getPosition();
    }

    public void setExtendState(ExtendSafetyAction state){
        anglePIDcontroller.setSetpoint(state.state, ControlType.kPosition);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("ABS EncoderPOS", getExtendPosition());
    }

}
