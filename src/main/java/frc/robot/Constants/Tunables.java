package frc.robot.Constants;

import static edu.wpi.first.units.Units.Meters;

import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class Tunables {

    public static final class pivotTunables {
        public static final double PIVOT_ARM_UP_SPEED = .3;
        public static final double PIVOT_ARM_DOWN_SPEED = -.3;

        /** PID loop */
        public static final double PROPORTIONAL_GAIN = 0;

        public static final double INTEGERAL_GAIN = 0;
        public static final double DERIVATIVE_GAIN = 0;

        /** Feedforward */
        public static final double STATIC_GAIN = 0;

        public static final double GRAVITY_GAIN = 0;
        public static final double VELOCTIY_GAIN = 0;
        public static final double ACCELERATION_GAIN = 0;
    }

    public static final class intakeTunables {
        public static final double INTAKE_SPEED = 0.6;
        public static final double OUTTAKE_SPEED = -0.6;
    }

    public static final class driveTunables {
        public static final DifferentialDriveKinematics driveTrainKinematics =
                new DifferentialDriveKinematics(Meters.of(0.6));
    }

    public static final SparkBaseConfig DRIVE_MOTOR_CONFIG =
            new SparkMaxConfig().smartCurrentLimit(35).idleMode(SparkBaseConfig.IdleMode.kCoast);
}