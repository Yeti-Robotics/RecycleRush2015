package org.yetirobotics.frc.team3506.robot;

import java.util.ArrayList;
import java.util.List;

import org.yetirobotics.frc.team3506.robot.commands.UserDriveCommand;
import org.yetirobotics.frc.team3506.robot.domain.RobotInput;
import org.yetirobotics.frc.team3506.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem drive;
	public static SensorSubsystem sensorBase;
	public static CompressorSubsystem compressor;
	public static LEDSubsystem ledSubsystem;
	public static RobotArm robotarm;
	public static boolean recording = false;
	public static boolean playing = false;
	public static RobotInput input;
//	public static RobotInput previousInput = new RobotInput();
	public static List<RobotInput> inputs = new ArrayList<RobotInput>();
	

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		sensorBase = new SensorSubsystem();
		drive = new DriveSubsystem();
		compressor = new CompressorSubsystem();
		ledSubsystem = new LEDSubsystem();
		robotarm = new RobotArm();
		// this should be last
		oi = new OI();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		new UserDriveCommand().start();

	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		if (!playing) {
			input = new RobotInput();
			input.setButtonState(true, 10, oi.getLeftJoystick());
			input.setButtonState(true, 4, oi.getLeftJoystick());
			input.setLeftY(oi.getLeftY());
			input.setRightY(oi.getRightY());
		}
		
		if (recording) {
			inputs.add(input);
		}
		
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
		log();
	}

	private void log() {
		drive.log();
		sensorBase.log();
		SmartDashboard.putBoolean("Recording:", recording);
		SmartDashboard.putNumber("Input count:", inputs.size());
		SmartDashboard.putBoolean("Left Button4", oi.getLeftJoystick().getRawButton(4));
	}
}
