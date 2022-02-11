// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCNEO;

public class ClimberWinch extends SubsystemBase {
  private FRCNEO winch;
  /** Creates a new Climber. */
  public ClimberWinch() {
    winch = new FRCNEO.FRCNEOBuilder(Constants.ClimberConstants.ClimberMotors.Winch.CAN_ID)
    .withInverted(Constants.ClimberConstants.ClimberMotors.Winch.INVERT)
    .withFeedbackPort(Constants.ClimberConstants.ClimberMotors.Winch.FEEDBACK_PORT)
    .withSensorPhase(Constants.ClimberConstants.ClimberMotors.Winch.SENSOR_PHASE)
    .withTimeout(Constants.ClimberConstants.ClimberMotors.Winch.TIMEOUT)
    .withCurrentLimitEnabled(Constants.ClimberConstants.ClimberMotors.Winch.ENABLE_CURRENT_LIMIT)
    .withCurrentLimit(Constants.ClimberConstants.ClimberMotors.Winch.CURRENT_LIMIT)
    .withOpenLoopRampRate(Constants.ClimberConstants.ClimberMotors.Winch.OPEN_LOOP_RAMP)
    .withPeakOutputForward(Constants.ClimberConstants.ClimberMotors.Winch.PEAK_OUTPUT_FORWARD)
    .withPeakOutputReverse(Constants.ClimberConstants.ClimberMotors.Winch.PEAK_OUTPUT_REVERSE).build();
  }

  public void setWinch(double percentOutput) {
    winch.drivePercentOutput(percentOutput);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
