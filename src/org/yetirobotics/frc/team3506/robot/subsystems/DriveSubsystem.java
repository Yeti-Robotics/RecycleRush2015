/**
 * 
 */
package org.yetirobotics.frc.team3506.robot.subsystems;

import static org.yetirobotics.frc.team3506.robot.RobotMap.*;

import org.yetirobotics.frc.team3506.robot.Robot;
import org.yetirobotics.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author acampbell
 *
 */
public class DriveSubsystem extends Subsystem {

	RobotDrive tankDrive;
	Gyro gyro;

	public DriveSubsystem() {
		gyro = Robot.sensorBase.getGyro();
		tankDrive = new RobotDrive(LEFT_FRONT_PORT, LEFT_BACK_PORT,
				RIGHT_FRONT_PORT, RIGHT_BACK_PORT);
		tankDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		tankDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}

	public void userDrive() {
		tankDrive.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
		resetGyro();
	}

	public void rightTurn(double speed) {
			System.out.println("Current angle:\t"+gyro.getAngle());
			tankDrive.setLeftRightMotorOutputs(speed, -speed);
	}
	
	public void leftTurn(double speed) {
			System.out.println("Current angle:\t"+gyro.getAngle());
			tankDrive.setLeftRightMotorOutputs(-speed, speed);
	}
	
	public void driveStraight(double speed) {
		tankDrive.setLeftRightMotorOutputs(speed, speed);
	}
	
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void stopMotors() {
		tankDrive.stopMotor();
	}
	
	public void log() {
		
	}

}
