// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCTalonFX;


public class Drivetrain extends SubsystemBase {
    private FRCTalonFX leftMaster, leftFollower, rightMaster, rightFollower;
    private DigitalInput sensorLeft, sensorRight;
    private double leftSetpoint, rightSetpoint;
    
    /** Creates a new Drivetrain. */
    public Drivetrain() {
        sensorLeft = new DigitalInput(Constants.DrivetrainConstants.DrivetrainSensors.LeftSensor.ID);
        sensorRight = new DigitalInput(Constants.DrivetrainConstants.DrivetrainSensors.RightSensor.ID);

        leftMaster = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.KF)
            .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.INVERTED)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.NEUTRAL_MODE).build();

        leftFollower = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.KF)
            .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.INVERTED)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.LeftFollower.NEUTRAL_MODE)
            .withMaster(leftMaster).build();

        rightMaster = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.KF)
            .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.INVERTED)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.RightMaster.NEUTRAL_MODE).build();

        rightFollower = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.CAN_ID)
            .withKP(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KP)
            .withKI(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KI)
            .withKD(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KD)
            .withKF(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.KF)
            .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.INVERTED)
            .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.SENSOR_PHASE)
            .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.RightFollower.NEUTRAL_MODE)
            .withMaster(rightMaster).build();

        addChild("drivetrainLeftMaster", leftMaster);
        addChild("drivetrainRightMaster", rightMaster);
        addChild("drivetrainLeftFollower", leftFollower);
        addChild("drivetrainRightFollower", rightFollower);
    }

    public void driveWithoutRamp(double left, double right) {
        this.leftMaster.drivePercentOutput(left);
        this.rightMaster.drivePercentOutput(right);
        this.leftSetpoint = left;
        this.rightSetpoint = right;
    }

    public void driveWithRamp(double left, double right) {
        double rampLeft = ramp(left, leftSetpoint);
        double rampRight = ramp(right, rightSetpoint);

        this.leftMaster.drivePercentOutput(rampLeft);
        this.rightMaster.drivePercentOutput(rampRight);
        this.leftSetpoint = rampLeft;
        this.rightSetpoint = rampRight;
    }

    private double ramp(double input, double currentSpeed) {
        double dv = input - currentSpeed;
        if (dv > 0) {
            // forwards, speeding up
            if (dv > Constants.DrivetrainConstants.DrivetrainControls.RAMP_LIMIT) {
                return currentSpeed + Constants.DrivetrainConstants.DrivetrainControls.RAMP_LIMIT;
            }
        } else if (dv < 0) {
            // forwards, slowing down
            if (dv < -Constants.DrivetrainConstants.DrivetrainControls.RAMP_LIMIT) {
                return currentSpeed - Constants.DrivetrainConstants.DrivetrainControls.RAMP_LIMIT;
            }
        }
        return input;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        SmartDashboard.putBoolean("allign sensor left", getSensorLeft());
        SmartDashboard.putBoolean("allign sensor right", getSensorRight());
    }

    public boolean getSensorLeft() {
        return sensorLeft.get();
      }
    
      public boolean getSensorRight() {
        return sensorRight.get();
      }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
