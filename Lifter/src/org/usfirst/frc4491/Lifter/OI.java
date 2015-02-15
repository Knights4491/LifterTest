// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4491.Lifter;

import org.usfirst.frc4491.Lifter.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public JoystickButton button_ResetToFloor;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton button_HeightA;
    public JoystickButton button_HeightB;
    public JoystickButton button_HeightX;
    public JoystickButton button_HeightY;
    public Joystick joystick_driver;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick_driver = new Joystick(0);
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("cmd_liftGotoFloor", new cmd_liftGotoFloor());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        button_HeightY = new JoystickButton(joystick_driver, 4);
        button_HeightY.whenPressed(new cmd_liftGotoHeight(1090));
        button_HeightX = new JoystickButton(joystick_driver, 3);
        button_HeightX.whenPressed(new cmd_liftGotoHeight(770));
        button_HeightB = new JoystickButton(joystick_driver, 2);
        button_HeightB.whenPressed(new cmd_liftGotoHeight(450));
        button_HeightA = new JoystickButton(joystick_driver, 1);
        button_HeightA.whenPressed(new cmd_liftGotoHeight(0));

        button_ResetToFloor = new JoystickButton(joystick_driver, 7);
        button_ResetToFloor.whenPressed(new cmd_liftForceReset());
        
        SmartDashboard.putData("cmd_liftCalibrate", new cmd_liftCalibrate(7000));
        SmartDashboard.putData("cmd_liftForceReset", new cmd_liftForceReset());
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystick_driver() {
        return joystick_driver;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

