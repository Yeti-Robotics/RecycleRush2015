
package org.yetirobotics.frc.team3506.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	// Declaration of various peripherals
	Joystick leftJoy;
	Joystick rightJoy;
	RobotDrive drive;
	Gyro gyro;
	Talon leftBack;
	Talon leftFront;
	Talon rightBack;
	Talon rightFront;
	Timer timer;
	Relay spike;
	
	// Integer ports according to roboRio setup
	final int LEFT_JOYSTICK_PORT = 1;
	final int RIGHT_JOYSTICK_PORT = 2;
	
	// Talon ports 
	final int LEFT_BACK_PORT = 3;
	final int LEFT_FRONT_PORT = 2;
	final int RIGHT_BACK_PORT = 1;
	final int RIGHT_FRONT_PORT = 0;
	
	final int GYRO_PORT = 0; 
	final int SPIKE_PORT = 0; // Not currently used
	
	// Following speeds require double values between -1.0 and 1.0
	final double X_SPEED = 0;
	final double Y_SPEED = 0;
	final double ROTATION_SPEED = 0;
	
	// Joystick orientation 
	double leftX;
	double leftY;
	double rightX;
	double rightY;
	
	// Stuff
	int gyroResetTime = 5000;
	long currentTime;
	
	// Supporting methods
	
	
    // Runtime methods after this point
	
	public void robotInit() {
    	// Instantiation of various peripherals
		leftJoy = new Joystick(LEFT_JOYSTICK_PORT);
    	rightJoy = new Joystick(RIGHT_JOYSTICK_PORT);
    	gyro = new Gyro(GYRO_PORT);
    	timer = new Timer();
    	spike = new Relay(SPIKE_PORT);
    	drive = new RobotDrive(LEFT_BACK_PORT, LEFT_FRONT_PORT, RIGHT_BACK_PORT, RIGHT_FRONT_PORT);
    	gyro.reset();
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
    	currentTime = System.currentTimeMillis();
    	while(isEnabled() && isOperatorControl()){
    		
    		leftX = leftJoy.getX();
    		leftY = leftJoy.getY();
    		rightX = rightJoy.getX();
    		rightY =rightJoy.getY();
    		
    		drive.mecanumDrive_Cartesian(leftX, rightX, leftY, gyro.getAngle());
    		
    		// Reset gyro automatically
    		if((System.currentTimeMillis() - currentTime) > gyroResetTime){
    			gyro.reset();
    			currentTime = System.currentTimeMillis();
    		}
    		
    		timer.delay(0.01);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
