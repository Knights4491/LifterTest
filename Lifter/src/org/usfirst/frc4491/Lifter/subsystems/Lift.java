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
import org.usfirst.frc4491.Lifter.commands.cmd_liftGotoFloor;
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
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController motor_Lift = RobotMap.liftmotor_Lift;
    DigitalInput limitBottom = RobotMap.liftlimitBottom;
    Encoder encoderLiftHeight = RobotMap.liftencoderLiftHeight;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final double m_dbFloorDirection = -1;
    private boolean m_bLiftInitialized = false;
    
    // Initialize your subsystem here
    public Lift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Lift", 0.005, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lift", "PIDSubsystem Controller", getPIDController());

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
        setDefaultCommand(new cmd_liftGotoFloor());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

    	System.out.println("encoder value=" + encoderLiftHeight.get() + " -- current setPoint = "+ getSetpoint());
    	return encoderLiftHeight.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

    	System.out.println("output = "+output);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        motor_Lift.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    public void enableSystem()
    {
    	if (isLiftAtFloor())
    	{
    		// Set the encoder zero value now since the lift is at floor.
    		encoderLiftHeight.reset();
    		// When the lift is at floor, this is the setSetpoint 0.
    		setSetpoint(0);
    		enable();
    		m_bLiftInitialized = true;
    		setDefaultCommand(new cmd_liftWithJoystick());
    	}
    }
    
    public void disableSystem()
    {
		m_bLiftInitialized = false;
    	disable();
    	motor_Lift.set(0);
		setDefaultCommand(new cmd_liftGotoFloor());
    }
    
    public void stopLift()
    {
    	if (!m_bLiftInitialized)
    	{
    		motor_Lift.set(0);
    	}
    }
    
    public boolean isSystemEnabled()
    {
    	return m_bLiftInitialized;
    }
    
    public void moveLiftToFloor()
    {
    	motor_Lift.set(m_dbFloorDirection);
    }
    
    public boolean isLiftAtFloor()
    {
    	return limitBottom.get();
    }
    
    public void setHeight(double height)
    {
    	if (height < 0)
    	{
    		height = 0;
    	}
    	System.out.println("setHeight=" + height);
    	setSetpoint(height);
    }
    
    public double getHeight()
    {
    	return getSetpoint();
    }
}
