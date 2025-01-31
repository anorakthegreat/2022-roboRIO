// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class BetterIndexerIntake extends CommandBase {
    private Indexer indexer;
    private boolean sensorTwo = false;
    private boolean done = false;

    /** Creates a new BetterIndexerIntake. */
    public BetterIndexerIntake(Indexer indexer2) {
        this.indexer = indexer2;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(indexer2);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        done = false;
        sensorTwo = indexer.getSensorTwo();
        indexer.runMotorOne(Constants.IndexerConstants.IndexerMotionParameters.STAGE_ONE_PERCENT_OUTPUT_FORWARD);
        if (!sensorTwo) indexer.runMotorTwo(Constants.IndexerConstants.IndexerMotionParameters.STAGE_TWO_PERCENT_OUTPUT_FORWARD);
    }

    private void stop() {
        done = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (sensorTwo) {
            if (indexer.getSensorOne() && indexer.getSensorTwo()) stop();
            else {
                indexer.runMotorOne(Constants.IndexerConstants.IndexerMotionParameters.STAGE_ONE_PERCENT_OUTPUT_FORWARD);
            }
        } else {
            if (indexer.getSensorOne() && indexer.getSensorTwo()) stop();
            if (indexer.getSensorTwo()) {
                indexer.runMotorTwo(0);
                stop();
            }
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return done;
    }
}
