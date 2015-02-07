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

import org.usfirst.frc4491.Lifter.RobotMap;
import org.usfirst.frc4491.Lifter.commands.cmd_liftWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends PIDSubsystem {
	boolean m_bEnabled = false;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor_Lift = RobotMap.liftmotor_Lift;
    DigitalInput limitBottom = RobotMap.liftlimitBottom;
    Encoder encoderLiftHeight = RobotMap.liftencoderLiftHeight;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Initialize your subsystem here
    public Lift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Lift", 0.035, 0.0, 0.0);
        setAbsoluteTolerance(10.0);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lift", "PIDSubsystem Controller", getPIDController());
        getPIDController().setInputRange(0.0, 1400.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
    	// Start with cmd_liftGotoFloor to make sure the robot lift start from
    	// the floor position where there is a limit switch.
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new cmd_liftWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	if (isLiftAtFloor())
    	{
    		encoderLiftHeight.reset();
    	}

    	System.out.println("encoder value=" + encoderLiftHeight.pidGet() + " -- current setPoint = "+ getSetpoint());
    	return encoderLiftHeight.pidGet();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

    	System.out.println("output = "+output);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        motor_Lift.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    public boolean isLiftEnabled()
    {
    	return m_bEnabled;
    }

    public void enableLift()
    {
    	System.out.println("Robot enableLift");
    	m_bEnabled = true;
		// Set the encoder zero value now since the lift is at floor.
		resetLift();
		// When the lift is at floor, this is the setSetpoint 0.
		setSetpoint(0);
		enable();
    }
    
    public void disableLift()
    {
    	System.out.println("Robot disableLift");
    	m_bEnabled = false;
    	disable();
    	stopLift();
    }
    
    public boolean isLiftAtFloor()
    {
    	return limitBottom.get();
    }
    
    public void gotoFloor()
    {
    	motor_Lift.set(-1);
    }
    
    public void gotoCeil()
    {
    	motor_Lift.set(1);
    }

    public void stopLift()
    {
    	motor_Lift.set(0);
    }
    
    public void resetLift()
    {
    	encoderLiftHeight.reset();
    }
    
    public void setHeight(double heightMM)
    {
    	System.out.println("setHeight=" + heightMM);    	
    	setSetpoint(heightMM);
    }
    
    public double getHeight()
    {
    	return encoderLiftHeight.pidGet();
    }
    
    public int getEncoderCount()
    {
    	return encoderLiftHeight.get();
    }
}
