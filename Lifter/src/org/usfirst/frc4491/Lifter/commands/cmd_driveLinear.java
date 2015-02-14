package org.usfirst.frc4491.Lifter.commands;

import org.usfirst.frc4491.Lifter.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmd_driveLinear extends Command {

	double m_dbDriveSpeed = 0;
	long m_lTimeMs = 0;
	
	long m_lStartTimeMs = 0;
	
    public cmd_driveLinear(long lTimeMs, double dbDriveSpeed) {
    	requires(Robot.driveTrain);
    	m_lTimeMs = lTimeMs;
    	m_dbDriveSpeed = dbDriveSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_lStartTimeMs = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	Robot.driveTrain.SetTankDrive(-m_dbDriveSpeed, -m_dbDriveSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - m_lStartTimeMs) > m_lTimeMs;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.SetTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.SetTankDrive(0, 0);
    }
}
