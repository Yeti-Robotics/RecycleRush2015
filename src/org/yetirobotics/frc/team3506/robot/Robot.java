
package org.yetirobotics.frc.team3506.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Joystick leftJoy;
	Joystick rightJoy;
	RobotDrive drive;
	final int LEFT_JOYSTICK_PORT = 1;
	final int RIGHT_JOYSTICK_PORT = 2;
	final int LEFT_BACK_PORT = 4;
	final int LEFT_FRONT_PORT = 3;
	final int RIGHT_BACK_PORT = 2;
	final int RIGHT_FRONT_PORT = 1;
    private void mecanum (RobotDrive drive){
    	
    }
	
	/*
	 * Runtime methods after this point
	 * @see edu.wpi.first.wpilibj.IterativeRobot#robotInit()
	 */
	
	public void robotInit() {
    	leftJoy = new Joystick(LEFT_JOYSTICK_PORT);
    	rightJoy = new Joystick(RIGHT_JOYSTICK_PORT);
    	drive = new RobotDrive(LEFT_FRONT_PORT, LEFT_BACK_PORT, RIGHT_FRONT_PORT, RIGHT_BACK_PORT);
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	while(isEnabled() && isOperatorControl()){
    		
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
