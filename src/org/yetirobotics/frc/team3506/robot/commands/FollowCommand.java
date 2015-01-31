package org.yetirobotics.frc.team3506.robot.commands;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FollowCommand extends Command {
	AnalogInput sonar;

    public FollowCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.drive);
    		requires(Robot.sensorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		sonar = Robot.sensorBase.getSonar();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double distance = sonar.getVoltage();
    		if (distance > 0.3) {
    			Robot.drive.driveStraight(0.2);
    		} else if (distance < 0.1) {
    			Robot.drive.driveStraight(-0.2);
    		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
