// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.commands.intake.*;
import frc.robot.commands.indexer.*;
import frc.robot.commands.autonomous.*;
import frc.robot.commands.autonomous.unusedFarAuto.AutonProcedureLHF;
import frc.robot.commands.autonomous.unusedFarAuto.AutonProcedureLNF;
import frc.robot.commands.climber.*;
import frc.robot.commands.climber.simpleCommands.HookDown;
import frc.robot.commands.climber.simpleCommands.HookUp;
import frc.robot.commands.climber.simpleCommands.HookUpLow;
import frc.robot.commands.shooter.*;

/**
* This class is where the bulk of the robot should be declared. Since Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
* periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
* subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
    // The robot's subsystems and commands are defined here...

    // Subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    private final Climber climber = new Climber();
    private final Shooter shooter = new Shooter();
    private final Intake intake = new Intake();
    private final Indexer indexer = new Indexer();

    // Auton DIP Switches

    private final DigitalInput firstBallOption = new DigitalInput(3);
    private final DigitalInput secondBallOption = new DigitalInput(4);
    private final DigitalInput thirdBallOption = new DigitalInput(5);

    //crucial variables
    int gitforcepushorginmaster = 2;

    // OI Devices
    private final Joystick leftJoystick = new Joystick(0);
    private final Joystick rightJoystick = new Joystick(1);
    private final Joystick gamepad = new Joystick(2);
    private final Joystick buttonBoard = new Joystick(3);
    private final JoystickButton turboButton = new JoystickButton(rightJoystick, 1);
    private final JoystickButton slowButton = new JoystickButton(rightJoystick, 3);
    // private final JoystickButton intakeButton = new JoystickButton(buttonBoard, 15);
    private final JoystickButton ejectButton = new JoystickButton(buttonBoard, 5);

    private final JoystickButton alignButton = new JoystickButton(leftJoystick, 1);
    private final JoystickButton shootHighButton = new JoystickButton(buttonBoard, 14);
    private final JoystickButton shootLowButton = new JoystickButton(buttonBoard, 13);

    // private final JoystickButton hookDownButton = new JoystickButton(buttonBoard, 1);
    private final JoystickButton lockStationariesButton = new JoystickButton(buttonBoard, 1);
    private final JoystickButton nextBarButton = new JoystickButton(buttonBoard, 16);
    private final JoystickButton hookDownButton = new JoystickButton(buttonBoard, 15);
    private final JoystickButton rampLowButton = new JoystickButton(buttonBoard, 12);

    private final JoystickButton hookUpMidButton = new JoystickButton(rightJoystick, 11);
    private final JoystickButton hookUpLowButton = new JoystickButton(rightJoystick, 10);

    private final JoystickButton stopAll = new JoystickButton(buttonBoard, 4);

    //private final JoystickButton hookZeroButton = new JoystickButton(rightJoystick, 7);
    // private final JoystickButton HHHButton = new JoystickButton(leftJoystick, 10);
    // private final JoystickButton TurnButton = new JoystickButton(leftJoystick, 11);


    private final JoystickButton fixClimberButton = new JoystickButton(rightJoystick, 7);
    private final JoystickButton indexTwoButton = new JoystickButton(buttonBoard, gitforcepushorginmaster);

    private final JoystickButton climberControlButton = new JoystickButton(leftJoystick, 3);
    //private final JoystickButton climberTiltZeroButton = new JoystickButton(rightJoystick, 8);

    private final JoystickButton climberTiltCenterButton = new JoystickButton(rightJoystick, 6);
    private final JoystickButton shootWayDowntownButton = new JoystickButton(leftJoystick, 6);


    //private final JoystickButton lockStationariesButton = new JoystickButton(gamepad, 1);
    //private final JoystickButton nextBarButton = new JoystickButton(gamepad, 2);



    // Commands
    private final Drive driveCommand = new Drive(drivetrain, leftJoystick, rightJoystick);
    private final DriveFurious driveFuriousCommand = new DriveFurious(drivetrain, leftJoystick, rightJoystick);
    private final DriveSlow driveSlowCommand = new DriveSlow(drivetrain, leftJoystick, rightJoystick);
    private final AlignClimber alignCommand = new AlignClimber(climber, drivetrain);
    private final IntakeIntake intakeIntakeCommand = new IntakeIntake(intake);
    private final IntakeEject intakeEjectCommand = new IntakeEject(intake);
    private final BetterIntakeStop intakeStopCommand = new BetterIntakeStop(intake);
    private final ShootWayDowntown shootWayDowntownCommand = new ShootWayDowntown(shooter);
    private final IndexerFeedWayDowntown indexWayDowntownCommand = new IndexerFeedWayDowntown(indexer, shooter);
    private final ShootHigh shootHighCommand = new ShootHigh(shooter);
    private final ShootLow shootLowCommand = new ShootLow(shooter);
    private final ShootEject shootEjectCommand = new ShootEject(shooter);
    private final ShootStop shootStopCommand = new ShootStop(shooter);
    private final IndexerStop indexerStopCommand = new IndexerStop(indexer);
    private final BetterIndexerIntake intakeCommand = new BetterIndexerIntake(indexer);
    private final IndexerEject indexerEjectCommand = new IndexerEject(indexer);
    private final IndexerFeedHigh feedHighCommand = new IndexerFeedHigh(indexer, shooter);
    private final IndexerFeedLow feedLowCommand = new IndexerFeedLow(indexer, shooter);
    private final ClimberStop climberStopCommand = new ClimberStop(climber);   
    private final HookZero hookZeroCommand = new HookZero(climber);
    private final ClimberControl climberControlCommand = new ClimberControl(climber, leftJoystick, rightJoystick, drivetrain);

    private final HookUp hookUpCommand = new HookUp(climber);
    private final HookUpLow hookUpLowCommand = new HookUpLow(climber);
    private final HookDown hookDownCommand = new HookDown(climber); 
    
    // private final HomeAlgorithm homeAlgorithmCommand = new HomeAlgorithm(climber); 

    private final NextBar nextBarCommand = new NextBar(climber);
    private final LockStationary lockStationariesCommand = new LockStationary(climber);
    private final ClimberCenter centerClimberCommand = new ClimberCenter(climber);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Set default commands
        drivetrain.setDefaultCommand(driveCommand);
        climber.setDefaultCommand(climberStopCommand);
        indexer.setDefaultCommand(indexerStopCommand);
        intake.setDefaultCommand(intakeStopCommand);
        shooter.setDefaultCommand(shootStopCommand);

        //sanjan.setDefaultCommand(STOP)
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
    * Use this method to define your button->command mappings. Buttons can be created by
    * instantiating a {@link GenericHID} or one of its subclasses ({@link
    * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
    * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
    */
    private void configureButtonBindings() {
        turboButton.whileHeld(driveFuriousCommand);
        alignButton.whileHeld(alignCommand);//new SequentialCommandGroup(new ClimberCenter(climber), alignCommand));
        slowButton.whileHeld(driveSlowCommand);
        stopAll.whenPressed(new ParallelCommandGroup(new ClimberStop(climber), new IndexerStop(indexer), new BetterIntakeStop(intake), new ShootStop(shooter)));
        //intakeButton.whenPressed(new SequentialCommandGroup(new ParallelDeadlineGroup(intakeCommand, intakeIntakeCommand), new WaitCommand(0.2)));
        indexTwoButton.whenPressed(new SequentialCommandGroup(new ParallelDeadlineGroup(new BetterIndexerIntake(indexer), new IntakeIntake(intake)), new WaitCommand(0.2), new ParallelDeadlineGroup(new BetterIndexerIntake(indexer), new IntakeIntake(intake)), new WaitCommand(0.1)));
        shootHighButton.whileHeld(new ParallelCommandGroup(shootHighCommand, feedHighCommand));
        shootLowButton.whileHeld(new ParallelCommandGroup(shootLowCommand, feedLowCommand));
        ejectButton.whileHeld(new ParallelCommandGroup(intakeEjectCommand, indexerEjectCommand, shootEjectCommand));

        shootWayDowntownButton.whileHeld(new ParallelCommandGroup(shootWayDowntownCommand, indexWayDowntownCommand));
        //hookZeroButton.whileHeld(hookZeroCommand);

        // hookDownButton.whenPressed(hookDownCommand);
        // hookUpButton.whenPressed(hookUpCommand);
        // hookUpLowButton.whenPressed(new HookUpLow(climber));
        hookUpMidButton.whenPressed(hookUpCommand);
        hookUpLowButton.whenPressed(hookUpLowCommand);
        hookDownButton.whenPressed(hookDownCommand);

        //climberTiltZeroButton.whenPressed(homeAlgorithmCommand);

        climberTiltCenterButton.whileHeld(centerClimberCommand);

        nextBarButton.whenPressed(nextBarCommand);
        lockStationariesButton.whenPressed(lockStationariesCommand);
        climberControlButton.whileHeld(climberControlCommand);


        //TurnButton.whenPressed(new Turn(drivetrain, 90));

        rampLowButton.whileHeld(new ShootLow(shooter));

        fixClimberButton.whileHeld(hookZeroCommand);

        //HHHButton.whileHeld(new AutonProcedureHHH(drivetrain, intake, indexer, shooter));
        }

    public void onInit() {
        // intake.onInit();
        //climber.onInit();
        //drivetrain.setBrakeMode(true);
        //new InstantCommand(() -> { drivetrain.zeroCurrentPosition(); }, drivetrain);//zero the drivetrain
    }

    public void onAutoInit(){
        drivetrain.setBrakeMode(true);
    }

    public void onDisableInit(){
        drivetrain.setBrakeMode(false);
    }

    public boolean getThirdBallOption(){
        return (!this.thirdBallOption.get());
    }

    public int parseAutoSelector() {
        int selection = 0;
        if (!this.firstBallOption.get()) selection += 2;//high if plugged, else low
        if (!this.secondBallOption.get()) selection += 1;//high if plugged else none
        
        //if (!this.thirdBallOption.get()) selection += 1;//third ball or not
        return selection;
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {//add parallel command with climber calibration(if needed) to each of these
        if(getThirdBallOption()){
            return new AutonProcedureHHH(drivetrain, intake, indexer, shooter);//high high high
        }else{
            switch(parseAutoSelector()) {
                default:
                case 0://low none
                    return new AutonProcedureLN(drivetrain, intake, indexer, shooter);
                case 1://low high (the sfr classic)
                    return new AutonProcedureLH(drivetrain, intake, indexer, shooter);
                case 2://high none
                    return new AutonProcedureHN(drivetrain, intake, indexer, shooter);
                case 3://high high
                    return new AutonProcedureHH(drivetrain, intake, indexer, shooter);
            }
        }
    }
}
