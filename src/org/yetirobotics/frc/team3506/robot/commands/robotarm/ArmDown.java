package org.yetirobotics.frc.team3506.robot.commands.robotarm;

import org.yetirobotics.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDown extends Command {

    double speed;

	public ArmDown(double speed) {
    	requires(Robot.robotarm);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.robotarm.armDown(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.robotarm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
