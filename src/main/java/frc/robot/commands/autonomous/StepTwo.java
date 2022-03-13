// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class StepTwo extends CommandBase {
    Drivetrain drivetrain;

    /** Creates a new StepTwo. */
    public StepTwo(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drivetrain.setBrakeMode(true);
        drivetrain.driveWithRamp(0.2, 0.2);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivetrain.setBrakeMode(false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return drivetrain.getCurrentEncoderPosition() <= 0;
    }
}
