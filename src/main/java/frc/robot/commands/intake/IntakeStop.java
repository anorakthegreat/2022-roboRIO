package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeStop extends CommandBase {
    public Intake intake;
    public boolean shouldBeUp;

    /**
     * Creates a new IntakeStop.
     */
    public IntakeStop(Intake intake) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.intake = intake;
        addRequirements(this.intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        intake.pivotUp();
        //this.intake.runSpinner(0);
        //this.intake.runPivot(0);
        // this.intake.setPivot(Constants.IntakeConstants.PivotConstants.UP_POSITION);
        // SmartDashboard.putNumber("intake setpoint", 0);
        
        
        //shouldBeUp = (intake.getPot() >= 2.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        intake.runSpinner(0);
        // if(shouldBeUp){}
            // if (intake.getPot() <= -30) {
            //     intake.runPivot(-Math.abs(Constants.IntakeConstants.IntakeMotionParameters.INTAKE_PIVOT_PERCENT_OUTPUT_UP *(1.05*((Constants.IntakeConstants.IntakeMotionParameters.PP_ADJUSTMENT_CONSTANT)+intake.getPot()))));
            // } else if(intake.getPot()<=-16.1){
            //     intake.runPivot(-0.20);
            // }else{
            //     intake.runPivot(0);
            // }
        // intake.runSpinner(0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        intake.disable();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return intake.getMeasurement() >= 27;
    }
}

