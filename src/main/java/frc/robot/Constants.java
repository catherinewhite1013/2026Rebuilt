package frc.robot;

import java.security.PublicKey;
import java.security.cert.PKIXCertPathBuilderResult;

public class Constants {
    public static class IntakeConstants {
        public static final int kEXTEND_MOTOR_ID = ;
        public static final int kROLLER_MOTOR_ID = ;

        public static final double kEXTEND_FOWARD_LIMIT = ;
        public static final double kEXTEMD_REVERSE_LIMIT = ;

        public static final double kP = ;   //待測試(SYSId?)
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kIZ = 0;
        public static final double kEXTEND_MAX_OUTPUT = 0.5;
        public static final double kEXTEND_MIN_OUTPUT = -0.5;

        public static final double kINTAKE_GEAR_RATIO = ;

        public enum ExtendManualAction {
            kUP(0.4),
            kDown(-0.4),
            kStop(0);

            public final double rate;

            private ExtendManualAction(double rate) {
                this.rate = rate;
            }
        }

        public enum ExtendAutoAction {
            kDefault(),     //待測試
            kGetBall();

            public final double state;

            private ExtendAutoAction(double state) {
                this.state = state;
            }
        }

        public enum RollerState{
            kGet(0.5),
            kStop(0),
            kSpit(-0.5);

            public final double state;

            private RollerState(double state){
                this.state = state;
            }
        }
        
    }
}
