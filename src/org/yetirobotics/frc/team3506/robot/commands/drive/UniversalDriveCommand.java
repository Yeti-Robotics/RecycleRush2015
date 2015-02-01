package org.yetirobotics.frc.team3506.robot.commands.drive;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UniversalDriveCommand extends Command {
	Gyro gyro;
	Encoder leftFront;
	double angle;
	double speed;
	double distance;
	double distanceTraveled;
	boolean isFinished;

	public UniversalDriveCommand(double angle, double speed, double distance) {
		requires(Robot.drive);
		requires(Robot.sensorBase);
		this.angle = angle;
		this.speed = speed;
		this.distance = distance;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		gyro = Robot.sensorBase.getGyro();
		leftFront = Robot.sensorBase.getLeftEncoder();
		gyro.reset();
		leftFront.reset();
		distanceTraveled = 0;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putData("Encoder", leftFront);
		SmartDashboard.putNumber("Distance traveled:", distanceTraveled);

		if (angle == 0) {
			Robot.drive.driveStraight(speed);
			distanceTraveled = -leftFront.getDistance();// * -0.006;
		} else if (angle < 0) {
			Robot.drive.leftTurn(speed);
		} else {
			Robot.drive.rightTurn(speed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (angle == 0) {
			if (distanceTraveled < distance) {
				return false;
			} else {
				return true;
			}
		} else if (angle < 0) {
			return (gyro.getAngle()<=angle);
		} else {
			return (gyro.getAngle()>=angle);
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.stopMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
