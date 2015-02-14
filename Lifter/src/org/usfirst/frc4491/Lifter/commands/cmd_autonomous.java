package org.usfirst.frc4491.Lifter.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cmd_autonomous extends CommandGroup {
    
    public  cmd_autonomous(long lDriveTimeMs, double dbDriveSpeed) {
    	System.out.println("New autonomous mode (time=" + lDriveTimeMs + ")");
    	addSequential(new cmd_liftGotoFloor());
    	addSequential(new cmd_liftGotoHeight(430, true));
    	addSequential(new cmd_liftGotoHeight(600));
    	addSequential(new cmd_driveLinear(lDriveTimeMs, dbDriveSpeed));
    	addSequential(new cmd_liftGotoHeight(0, true));
    }
}
