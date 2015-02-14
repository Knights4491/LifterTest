// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4491.Lifter.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc4491.Lifter.Robot;

/**
 *
 */
public class  cmd_liftGotoHeight extends Command {
	double m_dbHeightMM = 0;
	boolean m_bWaitToReachHeight = false;

    public cmd_liftGotoHeight(double heightMM, boolean bWaitToReachHeight) {
    	m_dbHeightMM = heightMM;
    	m_bWaitToReachHeight = bWaitToReachHeight;
        requires(Robot.lift);
    }

    public cmd_liftGotoHeight(double heightMM) {
    	m_dbHeightMM = heightMM;
    	m_bWaitToReachHeight = false;
        requires(Robot.lift);
    }
    
    public cmd_liftGotoHeight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.lift);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	System.out.println("cmd_liftGotoHeight::initialize - lift enabled=" + Robot.lift.isLiftEnabled() + ", lift at floor=" + Robot.lift.isLiftAtFloor());
    	if (Robot.lift.isLiftEnabled())
    	{
    		Robot.lift.setHeight(m_dbHeightMM);
    	}
    	else
    	{
	    	System.out.println("The lift is disabled.");
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("cmd_liftGotoHeight::isFinished - m_bWaitToReachHeight=" + m_bWaitToReachHeight + ", current height=" + Robot.lift.getHeight());
        return !m_bWaitToReachHeight || 
        		(Robot.lift.isLiftEnabled() && (Math.abs(Robot.lift.getHeight() - m_dbHeightMM) < 10));
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
