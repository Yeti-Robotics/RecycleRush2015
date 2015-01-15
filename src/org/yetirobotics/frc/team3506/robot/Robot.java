package org.yetirobotics.frc.team3506.robot;

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
	Joystick leftJoy;
	Joystick rightJoy;
	RobotDrive mecanumDrive;
	Gyro gyro;
	Talon leftBack;
	Talon leftFront;
	Talon rightBack;
	Talon rightFront;
	Compressor compressor;
	DoubleSolenoid solenoid1;
	DoubleSolenoid solenoid2;

	// Integer ports according to roboRio setup
	final static int LEFT_JOYSTICK_PORT = 1;
	final static int RIGHT_JOYSTICK_PORT = 2;

	// Talon ports
	final static int LEFT_BACK_PORT = 3;
	final static int LEFT_FRONT_PORT = 2;
	final static int RIGHT_BACK_PORT = 1;
	final static int RIGHT_FRONT_PORT = 0;

	final static int GYRO_PORT = 0;
	final static int SPIKE_PORT = 0; // Not currently used

	// Following speeds require double values between -1.0 and 1.0
	final static double X_SPEED = 0.25;
	final static double Y_SPEED = 0.25;
	final static double ROTATION_SPEED = 0.25;

	// Joystick orientation
	double leftX;
	double leftY;
	double rightX;
	double rightY;

	// For gyro reset
	int gyroResetTime = 5000;
	long currentTime;

	// Solenoid ports
	final static int SOLENOID_1_PORT = 0;
	final static int SOLENOID_2_PORT = 0;

	// CAN solenoid ports
	final static int CAN_SOLENOID_1_FORWARD = 0;
	final static int CAN_SOLENOID_1_REVERSE = 1;
	final static int CAN_SOLENOID_2_FORWARD = 2;
	final static int CAN_SOLENOID_2_REVERSE = 3;

	final static double DEADZONE = 0.1;

	// Assisting methods
	private double deadZoneMod(double joyVal) {
		if (Math.abs(joyVal) > DEADZONE) {
			return joyVal;
		} else {
			return 0.0;
		}
	}

	// Runtime methods after this point
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// Instantiation of various peripherals
		leftJoy = new Joystick(LEFT_JOYSTICK_PORT);
		rightJoy = new Joystick(RIGHT_JOYSTICK_PORT);
		gyro = new Gyro(GYRO_PORT);
		mecanumDrive = new RobotDrive(LEFT_FRONT_PORT, LEFT_BACK_PORT,
				RIGHT_FRONT_PORT, RIGHT_BACK_PORT);
		gyro.reset();

		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		solenoid1 = new DoubleSolenoid(0, CAN_SOLENOID_1_FORWARD,
				CAN_SOLENOID_1_REVERSE);
		solenoid2 = new DoubleSolenoid(0, CAN_SOLENOID_2_FORWARD,
				CAN_SOLENOID_2_REVERSE);

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
		while (isEnabled() && isOperatorControl()) {
			leftX = deadZoneMod(leftJoy.getX());
			leftY = deadZoneMod(leftJoy.getY());
			rightX = deadZoneMod(rightJoy.getX());
			rightY = deadZoneMod(rightJoy.getY());

			mecanumDrive.mecanumDrive_Cartesian(leftX, leftY, rightX,
					gyro.getAngle());

			SmartDashboard.putData("Gyro", gyro);
			SmartDashboard.putNumber("Pressure",
					compressor.getCompressorCurrent());

			// Button operations
			if (leftJoy.getRawButton(7)) {
				gyro.reset();
			}
			if (leftJoy.getRawButton(1)) {
				solenoid1.set(DoubleSolenoid.Value.kForward);
			}
			if (rightJoy.getRawButton(1)) {
				solenoid2.set(DoubleSolenoid.Value.kForward);
			}
			if (leftJoy.getRawButton(2)) {
				solenoid1.set(DoubleSolenoid.Value.kReverse);
			}
			if (rightJoy.getRawButton(2)) {
				solenoid2.set(DoubleSolenoid.Value.kReverse);
			}

			// Reset gyro automatically
			if ((System.currentTimeMillis() - currentTime) > gyroResetTime) {
				gyro.reset();
				currentTime = System.currentTimeMillis();
			}
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
