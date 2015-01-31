package org.yetirobotics.frc.team3506.robot;

import static org.yetirobotics.frc.team3506.robot.RobotMap.LEFT_JOYSTICK;
import static org.yetirobotics.frc.team3506.robot.RobotMap.RIGHT_JOYSTICK;

import org.yetirobotics.frc.team3506.robot.commands.ChangeLightSpeedCommand;
import org.yetirobotics.frc.team3506.robot.commands.DriveUntilObstacleCommand;
import org.yetirobotics.frc.team3506.robot.commands.FollowCommand;
import org.yetirobotics.frc.team3506.robot.commands.RebootCommand;
import org.yetirobotics.frc.team3506.robot.commands.RecordCommand;
import org.yetirobotics.frc.team3506.robot.commands.ResetGyroCommand;
import org.yetirobotics.frc.team3506.robot.commands.StartCompressorCommand;
import org.yetirobotics.frc.team3506.robot.commands.StopCompressorCommand;
import org.yetirobotics.frc.team3506.robot.commands.ToggleLightsCommand;
import org.yetirobotics.frc.team3506.robot.commands.UniversalDriveCommand;
import org.yetirobotics.frc.team3506.robot.domain.RobotInput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	private Joystick leftJoy;
	private Joystick rightJoy;

	public OI() {
		leftJoy = new Joystick(LEFT_JOYSTICK);
		rightJoy = new Joystick(RIGHT_JOYSTICK);
		
		//Toggle LEDs
		setJoystickButtonCommand(leftJoy, 4, new ToggleLightsCommand());
		//Fail-safe
		setJoystickButtonCommand(leftJoy, 7, new RebootCommand());
		//Start the compressor
		setJoystickButtonCommand(leftJoy, 8, new StartCompressorCommand());
		//Stop the compressor
		setJoystickButtonCommand(leftJoy, 9, new StopCompressorCommand());
		//Change LED speed
		setJoystickButtonCommand(leftJoy, 10, new ChangeLightSpeedCommand());
		//Start recording
		setJoystickButtonCommand(leftJoy, 11, new RecordCommand());
		
		//Sonar follow
		setJoystickButtonCommand(rightJoy, 6, new FollowCommand());
		//Drive until an object is encountered
		setJoystickButtonCommand(rightJoy, 7, new DriveUntilObstacleCommand(0.15));
		//Reset the gyro
		setJoystickButtonCommand(rightJoy, 10, new ResetGyroCommand());
		//Testing universal drive command
		setJoystickButtonCommand(rightJoy, 9, new UniversalDriveCommand(164, 0.2, 0));
		setJoystickButtonCommand(rightJoy, 11, new UniversalDriveCommand(0, 0.5, 3));
		
		
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
