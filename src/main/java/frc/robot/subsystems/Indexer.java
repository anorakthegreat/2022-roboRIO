// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.FRCLib.Motors.FRCTalonFX;

public class Indexer extends SubsystemBase {
    public FRCTalonFX stageOneMotor, stageTwoMotor;
    public DigitalInput sensor1, sensor2;

    /**
    * Creates a new Indexer.
    */
    public Indexer() {
        sensor1 = new DigitalInput(Constants.IndexerConstants.IndexerSensors.FrontSensor.ID);
        sensor2 = new DigitalInput(Constants.IndexerConstants.IndexerSensors.RearSensor.ID);
        // Construct Motor Objects
        stageOneMotor = new FRCTalonFX.FRCTalonFXBuilder(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.CAN_ID)
            .withInverted(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.INVERT)
            .withFeedbackPort(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.FEEDBACK_PORT)
            .withSensorPhase(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.SENSOR_PHASE)
            .withTimeout(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.TIMEOUT)
            .withCurrentLimitEnabled(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.ENABLE_CURRENT_LIMIT)
            .withCurrentLimit(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.CURRENT_LIMIT)
            .withOpenLoopRampRate(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.OPEN_LOOP_RAMP)
            .withPeakOutputForward(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.IndexerConstants.IndexerMotors.IndexerStageOne.NEUTRAL_MODE)
            .build();

        stageTwoMotor = new FRCTalonFX.FRCTalonFXBuilder(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.CAN_ID)
            .withInverted(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.INVERT)
            .withFeedbackPort(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.FEEDBACK_PORT)
            .withSensorPhase(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.SENSOR_PHASE)
            .withTimeout(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.TIMEOUT)
            .withCurrentLimitEnabled(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.ENABLE_CURRENT_LIMIT)
            .withCurrentLimit(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.CURRENT_LIMIT)
            .withOpenLoopRampRate(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.OPEN_LOOP_RAMP)
            .withPeakOutputForward(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.PEAK_OUTPUT_FORWARD)
            .withPeakOutputReverse(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.PEAK_OUTPUT_REVERSE)
            .withNeutralMode(Constants.IndexerConstants.IndexerMotors.IndexerStageTwo.NEUTRAL_MODE)
            .build();

        addChild("stageOneMotor", stageOneMotor);
        addChild("stageTwoMotor", stageTwoMotor);
    }

    /**
    * Update any states
    */
    public void updateState() {

    }

    //public boolean getSensorValue() {
        //return true; //sensor.get();
    //}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        //updateState();
    }
}
