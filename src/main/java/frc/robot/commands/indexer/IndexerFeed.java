// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.indexer;

import static frc.robot.Constants.IndexerConstants.IndexerMotionParameters.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class IndexerFeed extends CommandBase {
    private Indexer indexer;
    private boolean wasFalse;
    private boolean done = false;
    private boolean shouldCheckRefill;

    /** Creates a new IndexerFeed. */
    public IndexerFeed(Indexer indexer) {
        this.indexer = indexer;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(indexer);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        wasFalse = false;
        done = false;

        shouldCheckRefill = indexer.getSensorOne() && indexer.getSensorTwo();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // if (shouldCheckRefill) {
        //     if (indexer.getSensorTwo() && wasFalse) {
        //         // shouldCheckRefill = false;
        //         done = true;
        //         return;
        //     }

            indexer.runMotorOne(STAGE_ONE_PERCENT_OUTPUT_FORWARD);
            indexer.runMotorTwo(STAGE_TWO_PERCENT_OUTPUT_FORWARD);

        //     if (!indexer.getSensorTwo()) {
        //         wasFalse = true;
        //     }
        // } else {
        //     if (!indexer.getSensorTwo()) {
        //         done = true;
        //         return;
        //     }

        //     indexer.runMotorOne(STAGE_ONE_PERCENT_OUTPUT_FORWARD);
        //     indexer.runMotorTwo(STAGE_TWO_PERCENT_OUTPUT_FORWARD);
        // }
    }
        
    

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        indexer.runMotorOne(0);
        indexer.runMotorTwo(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return done;
    }
}
