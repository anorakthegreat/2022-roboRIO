// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCNEO;


public class Drivetrain extends SubsystemBase {
    private FRCNEO leftMaster, leftFollower, rightMaster, rightFollower;
    /** Creates a new Drivetrain. */
    public Drivetrain() {
        leftMaster = new FRCNEO.FRCNEOBuilder(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KF)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.PEAK_OUTPUT_REVERSE).build();

        leftFollower = new FRCNEO.FRCNEOBuilder(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KF)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.PEAK_OUTPUT_REVERSE)
            .withMaster(leftMaster).build();

        rightMaster = new FRCNEO.FRCNEOBuilder(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KF)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.PEAK_OUTPUT_REVERSE).build();

        rightFollower = new FRCNEO.FRCNEOBuilder(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KF)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.PEAK_OUTPUT_REVERSE)
            .withMaster(rightMaster).build();

        addChild("drivetrainLeftMaster", leftMaster);
        addChild("drivetrainRightMaster", rightMaster);
        addChild("drivetrainLeftFollower", leftFollower);
        addChild("drivetrainRightFollower", rightFollower);
    }

    public void set(double left, double right) {
        this.leftMaster.drivePercentOutput(left);
        this.rightMaster.drivePercentOutput(right);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
