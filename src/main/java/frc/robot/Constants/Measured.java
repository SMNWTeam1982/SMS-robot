package frc.robot.Constants;

import edu.wpi.first.math.geometry.Rotation2d;

public class Measured {
    public static final class ArmMeasured {
        public static final double encorderToArmRatio = 1.0;

        public static final Rotation2d L1 = Rotation2d.fromDegrees(25);
        public static final Rotation2d L2 = Rotation2d.fromDegrees(45);
        public static final Rotation2d L3 = Rotation2d.fromDegrees(70);
        public static final Rotation2d Stow = Rotation2d.fromDegrees(0);

        public static final Rotation2d offset = Rotation2d.fromDegrees(-50);
        public static final double encoder_Roations_To_Arm_Rotations_Multiplier = 50 / .638;
    }
}