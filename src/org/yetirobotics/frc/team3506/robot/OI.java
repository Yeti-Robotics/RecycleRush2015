package org.yetirobotics.frc.team3506.robot;

import static org.yetirobotics.frc.team3506.robot.RobotMap.LEFT_JOYSTICK;
import static org.yetirobotics.frc.team3506.robot.RobotMap.RIGHT_JOYSTICK;
import static org.yetirobotics.frc.team3506.robot.RobotMap.ARM_JOYSTICK;

import org.yetirobotics.frc.team3506.robot.commands.LoadRecordingCommand;
import org.yetirobotics.frc.team3506.robot.commands.RebootCommand;
import org.yetirobotics.frc.team3506.robot.commands.RecordCommand;
import org.yetirobotics.frc.team3506.robot.commands.ResetGyroCommand;
import org.yetirobotics.frc.team3506.robot.commands.StartCompressorCommand;
import org.yetirobotics.frc.team3506.robot.commands.StopCompressorCommand;
import org.yetirobotics.frc.team3506.robot.commands.ToggleElevatorCommand;
import org.yetirobotics.frc.team3506.robot.commands.LEDs.ChangeLightSpeedCommand;
import org.yetirobotics.frc.team3506.robot.commands.LEDs.ToggleLightsCommand;
import org.yetirobotics.frc.team3506.robot.commands.drive.DriveUntilObstacleCommand;
import org.yetirobotics.frc.team3506.robot.commands.drive.FollowCommand;
import org.yetirobotics.frc.team3506.robot.commands.drive.UniversalDriveCommand;
import org.yetirobotics.frc.team3506.robot.commands.robotarm.OperateClawCommand;
import org.yetirobotics.frc.team3506.robot.commands.robotarm.PullBeltCommand;
import org.yetirobotics.frc.team3506.robot.commands.robotarm.PushBeltCommand;
import org.yetirobotics.frc.team3506.robot.domain.RobotInput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftJoy;
	private Joystick rightJoy;
	private Joystick armJoy;

	public OI() {
		leftJoy = new Joystick(LEFT_JOYSTICK);
		rightJoy = new Joystick(RIGHT_JOYSTICK);
		armJoy = new Joystick(ARM_JOYSTICK);
		
		//Toggle LEDs
		setJoystickButtonCommand(leftJoy, 11, new ToggleLightsCommand());
		//Fail-safe
		setJoystickButtonCommand(leftJoy, 7, new RebootCommand());
		//Start the compressor
		setJoystickButtonCommand(leftJoy, 8, new StartCompressorCommand());
		//Stop the compressor
		setJoystickButtonCommand(leftJoy, 9, new StopCompressorCommand());
		//Change LED speed
		setJoystickButtonCommand(leftJoy, 10, new ChangeLightSpeedCommand());
		//Start recording
		setJoystickButtonCommand(leftJoy, 4, new RecordCommand());
		//Load recording
		setJoystickButtonCommand(leftJoy, 5, new LoadRecordingCommand());
		//Sonar follow
		setJoystickButtonCommand(rightJoy, 6, new FollowCommand());
		//Drive until an object is encountered
		setJoystickButtonCommand(rightJoy, 7, new DriveUntilObstacleCommand(0.15));
		//Reset the gyro
		setJoystickButtonCommand(rightJoy, 10, new ResetGyroCommand());
		//Testing universal drive command
		setJoystickButtonCommand(rightJoy, 9, new UniversalDriveCommand(164, 0.2, 0));
		setJoystickButtonCommand(rightJoy, 11, new UniversalDriveCommand(0, 0.5, 3));
		//Testing robot arm command
		setJoystickButtonCommand(armJoy, 1, new OperateClawCommand());
		setJoystickButtonCommand(armJoy, 3, new PushBeltCommand());
		setJoystickButtonCommand(armJoy, 2, new PullBeltCommand());
		setJoystickButtonCommand(armJoy, 6, new ToggleElevatorCommand());
	}
	

	private double deadZoneMod(double joyVal){
		if (Math.abs(joyVal) > 0.1) {
			return -joyVal;
		} else {
			return 0.0;
		}
	}

	public double getLeftY(){
		return deadZoneMod(leftJoy.getY());
	}
	
	public double getRightY() {
		return deadZoneMod(rightJoy.getY());
	}
	
	public double getArmY(){
		return deadZoneMod(armJoy.getY());
	}

	public Joystick getLeftJoystick() {
		return leftJoy;
	}
	
	public Joystick getRightJoystick() {
		return rightJoy;
	}
	
	private void setJoystickButtonCommand(Joystick joystick, int button,
			Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
		if (leftJoy == joystick) {
			RobotInput.leftCommands[button - 1] = command;
		} else if (rightJoy == joystick) {
			RobotInput.rightCommands[button - 1] = command;	
		}
	}
}
