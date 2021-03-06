// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4491.Lifter.subsystems;

import org.usfirst.frc4491.Lifter.Robot;
import org.usfirst.frc4491.Lifter.RobotMap;
import org.usfirst.frc4491.Lifter.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor_leftFront = RobotMap.driveTrainmotor_leftFront;
    SpeedController motor_leftRear = RobotMap.driveTrainmotor_leftRear;
    SpeedController motor_rightFront = RobotMap.driveTrainmotor_rightFront;
    SpeedController motor_rightRear = RobotMap.driveTrainmotor_rightRear;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new cmd_driveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void SetTankDrive (double vitesseGauche, double vitesseDroite) {
    	robotDrive.tankDrive(vitesseGauche, vitesseDroite);
    }
}

