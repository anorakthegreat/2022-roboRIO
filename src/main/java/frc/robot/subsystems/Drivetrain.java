// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCTalonFX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private FRCTalonFX left, right;


  public Drivetrain() {
    left = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.left.CAN_ID)
    .withKP(Constants.DrivetrainConstants.DrivetrainMotors.left.KP)
    .withKI(Constants.DrivetrainConstants.DrivetrainMotors.left.KI)
    .withKD(Constants.DrivetrainConstants.DrivetrainMotors.left.KD)
    .withKF(Constants.DrivetrainConstants.DrivetrainMotors.left.KF)
    .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.left.INVERTED)
    .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.left.SENSOR_PHASE)
    .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.left.PEAK_OUTPUT_FORWARD)
    .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.left.PEAK_OUTPUT_REVERSE)
    //.withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.NEUTRAL_MODE)
    .build();

    right = new FRCTalonFX.FRCTalonFXBuilder(Constants.DrivetrainConstants.DrivetrainMotors.right.CAN_ID)
    .withKP(Constants.DrivetrainConstants.DrivetrainMotors.right.KP)
    .withKI(Constants.DrivetrainConstants.DrivetrainMotors.right.KI)
    .withKD(Constants.DrivetrainConstants.DrivetrainMotors.right.KD)
    .withKF(Constants.DrivetrainConstants.DrivetrainMotors.right.KF)
    .withInverted(Constants.DrivetrainConstants.DrivetrainMotors.right.INVERTED)
    .withSensorPhase(Constants.DrivetrainConstants.DrivetrainMotors.right.SENSOR_PHASE)
    .withPeakOutputForward(Constants.DrivetrainConstants.DrivetrainMotors.right.PEAK_OUTPUT_FORWARD)
    .withPeakOutputReverse(Constants.DrivetrainConstants.DrivetrainMotors.right.PEAK_OUTPUT_REVERSE)
    //.withNeutralMode(Constants.DrivetrainConstants.DrivetrainMotors.LeftMaster.NEUTRAL_MODE)
    .build();

    addChild("left", left);
    addChild("right", right);

  }

  public void drive(double left, double right){
    this.right.drivePercentOutput(left);
    this.left.drivePercentOutput(right);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
