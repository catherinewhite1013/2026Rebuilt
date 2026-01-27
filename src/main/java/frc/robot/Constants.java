package frc.robot;


public class Constants {
    public static class IntakeConstants {
        public static final int kEXTEND_MOTOR_ID = 1;
        public static final int kROLLER_MOTOR_ID = 2;

        public static final double kEXTEND_FOWARD_LIMIT = 0.0;
        public static final double kEXTEMD_REVERSE_LIMIT = 0.0;

        public static final double kP = 0;   //待測試
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double kIZ = 0.0;
        public static final double kEXTEND_MAX_OUTPUT = 0.4;
        public static final double kEXTEND_MIN_OUTPUT = -0.4;

        

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
            kDefault(0),     //待測試
            kGetBall(0);

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

    public static class SafetyConstants {
        public static final int kEXTEND_MOTOR_ID = 0;

        public static final double kP = 0.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double kEXTEND_MAX_OUTPUT = 0.4;
        public static final double kEXTEND_MIN_OUTPUT = -0.4;
        public static final double kEXTEND_FOWARD_LIMIT = 0.0;
        public static final double kEXTEMD_REVERSE_LIMIT = 0.0;

        public enum ExtendSafetyAction {
            kDefault(0),     //待測試
            kGetBall(0);

            public final double state;

            private ExtendSafetyAction(double state) {
                this.state = state;
            }
        }
        
    }
}
