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
    
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainmotor_leftFront;
    public static SpeedController driveTrainmotor_leftRear;
    public static SpeedController driveTrainmotor_rightFront;
    public static SpeedController driveTrainmotor_rightRear;
    public static RobotDrive driveTrainRobotDrive;
    public static SpeedController liftmotor_Lift;
    public static Encoder liftencoderLiftHeight;
    public static DigitalInput liftlimit_Bottom;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainmotor_leftFront = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "motor_leftFront", (Talon) driveTrainmotor_leftFront);
        
        driveTrainmotor_leftRear = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "motor_leftRear", (Talon) driveTrainmotor_leftRear);
        
        driveTrainmotor_rightFront = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "motor_rightFront", (Talon) driveTrainmotor_rightFront);
        
        driveTrainmotor_rightRear = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "motor_rightRear", (Talon) driveTrainmotor_rightRear);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainmotor_leftFront, driveTrainmotor_leftRear,
              driveTrainmotor_rightFront, driveTrainmotor_rightRear);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        liftmotor_Lift = new Talon(0);
        LiveWindow.addActuator("Lift", "motor_Lift", (Talon) liftmotor_Lift);
        
        liftencoderLiftHeight = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Lift", "encoder LiftHeight", liftencoderLiftHeight);
        liftencoderLiftHeight.setDistancePerPulse(1.0);
        liftencoderLiftHeight.setPIDSourceParameter(PIDSourceParameter.kRate);
        liftlimit_Bottom = new DigitalInput(0);
        LiveWindow.addSensor("Lift", "limit_Bottom", liftlimit_Bottom);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
