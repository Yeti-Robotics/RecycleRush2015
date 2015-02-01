package org.yetirobotics.frc.team3506.robot.commands.drive;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilObstacleCommand extends Command {
	AnalogInput sonar;
	double distance;

    public DriveUntilObstacleCommand(double distance) {
    		requires(Robot.drive);
    		requires(Robot.sensorBase);
    		this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		sonar = Robot.sensorBase.getSonar();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if (sonar.getVoltage() > distance + 0.1) {
    			Robot.drive.driveStraight(0.2);
    		} else {
    			Robot.drive.driveStraight(0.15);
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    		return sonar.getVoltage() <= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
