package org.yetirobotics.frc.team3506.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// Talon ports
	public final static int LEFT_BACK_PORT = 3;
	public final static int LEFT_FRONT_PORT = 2;
	public final static int RIGHT_BACK_PORT = 1;
	public final static int RIGHT_FRONT_PORT = 0;
	
	public final static int LEFT_ARM_PORT =  6;
	public final static int RIGHT_ARM_PORT =  6;
	
	// Joystick ports
	public static final int LEFT_JOYSTICK = 1;
	public static final int RIGHT_JOYSTICK = 2;
	public static final int JOYSTICK_AXIS_X = 0;
	public static final int JOYSTICK_AXIS_Y = 1;
	public static final int JOYSTICK_THROTTLE = 2;
	public static final int NUMBER_OF_RIGHT_JOYSTICK_BUTTONS = 11;
	public static final int NUMBER_OF_LEFT_JOYSTICK_BUTTONS = 11;
	
	// Sonar port
	public static final int SONAR_PORT = 1;
	 
	// Gyro Port
	public static final int GYRO_PORT = 0;
	public static final double TURN_TIMEOUT = 0.75;
	public static final double DRIVE_STRAIGHT_TIMEOUT= 2;	
	
	//Pneumatics ports
	public final static int CLAW_RIGHT_OPEN = 0;
	public final static int CLAW_RIGHT_CLOSE = 1;
	public final static int CLAW_LEFT_OPEN = 2;
	public final static int CLAW_LEFT_CLOSE = 3;
	public final static int PCM_ID_NUMBER = 0;
	
	//Digital Inputs
	public final static int LIMIT_SWITCH_1 = 0;
	public final static int LEFT_FRONT_ENC1 = 1;
	public final static int LEFT_FRONT_ENC2 = 2;
	
	//LED ports
	public final static int COLOR_CONTROLLER_PORT = 9;
	public final static int LED_POWER_PORT = 3;
	
	// Angles
	public final static double TURN_STOP_ANGLE = 70;
	
	// Speed
	public final static double TURN_RIGHT_SPEED = 0.3;
	public final static double TURN_LEFT_SPEED = -0.3;
	public final static double FORWARD_SPEED = -0.5;
	public final static double DIST_PER_PULSE = 0.006;	
}
