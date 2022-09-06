// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.SparkMaxAnalogSensor;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class AutonomousConstants {
        public static final class DipSwitches{
            public static final int FIRST_BALL_OPTION_ID = 3;
            public static final int SECOND_BALL_OPTION_ID = 4;
            public static final int YEET_OR_LEAVE = 5;
        }
    }
    public static final class DrivetrainConstants {
        public static final class Autonomous {
            public static final class Turning {
                public static final double TURN_SPEED = 0.25;
                public static final double TURN_ADJUSMENT =237;

                public static final int HHH_TURN = 80;
                // public static final int SECOND_HHH_TURN = -70;
                //public static final int SECOND_HHH_OFFSET = 46;
                public static final double TURNING_PP = 0.0006;
                public static final int SECOND_HHH_TURN = 42;
            }
            public static final class Distance {
                public static final int HIGH_GOAL_SHOT = -40000;
                public static final double FIRST_BALL_EXPECTED_STOP_FROM_TARMACK_EDGE = -60000;
                public static final double THIRD_BALL_OFFSET_FROM_SHOOT_POSITION = -85000;
            }
            public static final class Offsets {
                public static final int AUTO_H_H_OFFSET = 0;//-56000;
                public static final int AUTO_L_H_OFFSET = -41000;
                public static final int AUTO_LF_H_OFFSET = -40000;
                public static final double STEP_TWO_RETURN_OFFSET = -10000;
            }
            public static final class Speeds {
                public static final double DRIVE_REVERSE_SPEED = -0.16;
                public static final double DRIVE_FORWARD_SPEED = 0.16;
            }
        }
        public static final class DrivetrainMotion{
            public static final double ALIGN_SPEED = -0.1;
            public static final double SLOW_SPEED = 0.25;
        }
        public static final class DrivetrainSensors{
        }
        public static final class DrivetrainMotors {
            public static final class right {
                public static final int CAN_ID = 15; //18
                public static final double KP = 0;
                public static final double KI = 0;
                public static final double KD = 0;
                public static final double KF = 0;
                public static final InvertType INVERTED = InvertType.None;
                public static final boolean SENSOR_PHASE = false;
                public static final double PEAK_OUTPUT_FORWARD = 1;
                public static final double PEAK_OUTPUT_REVERSE = -1;
                // public static final double NOMINAL_OUTPUT_FORWARD = 0.05;
                // public static final double NOMINAL_OUTPUT_REVERSE = -0.05;
                public static final NeutralMode NEUTRAL_MODE = NeutralMode.Coast;
            }

            public static final class left {
                public static final int CAN_ID = 0; //19
                public static final double KP = 0;
                public static final double KI = 0;
                public static final double KD = 0;
                public static final double KF = 0;
                public static final InvertType INVERTED = InvertType.FollowMaster;
                public static final boolean SENSOR_PHASE = false;
                public static final double PEAK_OUTPUT_FORWARD = 1;
                public static final double PEAK_OUTPUT_REVERSE = -1;
                // public static final double NOMINAL_OUTPUT_FORWARD = 0.05;
                // public static final double NOMINAL_OUTPUT_REVERSE = -0.05;
                public static final NeutralMode NEUTRAL_MODE = NeutralMode.Coast;
            }




        }

    }
    
}
