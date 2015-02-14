package org.usfirst.frc4491.Lifter.commands;

import org.usfirst.frc4491.Lifter.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class cmd_liftForceReset extends Command {

    public cmd_liftForceReset() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.disableLift();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
