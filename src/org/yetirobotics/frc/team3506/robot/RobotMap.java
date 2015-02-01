package org.yetirobotics.frc.team3506.robot;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Talon ports (CURRENT SETUP IS FOR TWO DRIVE MOTORS ON EITHER SIDE)
	public final static int LEFT_BACK_PORT = 3; //2
	public final static int LEFT_FRONT_PORT = 2; //0
	public final static int RIGHT_BACK_PORT = 1; //5
	public final static int RIGHT_FRONT_PORT = 0; //3
	
	public final static int LEFT_ARM_PORT =  7;
	public final static int RIGHT_ARM_PORT =  6;
	
	// Joystick ports
	public static final int LEFT_JOYSTICK = 1;
	public static final int RIGHT_JOYSTICK = 2;
	public static final int ARM_JOYSTICK = 0;
	public static final int JOYSTICK_AXIS_X = 0;
	public static final int JOYSTICK_AXIS_Y = 1;
	public static final int JOYSTICK_THROTTLE = 2;
	public static final int NUMBER_OF_JOYSTICK_BUTTONS = 11;
	
	// Sonar port
	public static final int SONAR_PORT = 1;
	 
	// Gyro Port
	public static final int GYRO_PORT = 0;
	public static final double TURN_TIMEOUT = 0.75;
	public static final double DRIVE_STRAIGHT_TIMEOUT= 2;	
	
	//Pneumatics ports
	public final static int CLAW_RIGHT_CLAMP = 0;
	public final static int CLAW_RIGHT_RELEASE = 1;
	public final static int CLAW_LEFT_CLAMP = 2;
	public final static int CLAW_LEFT_RELEASE = 3;
	public final static int[] LEFT_FRONT_LIFTER = {4,5};
	public final static int[] LEFT_REAR_LIFTER = {6,7};
	public final static int PCM_ID_NUMBER = 0;
	
	//Digital Inputs
	public final static int LEFT_LIFTER_UP = 0;
	public final static int LEFT_LIFTER_DOWN = 1;
	public final static int BIN_IN_CLAW = 2;
	public final static int[] LEFT_DRIVE_ENC = {3,4};
	public final static int[] RIGHT_DRIVE_ENC = {5,6};
	
	//LED ports
	public final static int COLOR_CONTROLLER_PORT = 9;
	public final static int LED_POWER_PORT = 3;
	
	// Speed
	public final static double TURN_RIGHT_SPEED = 0.3;
	public final static double TURN_LEFT_SPEED = -0.3;
	public final static double FORWARD_SPEED = -0.5;
	public final static double DIST_PER_PULSE = 0.006;	
	
	// Camera
	public final static String cameraName = "cam0";

}
